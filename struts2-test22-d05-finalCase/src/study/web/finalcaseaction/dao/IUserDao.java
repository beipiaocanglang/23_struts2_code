package study.web.finalcaseaction.dao;

import java.util.List;

import study.web.finalcaseaction.domain.User;

/**
 * 用户操作相关持久层接口
 * @author zhy
 *
 */
public interface IUserDao {
	
	/**
	 * 根据用户的登录名和密码查询用户
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User selectUserByInfo(String logonName, String logonPwd);
	
	/**
	 * 添加用户-保存用户
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * 保存编辑后的用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * 根据用户id，删除用户信息
	 * @param userID
	 * @return
	 */
	int deleteUser(Integer userID);
	
	/**
	 * 根据用户id，查询用户信息
	 * @param userID
	 * @return
	 */
	User selectUserById(Integer userID);
	
	/**
	 * 查询中间右侧所有用户
	 * @return
	 */
	List<User> selectAllUser();
	
	/**
	 * 根据指定条件获取用户信息
	 * 当条件是null的时候，表示忽略条件
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> selectUserByCondition(String userName, String gender,String education, String isUpload);

}
