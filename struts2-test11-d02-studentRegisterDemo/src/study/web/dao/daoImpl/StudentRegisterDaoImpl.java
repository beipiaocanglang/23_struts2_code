package study.web.dao.daoImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import study.web.dao.IStudentRegisterDao;
import study.web.domain.Student;
import study.web.util.DBCPUtil;
@SuppressWarnings("all")
public class StudentRegisterDaoImpl implements IStudentRegisterDao {
	
	//创建QueryRunner对象获取数据源
	private QueryRunner qRunner = new QueryRunner(DBCPUtil.getDataSource());
	

	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	@Override
	public Student findStudentByName(String username) {
		try {
			return qRunner.query("select * from student where username = ?", new BeanHandler<Student>(Student.class), username);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 学生注册
	 * @param student
	 * @return
	 */
	@Override
	public int saveStudent(Student student) {
		try {
			return qRunner.update("insert into student(username,password,birthday,hobby,married) values(?,?,?,?,?)",
					student.getUsername(),student.getPassword(),student.getBirthday(),student.getHobby(),student.isMarried());
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
