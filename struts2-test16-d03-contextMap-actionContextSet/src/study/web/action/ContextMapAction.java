package study.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 向contextMap上下文中存放数据--map
 * 见图3
 * 方式一：使用struts2框架提供的ActionContext
 * 方式二：使用原始的ServletAPI
 * @author yeying
 */
public class ContextMapAction extends ActionSupport {

	public String contextMapDemo(){
		//1.获取到ActionContext对象
		ActionContext context = ActionContext.getContext();//从当前线程上获取(框架提供)
		//2.往大map中存入数据
		context.put("contextMap", "hello context map");
		
		//3.往指定的小Map中存入数据（request,session,application）
		//Map<String,Object> sessionMap = (Map<String, Object>) context.get("session");
		//第一种方式:使用map操作
		Map<String,Object> sessionMap = context.getSession();//(框架提供)
		sessionMap.put("sessionMap", "hello session map");
		//第二种方式:使用原始ServletAPI存入数据
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionAttr","hello session attribute");
		
		//4.往application的map中存入数据
		//第一种方式:使用map操作
		Map<String,Object> applicationMap = context.getApplication();//(框架提供)
		applicationMap.put("applicationMap", "hello application map");
		//第二种方式：使用原始ServletAPI对象
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("applicationAttr", "hello application attribute");
		
		//5.往request的map中存放数据
		//方式一：使用map操作数据
		Map<String,Object> requestMap = (Map<String, Object>) context.get("request");
		requestMap.put("requestMap", "hello requestMap");
		//方式二：使用原始ServletAPI对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("servletRequestMap", "hello servletResult");
		return SUCCESS;
	}
}
