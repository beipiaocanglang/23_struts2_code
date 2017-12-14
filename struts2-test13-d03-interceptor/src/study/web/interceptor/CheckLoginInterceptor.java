package study.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 检查登录的自定义拦截器
 * @author canglang
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取session中的字段
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if (attribute==null) {//等于null，未登录
			return "login";//返回到登录页面
		}
		//否则放行
		return invocation.invoke();
	}

}
