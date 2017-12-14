package study.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2����ServletAPI
 * @author zhy
 */
public class HelloAction extends ActionSupport {
	
	public String sayHello(){
		
		//ServletAPI��API�еĶ���
		
		//--------request������struts2�ṩ��,struts2���ʹ����װ����ģʽ��request��������˼�ǿ---------
		HttpServletRequest request = ServletActionContext.getRequest();
		//--------����������tomcat�ṩ��---------
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		/*
		 * ��ע������Ľ��:
		 	--------request������struts2�ṩ��,struts2���ʹ����װ����ģʽ��request��������˼�ǿ---------
		 	org.apache.struts2.dispatcher.StrutsRequestWrapper@172616f
		 	
		 	--------����������tomcat�ṩ��---------
			org.apache.catalina.connector.ResponseFacade@5ac448
			org.apache.catalina.session.StandardSessionFacade@10c542d
			org.apache.catalina.core.ApplicationContextFacade@6a6126
		 */
		System.out.println(request);
		System.out.println(response);
		System.out.println(session);
		System.out.println(application);
		return "success";
	}
}
