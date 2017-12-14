package study.web.finalcaseaction.dao;

import java.util.List;

import study.web.finalcaseaction.domain.User;

/**
 * �û�������س־ò�ӿ�
 * @author zhy
 *
 */
public interface IUserDao {
	
	/**
	 * �����û��ĵ�¼���������ѯ�û�
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User selectUserByInfo(String logonName, String logonPwd);
	
	/**
	 * �����û�-�����û�
	 * @param user
	 * @return
	 */
	int addUser(User user);
	
	/**
	 * ����༭����û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	
	/**
	 * �����û�id��ɾ���û���Ϣ
	 * @param userID
	 * @return
	 */
	int deleteUser(Integer userID);
	
	/**
	 * �����û�id����ѯ�û���Ϣ
	 * @param userID
	 * @return
	 */
	User selectUserById(Integer userID);
	
	/**
	 * ��ѯ�м��Ҳ������û�
	 * @return
	 */
	List<User> selectAllUser();
	
	/**
	 * ����ָ��������ȡ�û���Ϣ
	 * ��������null��ʱ�򣬱�ʾ��������
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> selectUserByCondition(String userName, String gender,String education, String isUpload);

}