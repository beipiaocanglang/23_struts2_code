package study.web.finalcaseaction.service;

import java.util.List;

import study.web.finalcaseaction.domain.User;


/**
 * �û�������ص�ҵ���ӿ�
 * @author zhy
 *
 */
public interface IUserService {
	
	/**
	 * �û���¼
	 * @param logonName
	 * @param logonPwd
	 * @return
	 */
	User login(String logonName,String logonPwd);
	
	/**
	 * ����û�-�����û�
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 * ����༭����û���Ϣ
	 * @param user
	 * @return
	 */
	int modifyUser(User user);
	
	/**
	 * �����û�id��ɾ���û�
	 * @param userID
	 * @return
	 */
	int removeUser(Integer userID);
	
	/**
	 * �����û�id����ȡ�û���Ϣ
	 * @param userID
	 * @return
	 */
	User findUserById(Integer userID);
	
	/**
	 * ��ѯ�м��Ҳ������û�
	 * @return
	 */
	List<User> findAllUser();
	
	/**
	 * ����������ѯ�û���Ϣ
	 * @param userName
	 * @param gender
	 * @param education
	 * @param isUpload
	 * @return
	 */
	List<User> findUserByCondition(String userName,String gender,String education,String isUpload);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
