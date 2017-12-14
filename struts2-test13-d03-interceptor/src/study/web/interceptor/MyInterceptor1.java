package study.web.interceptor;

import javax.interceptor.InvocationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * �Զ���������
 * ����:
 * 		1����дһ����ͨ�࣬�̳�AbstractInterceptor�ࣨҲ��ʵ�ֽӿ�Intercpetor����ʵ������ĳ��󷽷�
 * 			  	������  �̳�MethodFilterInterceptor�࣬ʵ������ĳ��󷽷���  (�ô����ǣ�������ͨ��ע������ķ�ʽ��ȷ����Щ������Ҫ���أ���Щ��������Ҫ����)
 * 		2������������
 * 			a������������(nameֻ��㣬class�Զ��������������ȫ��)
 *				<interceptors>
 *					<interceptor name="myInterceptor1" class="cn.itcast.web.interceptors.MyInterceptorDemo1"></interceptor>
 *				</interceptors>
 *			b��ʹ��������
 *				<action name="action1" class="cn.itcast.web.action.Demo1Action" method="demo1">
 *					<!-- ʹ����������������������һ��������֮��Ĭ�ϵ�������ջ��ʧЧ��-->
 *					<interceptor-ref name="myInterceptor1"></interceptor-ref>
 *
 *					<result name="success">/success.jsp</result>
 *				</action>
 *			c������
 *				�Զ����������У�return invocation.invoke()
 *	   �ܽ�͹������Ĺ�ϵ(֪��)
 *	   	��ͬ�㣺
 *	   		���ǵ����ġ�
 *	   		��������������
 *	   		���Ƿ�����Դ֮ǰ��֮�󶼻ᾭ����
 *	   	����
 *	   		Filter���������webӦ�õġ�
 *	   		Interceptorֻ�������struts2�ġ��������struts2����û����������
 *	   		����������ʵĲ���struts2Ĭ�����ص���Դ���򲻻ᾭ������������Ĭ������£����������.actionΪ��׺����û�к�׺�������������struts2�ĺ����ڲ���
 *	   		
 *	 �����������ִ��˳��:(����)
 *	 	����ʹ��˳�������,������˳���޹�
 *	 	
 *	ע������:(����)
 *		������������һ��������֮��Ĭ�ϵ�������ջ��ʧЧ��
 * @author canglang
 */
public class MyInterceptor1 extends AbstractInterceptor {
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("********��������֮ǰ****������1ִ����********");
		//inter���Ƕ�����������ֵsuccess
		String inter = invocation.invoke();//����
		System.out.println("********��������֮��****������1ִ����********");
		return inter;
	}
}
