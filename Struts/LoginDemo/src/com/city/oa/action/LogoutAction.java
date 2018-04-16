package com.city.oa.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletContextAware,ServletRequestAware{
	
	private ServletContext servletContext = null;
	private HttpSession session = null;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Integer num = (Integer)servletContext.getAttribute("num");
		num = num - 1;
		servletContext.setAttribute("num", num);
		session.invalidate();
		return "success";
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		session = arg0.getSession();
	}
}
