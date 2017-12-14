package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 防止表单重复提交
 * @author canglang
 */
public class LoginAction extends ActionSupport {

	private String username;
	
	public String login(){
		System.out.println("用户名："+username);
		return SUCCESS;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
