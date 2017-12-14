package study.web.service.serviceImpl;

import study.web.dao.IStudentRegisterDao;
import study.web.dao.daoImpl.StudentRegisterDaoImpl;
import study.web.domain.Student;
import study.web.service.IStudentRegister;

public class StudentRegisterImpl implements IStudentRegister {

	//创建到层对象
	IStudentRegisterDao dao = new StudentRegisterDaoImpl();

	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	@Override
	public boolean exists(String username) {
		Student s = dao.findStudentByName(username);
		if(s != null){
			return true;
		}
		return false;
	}

	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	@Override
	public int register(Student student) {
		
		return dao.saveStudent(student);
	}
}
