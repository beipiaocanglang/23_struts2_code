package study.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

/**
 * �ļ��ϴ��ĵ�һ������
 * 	struts2���ļ��ϴ��ײ㻹��ʹ����commons-fileupload��commons-io��ʵ�ֵ�
 * @author yeying
 */
public class UploadDemo1 extends ActionSupport{

	private String username;//��ͨ�ֶ�
	private File photo;//�ϴ��ֶ�
	//struts2��ܻ�Ϊ�����ṩһ�����������ڱ����ļ���
	private String photoFileName;//�ϴ����ļ����������Ե������ǹ̶�д�����ϴ��ֶ�����+FileName
	//private String photoContentType;//�ϴ��ļ���MIME���ͣ�д�����ϴ��ֶ�+ContentType
	
	public String upload1(){
		//1����ȡ�ļ�Ҫд����������λ��
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploads");
		
		System.out.println("username:"+username);
		System.out.println("photo:"+photo);
		System.out.println("photoFileName:"+photoFileName);
		System.out.println("realPath:"+realPath);
		
		
		//2���жϸ�·���Ƿ����
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		//3.д�ļ�
		/*
		 * ����:��ʹ����ʱ�ļ�������һ�ݵ�ָ��Ŀ¼
		 * FileUtils
		 * 	 ����apache�ṩcommons-io��jar����һ���ࡣ
		 * copyFile������
		 * 	  �Ѳ���1���Ƶ�ָ��λ�ã�ָ��λ�����ɲ���2������
		 * ������
		 * 	 ��һ����Դ�ļ�
		 * 	�ڶ�����Ŀ���ļ�
		 * 
		 * �׶ˣ�
		 * 	�ᱣ�������ļ���һ������ʱ�ļ���һ����ʵ��д���ļ�
		 */
		
		/*try {
			FileUtils.copyFile(photo, new File(file,photoFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*
		 * ���У��ǰ���ʱ�ļ��������󣬴浽ָ��Ŀ¼(һ����ô��ַ�ʽ)
		 * �ȸ��Ƶĺô�����:ֻ�ᱣ��һ���ļ�
		 */
		photo.renameTo(new File(file,photoFileName));
		return SUCCESS;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
}
