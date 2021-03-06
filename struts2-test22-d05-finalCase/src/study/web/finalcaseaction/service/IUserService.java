package study.web.finalcaseaction.service;

import java.util.List;

import study.web.finalcaseaction.domain.User;


/**
 * 用户操作相关的业务层接口
 * @author zhy
 *
 */
public interface IUserService {
	
	/**
	 * 用户登录
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User login(String logonName,String logonPwd);
	
	/**
	 * 添加用户-保存用户
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * 保存编辑后的用户信息
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	
	/**
	 * 根据用户id，删除用户
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	
	/**
	 * 根据用户id，获取用户信息
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	
	/**
	 * 查询中间右侧所有用户
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * 根据条件查询用户信息
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
