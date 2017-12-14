package study.web.service;

import study.web.domain.Student;

/**
 * ѧ��ע�᰸����service��ӿ�
 * @author canglang
 */
public interface IStudentRegister {

	/**
	 * �ж��û����Ƿ����
	 * @param username
	 * @return
	 */
	boolean exists(String username);
	
	/**
	 * ѧ��ע��
	 * @param student
	 * @return
	 */
	int register(Student student);
}
