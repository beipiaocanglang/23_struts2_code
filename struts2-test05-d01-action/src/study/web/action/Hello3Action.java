package study.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhy
 * extends ActionSupport就不需要implements Action，应为实现类中已经帮你实现好了
 */
@SuppressWarnings("all")
public class Hello3Action extends ActionSupport{
	
	public String sayHello(){
		System.out.println("struts的第一个入门案例sayHello执行了！");
		
		return "success";
	}
}
