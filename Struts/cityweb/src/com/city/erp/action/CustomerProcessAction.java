package com.city.erp.action;

import com.city.erp.model.UserModel;
import com.city.erp.service.IUserService;
import com.city.erp.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerProcessAction extends ActionSupport{
	private UserModel userModel = null;
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		IUserService userService = new UserServiceImpl();
		System.out.println(userModel.getId());
		System.out.println(userModel.getName());
		System.out.println(userModel.getPerson());
		userService.add(userModel);
//		ActionContext actionContext = 
		return "success";
	}
}
