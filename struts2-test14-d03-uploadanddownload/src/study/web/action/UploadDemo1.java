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
public class UploadDemo1 extends ActionSupport{

	private String username;//普通字段
	private File photo;//上传字段
	//struts2框架会为我们提供一个变量，用于保存文件名
	private String photoFileName;//上传的文件名，该属性的名称是固定写法：上传字段名称+FileName
	//private String photoContentType;//上传文件的MIME类型，写发：上传字段+ContentType
	
	public String upload1(){
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
		
		//3.写文件
		/*
		 * 拷贝:是使用临时文件，复制一份到指定目录
		 * FileUtils
		 * 	 它是apache提供commons-io的jar包中一个类。
		 * copyFile方法：
		 * 	  把参数1复制到指定位置，指定位置是由参数2决定的
		 * 参数：
		 * 	 第一个：源文件
		 * 	第二个：目标文件
		 * 
		 * 弊端：
		 * 	会保存两份文件，一份是临时文件，一份是实际写的文件
		 */
		
		/*try {
			FileUtils.copyFile(photo, new File(file,photoFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*
		 * 剪切：是把临时文件重命名后，存到指定目录(一般采用此种方式)
		 * 比复制的好处就是:只会保留一份文件
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
