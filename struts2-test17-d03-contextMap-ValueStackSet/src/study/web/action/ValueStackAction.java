package study.web.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import study.web.domain.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 存数据到valueStack中
 * @author yeying
 */
public class ValueStackAction extends ActionSupport {

	public String valueStackDemo(){
		//获取ValueStacvk对象的引用
		
		//方式一：在页面展开s:debug标签,找到对象所在的位置，发现在requestMap中，所以可以使用requestMap.key()获取
		//拿到ActionContext对象
		ActionContext context = ActionContext.getContext();
		//使用context获取requestMap
		Map<String, Object> requestMap = (Map<String, Object>)context.get("request");
		//根据ValueStack的key获取该对象
		ValueStack valueStack1 = (ValueStack)requestMap.get("struts.valueStack");
		
		//方式二：使用request对象的getAttribute获取
		//获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack valueStack2 = (ValueStack)request.getAttribute("struts.valueStack");
		
		//方式三：使用ActionContext中的方法直接获取
		ValueStack valueStack3 = context.getValueStack();
		Student student = new Student("canglang",26);
		valueStack3.push(student);
		
		
		Map<String, Object> contextMap = valueStack3.getContext();
		Map<String, Object> reMap = (Map<String, Object>)contextMap.get("request");
		ValueStack valueStack4 = (ValueStack)reMap.get("struts.valueStack");
		
		//valueStack1...valueStack4 指向的是用一个区域
		System.out.println(valueStack1);//com.opensymphony.xwork2.ognl.OgnlValueStack@428e690a
		System.out.println(valueStack2);//com.opensymphony.xwork2.ognl.OgnlValueStack@428e690a
		System.out.println(valueStack3);//com.opensymphony.xwork2.ognl.OgnlValueStack@428e690a
		System.out.println(valueStack4);//com.opensymphony.xwork2.ognl.OgnlValueStack@428e690a
		System.out.println("valueStack1 hashCode is :"+valueStack1.hashCode());//1116629258
		System.out.println("valueStack2 hashCode is :"+valueStack2.hashCode());//1116629258
		System.out.println("valueStack3 hashCode is :"+valueStack3.hashCode());//1116629258
		System.out.println("valueStack3 hashCode is :"+valueStack4.hashCode());//1116629258
		
		return SUCCESS;
	}
}
