package study.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 拦截器的第一个测试类
 * @author canglang
 */
public class BBSAction extends ActionSupport {

	/**
	 * 版本一：在每一个里面获取一遍登录验证
	 * 版本二：将登录验证提取成公共的方法
	 * 版本三：将登录提取到拦截器里面。方便管理
	 * @return
	 */
	public String showMain(){
		/*Object attribute = ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		if (attribute==null) {//等于null，未登录
			return "login";//返回到登录页面
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
