package study.web.action;

import com.opensymphony.xwork2.Action;

/**
 * @author zhy
 * implements Actionʹ��ʵ�����е�Ĭ�Ϸ���
 */
public class Hello2Action implements Action{
	
	@Override
	public String execute() throws Exception {
		System.out.println("ʵ��Ĭ�Ϸ���ִ����*************");
		return SUCCESS;
	}
	
	public String sayHello(){
		System.out.println("struts�ĵ�һ�����Ű���sayHelloִ���ˣ�");
		return "success";
	}
}
