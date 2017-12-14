package study.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ����¼���Զ���������
 * @author canglang
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡsession�е��ֶ�
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if (attribute==null) {//����null��δ��¼
			return "login";//���ص���¼ҳ��
		}
		//�������
		return invocation.invoke();
	}

}
