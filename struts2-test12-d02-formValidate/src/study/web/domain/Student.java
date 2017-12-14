package study.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生注册的实体类
 * @author canglang
 */
public class Student implements Serializable {

	private String username;//用户名
	private String password;//密码
	private Date birthday;//生日
	private String hobby;//爱好
	private boolean married;//是否已婚
	
	
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
