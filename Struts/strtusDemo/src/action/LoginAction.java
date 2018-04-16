package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

import model.UserModel;

public class LoginAction extends ActionSupport {

	private String admin;
	private String password;
	private String name;
	private String intro;

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserModel user = new UserModel();
		user.setAdmin(admin);
		user.setIntro(intro);
		user.setName(name);
		user.setPassword(password);

		if (add(user)) {
			System.out.println("添加成功");
			return "success";

		} else {
			System.out.println("添加失败");
			return "error";
		}
	}

	public boolean add(UserModel user) {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			session.close();
			sf.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
