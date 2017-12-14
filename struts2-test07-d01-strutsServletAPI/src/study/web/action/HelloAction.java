package study.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * struts2访问ServletAPI
 * @author zhy
 */
public class HelloAction extends ActionSupport {
	
	public String sayHello(){
		
		//ServletAPI的API中的对象
		
		//--------request对象是struts2提供的,struts2框架使用了装饰者模式对request对象进行了加强---------
		HttpServletRequest request = ServletActionContext.getRequest();
		//--------以下三个是tomcat提供的---------
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		ServletContext application = ServletActionContext.getServletContext();
		/*
		 * 请注意输出的结果:
		 	--------request对象是struts2提供的,struts2框架使用了装饰者模式对request对象进行了加强---------
		 	org.apache.struts2.dispatcher.StrutsRequestWrapper@172616f
		 	
		 	--------以下三个是tomcat提供的---------
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
