package study.web.finalcaseaction.service.impl;

import java.util.List;

import study.web.finalcaseaction.dao.IUserDao;
import study.web.finalcaseaction.dao.impl.UserDaoImpl;
import study.web.finalcaseaction.domain.User;
import study.web.finalcaseaction.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao dao = new UserDaoImpl();
	
	/**
	 * �û���¼
	 */
	public User login(String logonName, String logonPwd) {
		return dao.selectUserByInfo(logonName,logonPwd);
	}

	/**
	 * ����û�-�����û�
	 * @param user
	 * @return
	 */
	public int saveUser(User user) {
		return dao.addUser(user);
	}

	/**
	 * ����༭����û���Ϣ
	 * @param user
	 * @return
	 */
	public int modifyUser(User user) {
		return dao.updateUser(user);
	}

	/**
	 * �����û�id��ɾ���û�
	 * @param userID
	 * @return
	 */
	public int removeUser(Integer userID) {
		return dao.deleteUser(userID);
	}

	/**
	 * �����û�id����ȡ�û���Ϣ
	 * @param userID
	 * @return
	 */
	public User findUserById(Integer userID) {
		return dao.selectUserById(userID);
	}

	/**
	 * ��ѯ�м��Ҳ������û�
	 * @return
	 */
	public List<User> findAllUser() {
		return dao.selectAllUser();
	}

	/**
	 * ����������ѯ�û���Ϣ
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	public List<User> findUserByCondition(String userName, String gender,String education, String isUpload) {
		return dao.selectUserByCondition(userName,gender,education,isUpload);
	}

}
