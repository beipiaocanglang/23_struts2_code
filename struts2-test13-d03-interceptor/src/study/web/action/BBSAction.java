package study.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �������ĵ�һ��������
 * @author canglang
 */
public class BBSAction extends ActionSupport {

	/**
	 * �汾һ����ÿһ�������ȡһ���¼��֤
	 * �汾��������¼��֤��ȡ�ɹ����ķ���
	 * �汾��������¼��ȡ�����������档�������
	 * @return
	 */
	public String showMain(){
		/*Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if (attribute==null) {//����null��δ��¼
			return "login";//���ص���¼ҳ��
		}*/
		return SUCCESS;
	}
	public String showOther(){
		return SUCCESS;
	}
	public String login(){
		ServletActionContext.getRequest().getSession().setAttribute("userinfo","");
		return LOGIN;
	}
}
