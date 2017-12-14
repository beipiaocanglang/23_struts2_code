package study.web.action;
/**
 * struts2的第一个动作类。
 * @author zhy
 *	里面提供的方法都叫做动作方法
 */
public class HelloActiond {
	/*
	 * 动作方法的书写规范：
	 * 	1、方法的访问修饰符必须是public
	 *  2、方法的返回值必须是string
	 *  3、方法必须没有参数
	 */
	public String sayHello(){
		System.out.println("struts的第一个入门案例sayHello执行了！");
		return "success";//和配置文件中result元素的name属性取值一致。
	}
}
