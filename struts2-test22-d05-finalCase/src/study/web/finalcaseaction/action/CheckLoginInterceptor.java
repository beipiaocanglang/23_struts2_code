package study.web.finalcaseaction.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Զ������¼������
 * ���ص��Ƕ����࣬��̬ҳ������ס
 * @author canglang
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡsession�е������ж��Ƿ�Ϊ��
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userInfo");
		if (attribute == null) {
			return "login";
		}
		return invocation.invoke();
	}
}
