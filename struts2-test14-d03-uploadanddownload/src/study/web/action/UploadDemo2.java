package study.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

/**
 * 文件上传的第一个案例
 * 	struts2的文件上传底层还是使用了commons-fileupload和commons-io来实现的
 * @author yeying
 */
public class UploadDemo2 extends ActionSupport{

	private String username;
	private File[] photo;
	private String photoFileName[];
	private String photoContentType[];
	
	public String upload2(){
		//1、获取文件要写到服务器的位置
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploads");
		
		System.out.println("username:"+username);
		System.out.println("photo:"+photo);
		System.out.println("photoFileName:"+photoFileName);
		System.out.println("realPath:"+realPath);
		
		//2、判断该路径是否存在
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		/*
		 * 剪切：是把临时文件重命名后，存到指定目录(一般采用此种方式)
		 * 比复制的好处就是:只会保留一份文件
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
