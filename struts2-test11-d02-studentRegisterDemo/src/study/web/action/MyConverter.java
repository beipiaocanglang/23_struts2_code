package study.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 自定义类型转换器的步骤：
 * 	1、编写一个普通类，继承StrutsTypeConverter类，并且实现里面的抽象方法
 * 	2、配置自定义类型转换器：
 * 		配置局部类型转换器：只能指定的实体类中的属性使用，如果其他实体类想用，必须按照格式再写一个配置文件
 * 			1、在实体类所在的包下，创建一个以    实体类名称-conversion.properties的文件
 * 			2、在文件中编写的内容是： 哪个属性用哪个类型转换器
 * 				例如：birthday=cn.itcast.web.converter.MyTypeConverter
 *		配置全局类型转换器：
 *			在类的根路径下创建一个名称为xwork-conversion.properties的文件。
 *			在文件中编写的内容是：哪个数据类型使用哪个类型转换器
 *				例如：java.util.Date=cn.itcast.web.converter.MyTypeConverter
 * @author zhy
 */
public class MyConverter extends StrutsTypeConverter {

	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * 将数组（可以有一个元素）转成其他数据类型，可在保存数据到数据库中时使用
	 */
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// 1.判断是否有数据
		if (values == null || values.length == 0) {
			return null;
		}
		// 2.取出values中的第一个元素
		String date = values[0];
		// 3.判断是否是要转换成日期类型
		if (Date.class == toClass) {
			try {
				return format.parse(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 将其他数据类型转换成字符串，可在页面展示数据时使用
	 */
	public String convertToString(Map context, Object o) {
		//1.判断o是不是一个java.util.Date类型，不需要判断null因为即使是null是也会判断null是不是Date中的类型
		if(o instanceof Date){
			Date date = (Date)o;
			return format.format(date);
		}
		return null;
	}
}
