package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �������ĵ�һ��������
 * @author canglang
 */
public class DemoAction1 extends ActionSupport {

	public String demo1(){
		System.out.println("Demo1����ִ����");
		return SUCCESS;
	}
}
