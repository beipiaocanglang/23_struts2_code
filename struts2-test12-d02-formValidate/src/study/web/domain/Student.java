package study.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ѧ��ע���ʵ����
 * @author canglang
 */
public class Student implements Serializable {

	private String username;//�û���
	private String password;//����
	private Date birthday;//����
	private String hobby;//����
	private boolean married;//�Ƿ��ѻ�
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
}
