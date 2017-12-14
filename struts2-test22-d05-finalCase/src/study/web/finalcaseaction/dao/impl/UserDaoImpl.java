package study.web.finalcaseaction.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import study.web.finalcaseaction.dao.IUserDao;
import study.web.finalcaseaction.domain.User;
import study.web.finalcaseaction.utils.DBCPUtil;

public class UserDaoImpl implements IUserDao {

private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	/**
	 * ����û�-�����û�
	 * @param user
	 * @return
	 */
	public int addUser(User user) {
		try{
			return qr.update("insert into struts2user(userID,userName,loginName,loginPwd,gender,birthday,education,telephone,hobby,path,filename,remark)values(?,?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserID(),user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getHobby(),user.getPath(),user.getFilename(),user.getRemark());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * ����༭����û���Ϣ
	 * @param user
	 * @return
	 */
	public int updateUser(User user) {
		try{
			return qr.update("update struts2user set userName=?,loginName=?,loginPwd=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where userID = ?",
					user.getUserName(),user.getLoginName(),user.getLoginPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),
					user.getHobby(),user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * �����û�id��ɾ���û���Ϣ
	 * @param userID
	 * @return
	 */
	public int deleteUser(Integer userid) {
		try{
			return qr.update("delete from struts2user where userID = ?",userid);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * �����û�id����ѯ�û���Ϣ
	 * @param userID
	 * @return
	 */
	public User selectUserById(Integer userid) {
		try{
			return qr.query("select * from struts2user where userID = ? ", new BeanHandler<User>(User.class),userid);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��ѯ�м��Ҳ������û�
	 * @return
	 */
	public List<User> selectAllUser() {
		try{
			return qr.query("select * from struts2user ", new BeanListHandler<User>(User.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * �û���¼daoʵ����
	 */
	public User selectUserByInfo(String loginName, String loginPwd) {
		try{
			return qr.query("select * from struts2user where loginName=? and loginPwd=? ", new BeanHandler<User>(User.class),loginName,loginPwd);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��������ѯ
	 */
	public List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload) {
		
		//������������������ûѡ�Ļ�
		if(StringUtils.isBlank(userName) && StringUtils.isBlank(gender) && StringUtils.isBlank(education) && StringUtils.isBlank(isUpload)){
			return selectAllUser();
		}else{
			try {
				List<Object> parameters = new ArrayList<Object>();
				String sql = " select * from struts2user ";
				StringBuffer ss = new StringBuffer(sql);
				ss.append(" where 1=1 ");
				if(StringUtils.isNotBlank(userName)){
					ss.append(" and userName like ? ");
					parameters.add("%"+userName+"%");
				}
				if(StringUtils.isNotBlank(gender)){
					ss.append(" and gender = ? ");
					parameters.add(gender);
				}
				if(StringUtils.isNotBlank(education)){
					ss.append(" and education = ? ");
					parameters.add(education);
				}
				if(StringUtils.isNotBlank(isUpload)){
					//�û���Ҫʹ�ô�����
					if("true".equals(isUpload)){
						ss.append(" and filename is not null ");//���ݿ����ж��Ƿ�Ϊnull ������!=  =���õ���is not  /is
					}else{
						ss.append(" and filename is null ");
					}
				}
				sql = ss.toString();
				return qr.query(sql, new BeanListHandler<User>(User.class),parameters.toArray());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	}

}
