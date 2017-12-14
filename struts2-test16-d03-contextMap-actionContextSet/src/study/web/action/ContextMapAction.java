package study.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��contextMap�������д������--map
 * ��ͼ3
 * ��ʽһ��ʹ��struts2����ṩ��ActionContext
 * ��ʽ����ʹ��ԭʼ��ServletAPI
 * @author yeying
 */
public class ContextMapAction extends ActionSupport {

	public String contextMapDemo(){
		//1.��ȡ��ActionContext����
		ActionContext context = ActionContext.getContext();//�ӵ�ǰ�߳��ϻ�ȡ(����ṩ)
		//2.����map�д�������
		context.put("contextMap", "hello context map");
		
		//3.��ָ����СMap�д������ݣ�request,session,application��
		//Map<String,Object> sessionMap = (Map<String, Object>) context.get("session");
		//��һ�ַ�ʽ:ʹ��map����
		Map<String,Object> sessionMap = context.getSession();//(����ṩ)
		sessionMap.put("sessionMap", "hello session map");
		//�ڶ��ַ�ʽ:ʹ��ԭʼServletAPI��������
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("sessionAttr","hello session attribute");
		
		//4.��application��map�д�������
		//��һ�ַ�ʽ:ʹ��map����
		Map<String,Object> applicationMap = context.getApplication();//(����ṩ)
		applicationMap.put("applicationMap", "hello application map");
		//�ڶ��ַ�ʽ��ʹ��ԭʼServletAPI����
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("applicationAttr", "hello application attribute");
		
		//5.��request��map�д������
		//��ʽһ��ʹ��map��������
		Map<String,Object> requestMap = (Map<String, Object>) context.get("request");
		requestMap.put("requestMap", "hello requestMap");
		//��ʽ����ʹ��ԭʼServletAPI����
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("servletRequestMap", "hello servletResult");
		return SUCCESS;
	}
}
