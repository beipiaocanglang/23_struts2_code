package study.web.finalcaseaction.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义检查登录拦截器
 * 拦截的是动作类，静态页面拦不住
 * @author canglang
 */
public class CheckLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取session中的数据判断是否为空
		Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userInfo");
		if (attribute == null) {
			return "login";
		}
		return invocation.invoke();
	}
}
