package study.web.action;
/**
 * struts2�ĵ�һ�������ࡣ
 * @author zhy
 *	�����ṩ�ķ�����������������
 */
public class HelloActiond {
	/*
	 * ������������д�淶��
	 * 	1�������ķ������η�������public
	 *  2�������ķ���ֵ������string
	 *  3����������û�в���
	 */
	public String sayHello(){
		System.out.println("struts�ĵ�һ�����Ű���sayHelloִ���ˣ�");
		return "success";//�������ļ���resultԪ�ص�name����ȡֵһ�¡�
	}
}
