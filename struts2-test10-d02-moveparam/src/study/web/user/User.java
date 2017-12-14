package study.web.user;

import java.io.Serializable;

/**
 * user对象的实体类
 * @author canglang
 */
public class User implements Serializable {

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
}
