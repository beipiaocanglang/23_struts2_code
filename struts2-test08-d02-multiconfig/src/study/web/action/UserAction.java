package study.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ļ��༭struts�������ļ�--userģ��
 * @author zhy
 */
public class UserAction extends ActionSupport {
	
	public String addUser(){
		System.out.println("������һ���û�");
		return "success";
	}
}
