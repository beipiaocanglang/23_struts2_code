package study.web.interceptor;

import javax.interceptor.InvocationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author canglang
 */
public class MyInterceptor2 extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("********��������֮ǰ****������2ִ����********");
		//inter���Ƕ�����������ֵsuccess
		String inter = invocation.invoke();//����
		System.out.println("********��������֮��****������2ִ����********");
		return inter;
	}
}
