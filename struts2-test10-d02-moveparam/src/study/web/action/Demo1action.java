package study.web.action;

import study.web.user.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 封装请求参数--静态封装
 * @author canglang
 */
public class Demo1action extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String demo01(){
		System.out.println(user.getName());
		System.out.println(user.getAge());
		return SUCCESS;
	}

}
