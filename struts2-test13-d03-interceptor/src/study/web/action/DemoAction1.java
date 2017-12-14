package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 拦截器的第一个测试类
 * @author canglang
 */
public class DemoAction1 extends ActionSupport {

	public String demo1(){
		System.out.println("Demo1方法执行了");
		return SUCCESS;
	}
}
