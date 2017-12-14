package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhy
 */
public class HelloAction extends ActionSupport {
	
	public String sayHello(){
		System.out.println("struts的第一个入门案例sayHello执行了！");
		return "success";
	}
}
