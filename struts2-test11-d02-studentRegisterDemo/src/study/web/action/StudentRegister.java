package study.web.action;

import study.web.domain.Student;
import study.web.service.IStudentRegister;
import study.web.service.serviceImpl.StudentRegisterImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 学生注册案例的动作类
 * @author canglang
 */
public class StudentRegister extends ActionSupport implements ModelDriven<Student> {

	private IStudentRegister studentRegister = new StudentRegisterImpl();
	
	private Student student = new Student();
	
	@Override
	public Student getModel() {
		return student;
	}
	
	public String userRegister(){
		
		boolean exists = studentRegister.exists(student.getUsername());
		
		if (exists) {
			//已经存在
			return "massage";
		}
		//不存在
		int register = studentRegister.register(student);
		
		if (register>0) {
			return SUCCESS;
		}else {
			return ERROR;
		}
		/**
		 * 当动作类执行发生错误时可以使用
		 */
		//addActionError("动作类操作错误");
		/**
		 * 给表单当中的某一个字段做校验时可以使用
		 * fieldName:指定错误字段名称
		 * errorMessage：提示的错误信息
		 */
		//addFieldError("username", "用户名不能为空");
		
		//return SUCCESS;
	}
}
