package study.web.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import study.web.domain.Student;
import study.web.service.IStudentRegister;
import study.web.service.serviceImpl.StudentRegisterImpl;

public class IStudentRegisterTest {

	private IStudentRegister sRegister = new StudentRegisterImpl();
	@Test
	public void testExists() {
		boolean ba = sRegister.exists("test2");
		System.out.println(ba);
	}
	@Test
	public void testRegister() {
		Student student = new Student();
		student.setUsername("test2");
		student.setPassword("123");
		student.setBirthday(new Date());
		student.setHobby("³Ô·¹£¬Ë¯¾õ£¬Ğ´´úÂë");
		student.setMarried(true);
		int register = sRegister.register(student);
		System.out.println(register);
	}
}
