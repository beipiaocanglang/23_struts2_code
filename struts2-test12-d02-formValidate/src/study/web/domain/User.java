package study.web.domain;

import java.io.Serializable;

/**
 * һ���û���ʵ��
 * @author zhy
 *
 */
public class User implements Serializable {
	
	private String username;//����Ϊnull�����ַ�����ȥ�����ҿո�
	private int age;//Ҫ������������18~100֮��
	private String email;//Ҫ���ո�ʽ����
	private String password;//Ҫ�󣺳�����3~8λ
	private String repassword;//ȷ�����룺Ҫ����������һ�¡�ʵ�ʿ�����֮�У�����Ҫ����ȷ�����롣�˴�ֻ��Ϊ����ʾ��
	private int score;//�ɼ�������������
	private String url;//������ҳ���������URL��ʽ
	private String gender;//�Ա𣺱�����ֵ
	
	
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
