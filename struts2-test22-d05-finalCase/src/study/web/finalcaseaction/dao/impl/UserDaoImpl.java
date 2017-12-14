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
	 * 添加用户-保存用户
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
	 * 保存编辑后的用户信息
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
	 * 根据用户id，删除用户信息
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
	 * 根据用户id，查询用户信息
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
	 * 查询中间右侧所有用户
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
	 * 用户登录dao实现类
	 */
	public User selectUserByInfo(String loginName, String loginPwd) {
		try{
			return qr.query("select * from struts2user where loginName=? and loginPwd=? ", new BeanHandler<User>(User.class),loginName,loginPwd);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 多条件查询
	 */
	public List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload) {
		
		//如果上面的所有条件都没选的话
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
					//用户需要使用此条件
					if("true".equals(isUpload)){
						ss.append(" and filename is not null ");//数据库中判断是否为null 不能用!=  =。用的是is not  /is
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
