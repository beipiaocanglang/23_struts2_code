package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Hello4Action extends ActionSupport{
	//添加用户
	public String addUser(){
		System.out.println("添加了一个用户");
		return SUCCESS;
	}
	//删除用户
	public String deleteUser(){
		System.out.println("删除用户成功");
		return SUCCESS;
	}
	//修改用户
	public String updataUser(){
		System.out.println("修改用户成功");
		return SUCCESS;
	}
	//查找一个用户
	public String findUser(){
		System.out.println("查找了一个用户");
		return SUCCESS;
	}
}
