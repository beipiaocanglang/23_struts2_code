package study.web.domain;

import java.io.Serializable;

/**
 * 一个用户的实体
 * @author zhy
 *
 */
public class User implements Serializable {
	
	private String username;//不能为null，空字符串，去掉左右空格
	private int age;//要求：整数，且是18~100之间
	private String email;//要求按照格式输入
	private String password;//要求：长度是3~8位
	private String repassword;//确认密码：要求必须和密码一致。实际开发中之中，不需要保存确认密码。此处只是为了演示。
	private int score;//成绩：必须是数字
	private String url;//个人主页：必须符合URL格式
	private String gender;//性别：必须有值
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
