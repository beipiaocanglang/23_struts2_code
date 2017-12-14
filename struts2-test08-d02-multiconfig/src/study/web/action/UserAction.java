package study.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 多文件编辑struts的配置文件--user模块
 * @author zhy
 */
public class UserAction extends ActionSupport {
	
	public String addUser(){
		System.out.println("保存了一个用户");
		return "success";
	}
}
