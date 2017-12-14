package study.web.action;

import java.security.PublicKey;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ELAction extends ActionSupport {

	String name = "动作类中的name";
	
	public String elDemo(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("name", "请求域中的name");
		
		return SUCCESS;
	}
}
