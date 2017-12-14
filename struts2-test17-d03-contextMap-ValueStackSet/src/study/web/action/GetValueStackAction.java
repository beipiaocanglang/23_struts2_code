package study.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import study.web.domain.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * �����ݵ�valueStack��
 * @author yeying
 */
public class GetValueStackAction extends ActionSupport{
	
	private String name = "�������еĲ���";
	
	public String valueStackDemo() throws Exception{
		//�õ�ActionContext����
		ActionContext context = ActionContext.getContext();
		//ʹ��ActionContext�еķ���ֱ�ӻ�ȡ
		ValueStack valueStack3 = context.getValueStack();
		
		Student student = new Student("canglang",726);
		
		valueStack3.push(student);
		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
