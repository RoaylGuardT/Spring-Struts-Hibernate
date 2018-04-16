package com.city.oa.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.city.oa.factory.HibernateFactory;
import com.city.oa.model.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletContextAware{
	private String success = "success";
	private String failed = "failed";
	
	
	private UserModel userModel = null;
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
	private ServletContext servletContext = null;
	
	int check() {
		try {
			SessionFactory sf = HibernateFactory.createSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			String sql = "from UserModel";
			Query<UserModel> query = session.createQuery(sql,UserModel.class);
			List<UserModel> list = query.getResultList();
			tx.commit();
			session.close();
			for (UserModel user : list) {
				if (user.getUsername().equals(userModel.getUsername())) {
					if(user.getPassword().equals(userModel.getPassword()))
						return 1;
					else
						return 2;
				}
			}
			return 3;
		} catch (Exception e) {
			e.printStackTrace();
			return 3;
		}
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String answer = null;
		switch (check()) {
		case 1:
			ActionContext actionContext = ActionContext.getContext();
			Map session = (Map)actionContext.getSession();
			session.put("username", userModel.getUsername());
			session.put("password", userModel.getPassword());
			Integer num = (Integer)servletContext.getAttribute("num");
			if(num == null)
				num = 1;
			else
				num = num + 1;
			servletContext.setAttribute("num", num);
			answer = success;
			break;
		case 2:
			this.addActionError("密码错误");
			answer = failed;
			break;
		case 3:
			this.addActionError("用户名不存在");
			answer = failed;
			break;
		default:
			this.addActionError("登陆错误");
			answer = failed;
			break;
		}
		return answer;
	}
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		servletContext = arg0;
	}
	public ServletContext getServletContext() {
		return servletContext;
	}

}
