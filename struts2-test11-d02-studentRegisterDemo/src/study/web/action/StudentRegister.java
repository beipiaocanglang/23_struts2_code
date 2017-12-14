package study.web.action;

import study.web.domain.Student;
import study.web.service.IStudentRegister;
import study.web.service.serviceImpl.StudentRegisterImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * ѧ��ע�᰸���Ķ�����
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
			//�Ѿ�����
			return "massage";
		}
		//������
		int register = studentRegister.register(student);
		
		if (register>0) {
			return SUCCESS;
		}else {
			return ERROR;
		}
		/**
		 * ��������ִ�з�������ʱ����ʹ��
		 */
		//addActionError("�������������");
		/**
		 * �������е�ĳһ���ֶ���У��ʱ����ʹ��
		 * fieldName:ָ�������ֶ�����
		 * errorMessage����ʾ�Ĵ�����Ϣ
		 */
		//addFieldError("username", "�û�������Ϊ��");
		
		//return SUCCESS;
	}
}
