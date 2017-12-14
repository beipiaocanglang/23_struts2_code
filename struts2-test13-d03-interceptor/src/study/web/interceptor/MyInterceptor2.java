package study.web.interceptor;

import javax.interceptor.InvocationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author canglang
 */
public class MyInterceptor2 extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("********动过方法之前****拦截器2执行了********");
		//inter就是动作方法返回值success
		String inter = invocation.invoke();//放行
		System.out.println("********动过方法之后****拦截器2执行了********");
		return inter;
	}
}
