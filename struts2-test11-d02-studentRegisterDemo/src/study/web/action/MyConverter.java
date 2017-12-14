package study.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * �Զ�������ת�����Ĳ��裺
 * 	1����дһ����ͨ�࣬�̳�StrutsTypeConverter�࣬����ʵ������ĳ��󷽷�
 * 	2�������Զ�������ת������
 * 		���þֲ�����ת������ֻ��ָ����ʵ�����е�����ʹ�ã��������ʵ�������ã����밴�ո�ʽ��дһ�������ļ�
 * 			1����ʵ�������ڵİ��£�����һ����    ʵ��������-conversion.properties���ļ�
 * 			2�����ļ��б�д�������ǣ� �ĸ��������ĸ�����ת����
 * 				���磺birthday=cn.itcast.web.converter.MyTypeConverter
 *		����ȫ������ת������
 *			����ĸ�·���´���һ������Ϊxwork-conversion.properties���ļ���
 *			���ļ��б�д�������ǣ��ĸ���������ʹ���ĸ�����ת����
 *				���磺java.util.Date=cn.itcast.web.converter.MyTypeConverter
 * @author zhy
 */
public class MyConverter extends StrutsTypeConverter {

	private DateFormat format = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * �����飨������һ��Ԫ�أ�ת�������������ͣ����ڱ������ݵ����ݿ���ʱʹ��
	 */
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// 1.�ж��Ƿ�������
		if (values == null || values.length == 0) {
			return null;
		}
		// 2.ȡ��values�еĵ�һ��Ԫ��
		String date = values[0];
		// 3.�ж��Ƿ���Ҫת������������
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
	 * ��������������ת�����ַ���������ҳ��չʾ����ʱʹ��
	 */
	public String convertToString(Map context, Object o) {
		//1.�ж�o�ǲ���һ��java.util.Date���ͣ�����Ҫ�ж�null��Ϊ��ʹ��null��Ҳ���ж�null�ǲ���Date�е�����
		if(o instanceof Date){
			Date date = (Date)o;
			return format.format(date);
		}
		return null;
	}
}
