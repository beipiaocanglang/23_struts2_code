package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ֹ���ظ��ύ
 * @author canglang
 */
public class LoginAction extends ActionSupport {

	private String username;
	
	public String login(){
		System.out.println("�û�����"+username);
		return SUCCESS;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
