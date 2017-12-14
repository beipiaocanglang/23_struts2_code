package study.web.service;

import study.web.domain.Student;

/**
 * 学生注册案例的service层接口
 * @author canglang
 */
public interface IStudentRegister {

	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	boolean exists(String username);
	
	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	int register(Student student);
}
