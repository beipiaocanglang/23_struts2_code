package study.web.dao;

import study.web.domain.Student;

public interface IStudentRegisterDao {

	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	Student findStudentByName(String username);

	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	int saveStudent(Student student);
}
