package study.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Hello4Action extends ActionSupport{
	//����û�
	public String addUser(){
		System.out.println("�����һ���û�");
		return SUCCESS;
	}
	//ɾ���û�
	public String deleteUser(){
		System.out.println("ɾ���û��ɹ�");
		return SUCCESS;
	}
	//�޸��û�
	public String updataUser(){
		System.out.println("�޸��û��ɹ�");
		return SUCCESS;
	}
	//����һ���û�
	public String findUser(){
		System.out.println("������һ���û�");
		return SUCCESS;
	}
}
