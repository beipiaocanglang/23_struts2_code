package study.web.action;

import com.opensymphony.xwork2.Action;

/**
 * @author zhy
 * implements Action使用实现类中的默认方法
 */
public class Hello2Action implements Action{
	
	@Override
	public String execute() throws Exception {
		System.out.println("实现默认方法执行了*************");
		return SUCCESS;
	}
	
	public String sayHello(){
		System.out.println("struts的第一个入门案例sayHello执行了！");
		return "success";
	}
}
