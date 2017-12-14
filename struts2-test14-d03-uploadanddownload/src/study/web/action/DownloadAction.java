package study.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator.Success;

/**
 * 文件上传的第一个案例
 * 	struts2的文件上传底层还是使用了commons-fileupload和commons-io来实现的
 * @author yeying
 */
public class DownloadAction extends ActionSupport{
	
	/**
	 * 方式一：
	 * @return
	 * @throws IOException
	 */
	/*public String download() throws IOException{
		//1、找到要下载的文件
		String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/uploads");
		//2、获取要下载的文件名称(实际开发中会从数据库中查找)
		String fileName = "IMG_0060.JPG";
		//3、构建字节输入流(File.separator相当于"/")
		InputStream inputStream = new FileInputStream(basePath+File.separator+fileName);
		//4、获取respones对象
		HttpServletResponse response = ServletActionContext.getResponse();
		//5、获取字节输出流
		OutputStream outputStream = response.getOutputStream();
		//6、设置响应头
		response.setHeader("Content-Type", "application/octet-strem");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		//7、流操作
		int len = -1;
		byte[] by = new byte[1024];
		while((len = inputStream.read(by)) != -1){
			outputStream.write(by, 0, len);
		}
		return null;
	}*/
	
	//1.提供一个字节输入流.注意:变量名称不能叫in,可以理解成是struts2的一个bug
	private InputStream inputStream;
	
	//2.提供一个String变量，用于存放文件名称
	private String fileName;
	
	/**
	 * 方式二：
	 * @return
	 * @throws IOException
	 */
	public String download() throws IOException{
		//3.找到要下载文件的路径
		String basePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploads");
		//4.使用文件路径+文件名称，构建字节输入流
		fileName = "IMG_0060.JPG";//实际开发中是从数据库中查出来的
		//如果有乱码需要进行编码
		//fileName = URLEncoder.encode(fileName, "UTF-8");
		inputStream = new FileInputStream(basePath+File.separator+fileName);
		//5、返回一个成功
		return SUCCESS;
		/*
		 * 6.剩下的事,都交给struts2框架。是框架的stream的结果类型为我们实现的
		 * 我们需要给stream结果类型提供参数
		 * 	<result name="success" type="stream">
				<!-- 给结果类型注入参数：两个头 一个流 -->
				<param name="contentType">application/octet-stream</param>
				<param name="contentDisposition">attachment;filename=1.jpg</param>
				<param name="inputStream">inputStream</param>
			</result>
		 */
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
