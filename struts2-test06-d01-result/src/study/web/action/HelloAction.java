package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhy
 */
public class HelloAction extends ActionSupport {
	
	public String sayHello(){
		System.out.println("struts�ĵ�һ�����Ű���sayHelloִ���ˣ�");
		return "success";
	}
}
