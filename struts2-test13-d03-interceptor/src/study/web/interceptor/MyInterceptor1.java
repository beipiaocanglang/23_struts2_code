package study.web.interceptor;

import javax.interceptor.InvocationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器
 * 步骤:
 * 		1、编写一个普通类，继承AbstractInterceptor类（也可实现接口Intercpetor），实现里面的抽象方法
 * 			  	还可以  继承MethodFilterInterceptor类，实现里面的抽象方法。  (好处就是，它可以通过注入参数的方式来确定哪些方法需要拦截，哪些方法不需要拦截)
 * 		2、配置拦截器
 * 			a、声明拦截器(name只随便，class自定义的拦截器的类全名)
 *				<interceptors>
 *					<interceptor name="myInterceptor1" class="cn.itcast.web.interceptors.MyInterceptorDemo1"></interceptor>
 *				</interceptors>
 *			b、使用拦截器
 *				<action name="action1" class="cn.itcast.web.action.Demo1Action" method="demo1">
 *					<!-- 使用拦截器。当我们配置了一个拦截器之后，默认的拦截器栈就失效了-->
 *					<interceptor-ref name="myInterceptor1"></interceptor-ref>
 *
 *					<result name="success">/success.jsp</result>
 *				</action>
 *			c、放行
 *				自定义拦截器中：return invocation.invoke()
 *	   总结和过滤器的关系(知道)
 *	   	共同点：
 *	   		都是单例的。
 *	   		都可以拦截请求。
 *	   		都是访问资源之前和之后都会经过。
 *	   	区别：
 *	   		Filter是针对整个web应用的。
 *	   		Interceptor只能是针对struts2的。如果不用struts2，则没有拦截器。
 *	   		而且如果访问的不是struts2默认拦截的资源，则不会经过拦截器。（默认情况下，如果不是以.action为后缀或者没有后缀，根本不会进入struts2的核心内部）
 *	   		
 *	 多个拦截器的执行顺序:(掌握)
 *	 	是由使用顺序决定的,与声明顺序无关
 *	 	
 *	注意事项:(掌握)
 *		当我们配置了一个拦截器之后，默认的拦截器栈就失效了
 * @author canglang
 */
public class MyInterceptor1 extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("********动作方法之前****拦截器1执行了********");
		//inter就是动作方法返回值success
		String inter = invocation.invoke();//放行
		System.out.println("********动作方法之后****拦截器1执行了********");
		return inter;
	}
}
