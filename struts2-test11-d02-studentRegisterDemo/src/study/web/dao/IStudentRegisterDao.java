package study.web.dao;

import study.web.domain.Student;

public interface IStudentRegisterDao {

	/**
	 * �ж��û����Ƿ����
	 * @param username
	 * @return
	 */
	Student findStudentByName(String username);

	/**
	 * ѧ��ע��
	 * @param student
	 * @return
	 */
	int saveStudent(Student student);
}
