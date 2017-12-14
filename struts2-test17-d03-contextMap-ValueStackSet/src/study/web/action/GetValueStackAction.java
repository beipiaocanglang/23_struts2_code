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
 * 存数据到valueStack中
 * @author yeying
 */
public class GetValueStackAction extends ActionSupport{
	
	private String name = "动作类中的苍狼";
	
	public String valueStackDemo() throws Exception{
		//拿到ActionContext对象
		ActionContext context = ActionContext.getContext();
		//使用ActionContext中的方法直接获取
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
