package study.web.action;

import org.apache.commons.lang3.StringUtils;

import study.web.domain.Student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 学生注册案例的动作类
 * @author canglang
 */
public class StudentRegister extends ActionSupport implements ModelDriven<Student> {

	private Student student = new Student();
	
	@Override
	public Student getModel() {
		return student;
	}
	
	public String userRegister(){
		System.out.println("注册成功");
		return SUCCESS;
	}
	
	/**
	 * 方法一：原始的表单校验
	 * 弊端：如果有多个类中的多个方法多需要校验，就需要在每一个类的每一个放过中编写代码进行校验
	 * @return
	 */
	/*public String userRegister(){
		if (StringUtils.isBlank(student.getUsername())) {
			addFieldError("username", "用户名不能为空");
			return INPUT;//从哪里来回哪里去
		} 
		return SUCCESS;
	}*/
	/**
	 * 方法二：
	 * 	重写ActionSupport接口中的validate方法，struts2在执行所有的动作方法之前都会先执行alidatefangf
	 * 	此方法是默认的验证方法,在执行动作类的动作方法之前,会先执行该方法.
	 *  对所有的动作方法都会验证
	 * 
	 *  有些方法不需要验证(例如查询)，所以需要跳过验证
	 *  	注意：
	 *  		方法一和方法二使用的时机：哪个写的少用哪个
	 *  		例如：
	 *  			有十个方法，两个需要验证就使用方法二
	 *  			有十个方法，两个不需要验证使用方法一
	 *  	第一种方式:
	 * 	   		使用@SkipValidation注解：在需要跳过的方法上添加此注解跳过验证
	 * @return
	 */
	/*public void validate(){
		if(StringUtils.isBlank(student.getUsername())){
			addFieldError("username", "用户名不能为空");
		}
	}*/
	
	/**
	 * 跳过验证的第二种方式:
	 * 	 使用   validate+动作方法(action的method属性或者是方法名)名称    来组成验证方法的名称。动作方法名称的首字母大写
	 * 	例如：注册需要验证:validateRegist
	 * @return
	 */
	/*public void validateRegist(){
		if(StringUtils.isBlank(student.getUsername())){
			addFieldError("username", "用户名不能为空");
		}
	} */
}
