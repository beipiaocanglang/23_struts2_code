package study.web.service.serviceImpl;

import study.web.dao.IStudentRegisterDao;
import study.web.dao.daoImpl.StudentRegisterDaoImpl;
import study.web.domain.Student;
import study.web.service.IStudentRegister;

public class StudentRegisterImpl implements IStudentRegister {

	//�����������
	IStudentRegisterDao dao = new StudentRegisterDaoImpl();

	/**
	 * �ж��û����Ƿ����
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
	 * ѧ��ע��
	 * @param student
	 * @return
	 */
	@Override
	public int register(Student student) {
		
		return dao.saveStudent(student);
	}
}
