package study.web.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zhy
 * extends ActionSupport�Ͳ���Ҫimplements Action��ӦΪʵ�������Ѿ�����ʵ�ֺ���
 */
@SuppressWarnings("all")
public class Hello3Action extends ActionSupport{
	
	public String sayHello(){
		System.out.println("struts�ĵ�һ�����Ű���sayHelloִ���ˣ�");
		
		return "success";
	}
}
