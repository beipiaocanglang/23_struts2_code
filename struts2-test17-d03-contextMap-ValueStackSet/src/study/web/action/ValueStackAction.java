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
 * �����ݵ�valueStack��
 * @author yeying
 */
public class ValueStackAction extends ActionSupport {

	public String valueStackDemo(){
		//��ȡValueStacvk���������
		
		//��ʽһ����ҳ��չ��s:debug��ǩ,�ҵ��������ڵ�λ�ã�������requestMap�У����Կ���ʹ��requestMap.key()��ȡ
		//�õ�ActionContext����
		ActionContext context = ActionContext.getContext();
		//ʹ��context��ȡrequestMap
		Map<String, Object> requestMap = (Map<String, Object>)context.get("request");
		//����ValueStack��key��ȡ�ö���
		ValueStack valueStack1 = (ValueStack)requestMap.get("struts.valueStack");
		
		//��ʽ����ʹ��request�����getAttribute��ȡ
		//��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack valueStack2 = (ValueStack)request.getAttribute("struts.valueStack");
		
		//��ʽ����ʹ��ActionContext�еķ���ֱ�ӻ�ȡ
		ValueStack valueStack3 = context.getValueStack();
		Student student = new Student("canglang",26);
		valueStack3.push(student);
		
		
		Map<String, Object> contextMap = valueStack3.getContext();
		Map<String, Object> reMap = (Map<String, Object>)contextMap.get("request");
		ValueStack valueStack4 = (ValueStack)reMap.get("struts.valueStack");
		
		//valueStack1...valueStack4 ָ�������һ������
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
