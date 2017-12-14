package study.web.action;

import study.web.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveUserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}

	public String saveUser(){
		System.out.println("±£´æ³É¹¦");
		return SUCCESS;
	}
}
