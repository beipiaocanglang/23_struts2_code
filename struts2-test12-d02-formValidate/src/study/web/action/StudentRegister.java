package study.web.action;

import org.apache.commons.lang3.StringUtils;

import study.web.domain.Student;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * ѧ��ע�᰸���Ķ�����
 * @author canglang
 */
public class StudentRegister extends ActionSupport implements ModelDriven<Student> {

	private Student student = new Student();
	
	@Override
	public Student getModel() {
		return student;
	}
	
	public String userRegister(){
		System.out.println("ע��ɹ�");
		return SUCCESS;
	}
	
	/**
	 * ����һ��ԭʼ�ı�У��
	 * �׶ˣ�����ж�����еĶ����������ҪУ�飬����Ҫ��ÿһ�����ÿһ���Ź��б�д�������У��
	 * @return
	 */
	/*public String userRegister(){
		if (StringUtils.isBlank(student.getUsername())) {
			addFieldError("username", "�û�������Ϊ��");
			return INPUT;//��������������ȥ
		} 
		return SUCCESS;
	}*/
	/**
	 * ��������
	 * 	��дActionSupport�ӿ��е�validate������struts2��ִ�����еĶ�������֮ǰ������ִ��alidatefangf
	 * 	�˷�����Ĭ�ϵ���֤����,��ִ�ж�����Ķ�������֮ǰ,����ִ�и÷���.
	 *  �����еĶ�������������֤
	 * 
	 *  ��Щ��������Ҫ��֤(�����ѯ)��������Ҫ������֤
	 *  	ע�⣺
	 *  		����һ�ͷ�����ʹ�õ�ʱ�����ĸ�д�������ĸ�
	 *  		���磺
	 *  			��ʮ��������������Ҫ��֤��ʹ�÷�����
	 *  			��ʮ����������������Ҫ��֤ʹ�÷���һ
	 *  	��һ�ַ�ʽ:
	 * 	   		ʹ��@SkipValidationע�⣺����Ҫ�����ķ�������Ӵ�ע��������֤
	 * @return
	 */
	/*public void validate(){
		if(StringUtils.isBlank(student.getUsername())){
			addFieldError("username", "�û�������Ϊ��");
		}
	}*/
	
	/**
	 * ������֤�ĵڶ��ַ�ʽ:
	 * 	 ʹ��   validate+��������(action��method���Ի����Ƿ�����)����    �������֤���������ơ������������Ƶ�����ĸ��д
	 * 	���磺ע����Ҫ��֤:validateRegist
	 * @return
	 */
	/*public void validateRegist(){
		if(StringUtils.isBlank(student.getUsername())){
			addFieldError("username", "�û�������Ϊ��");
		}
	} */
}
