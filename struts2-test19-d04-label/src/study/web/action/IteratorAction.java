package study.web.action;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.PRIVATE_MEMBER;

import study.web.domain.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * iterator��ǩ��ʹ��
 * @author yeying
 */
public class IteratorAction extends ActionSupport {

	private List<Student> students;
	
	public String iteratorDemo(){
		
		//��ʽһ����ȡgetValueStack����ʹ��valueStack.push(students);������ѹջ
		/*ActionContext context = ActionContext.getContext();
		ValueStack valueStack = context.getValueStack();*/
		
		/*students = new ArrayList<Student>();
		
		students.add(new Student("demo1", 22));
		students.add(new Student("demo2", 23));
		students.add(new Student("demo3", 24));
		valueStack.push(students);*/
		
		//��ʽ����ֱ�Ӵ������󼴿ɣ�Ĭ��ջ��Ԫ���ǵ�ǰ�����Ķ�����
		students = new ArrayList<Student>();
				
		students.add(new Student("demo1", 22));
		students.add(new Student("demo2", 23));
		students.add(new Student("demo3", 25));
		return SUCCESS;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
