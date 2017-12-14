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
public class UploadDemo2 extends ActionSupport{

	private String username;
	private File[] photo;
	private String photoFileName[];
	private String photoContentType[];
	
	public String upload2(){
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
		
		/*
		 * ���У��ǰ���ʱ�ļ��������󣬴浽ָ��Ŀ¼(һ����ô��ַ�ʽ)
		 * �ȸ��Ƶĺô�����:ֻ�ᱣ��һ���ļ�
		 */
		if (photo != null && photo.length > 0) {
			for(int i = 0; i < photo.length; i++) {
				photo[i].renameTo(new File(file,photoFileName[i]));
			}
		}
		return SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File[] getPhoto() {
		return photo;
	}
	public void setPhoto(File[] photo) {
		this.photo = photo;
	}
	public String[] getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String[] getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}
}
