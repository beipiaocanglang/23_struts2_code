package study.web.action;

import com.opensymphony.xwork2.Action;

/**
 * @author zhy
 * implements Action����û��ʹ��ʵ�����е�Ĭ�Ϸ���
 */
public class Hello1Action implements Action{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String sayHello(){
		System.out.println("struts�ĵ�һ�����Ű���sayHelloִ���ˣ�");
		
		/*
		 	return��ȡֵ����ʹ��һ�¼�������Ϊ��ʵ�ֵ�Action���ж�������Щ������Ӧ����Сд
			 ʵ��Action�ӿڡ��ýӿ����ṩ��һЩ����
			SUCCESS��һ�������ȫ���ɹ���
			ERROR�������ǵĶ����������г���ִ���쳣ʱʹ�á�
			INPUT���������ύ����ʧ��ʱ����Ҫ�������ݣ�һ��ʹ��INPUT��
			LOGIN��һ�㷵�ص�¼���档
			NONE���������κν����ͼ��һ��������ļ����أ����json���ݡ�
				 ����ʹ��return null;��ʵ�ֺ�return NONEһ����Ч��
		*/
		return "success";
	}
}
