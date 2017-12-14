package study.web.finalcaseaction.service.impl;

import java.util.List;

import study.web.finalcaseaction.dao.IUserDao;
import study.web.finalcaseaction.dao.impl.UserDaoImpl;
import study.web.finalcaseaction.domain.User;
import study.web.finalcaseaction.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao dao = new UserDaoImpl();
	
	/**
	 * 用户登录
	 */
	public User login(String logonName, String logonPwd) {
		return dao.selectUserByInfo(logonName,logonPwd);
	}

	/**
	 * 添加用户-保存用户
	 * @param user
	 * @return
	 */
	public int saveUser(User user) {
		return dao.addUser(user);
	}

	/**
	 * 保存编辑后的用户信息
	 * @param user
	 * @return
	 */
	public int modifyUser(User user) {
		return dao.updateUser(user);
	}

	/**
	 * 根据用户id，删除用户
	 * @param userID
	 * @return
	 */
	public int removeUser(Integer userID) {
		return dao.deleteUser(userID);
	}

	/**
	 * 根据用户id，获取用户信息
	 * @param userID
	 * @return
	 */
	public User findUserById(Integer userID) {
		return dao.selectUserById(userID);
	}

	/**
	 * 查询中间右侧所有用户
	 * @return
	 */
	public List<User> findAllUser() {
		return dao.selectAllUser();
	}

	/**
	 * 根据条件查询用户信息
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
