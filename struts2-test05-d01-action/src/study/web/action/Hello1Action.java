package study.web.action;

import com.opensymphony.xwork2.Action;

/**
 * @author zhy
 * implements Action但是没有使用实现类中的默认方法
 */
public class Hello1Action implements Action{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String sayHello(){
		System.out.println("struts的第一个入门案例sayHello执行了！");
		
		/*
		 	return的取值可以使用一下几个，因为在实现的Action类中定义了这些常量对应的是小写
			 实现Action接口。该接口中提供了一些常量
			SUCCESS：一般多用于全部成功。
			ERROR：当我们的动作方法运行出现执行异常时使用。
			INPUT：当我们提交数据失败时，需要回显数据，一般使用INPUT。
			LOGIN：一般返回登录界面。
			NONE：不返回任何结果视图。一般多用于文件下载，输出json数据。
				 可以使用return null;来实现和return NONE一样的效果
		*/
		return "success";
	}
}
