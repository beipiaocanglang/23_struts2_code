package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 封装请求参数--静态封装
 * @author canglang
 */
public class Demo1action extends ActionSupport {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String demo01(){
		System.out.println(name);
		System.out.println(age);
		return SUCCESS;
	}
}
