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
 * �ļ��ϴ��ĵ�һ������
 * 	struts2���ļ��ϴ��ײ㻹��ʹ����commons-fileupload��commons-io��ʵ�ֵ�
 * @author yeying
 */
public class DownloadAction extends ActionSupport{
	
	/**
	 * ��ʽһ��
	 * @return
	 * @throws IOException
	 */
	/*public String download() throws IOException{
		//1���ҵ�Ҫ���ص��ļ�
		String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/uploads");
		//2����ȡҪ���ص��ļ�����(ʵ�ʿ����л�����ݿ��в���)
		String fileName = "IMG_0060.JPG";
		//3�������ֽ�������(File.separator�൱��"/")
		InputStream inputStream = new FileInputStream(basePath+File.separator+fileName);
		//4����ȡrespones����
		HttpServletResponse response = ServletActionContext.getResponse();
		//5����ȡ�ֽ������
		OutputStream outputStream = response.getOutputStream();
		//6��������Ӧͷ
		response.setHeader("Content-Type", "application/octet-strem");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		
		//7��������
		int len = -1;
		byte[] by = new byte[1024];
		while((len = inputStream.read(by)) != -1){
			outputStream.write(by, 0, len);
		}
		return null;
	}*/
	
	//1.�ṩһ���ֽ�������.ע��:�������Ʋ��ܽ�in,����������struts2��һ��bug
	private InputStream inputStream;
	
	//2.�ṩһ��String���������ڴ���ļ�����
	private String fileName;
	
	/**
	 * ��ʽ����
	 * @return
	 * @throws IOException
	 */
	public String download() throws IOException{
		//3.�ҵ�Ҫ�����ļ���·��
		String basePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploads");
		//4.ʹ���ļ�·��+�ļ����ƣ������ֽ�������
		fileName = "IMG_0060.JPG";//ʵ�ʿ������Ǵ����ݿ��в������
		//�����������Ҫ���б���
		//fileName = URLEncoder.encode(fileName, "UTF-8");
		inputStream = new FileInputStream(basePath+File.separator+fileName);
		//5������һ���ɹ�
		return SUCCESS;
		/*
		 * 6.ʣ�µ���,������struts2��ܡ��ǿ�ܵ�stream�Ľ������Ϊ����ʵ�ֵ�
		 * ������Ҫ��stream��������ṩ����
		 * 	<result name="success" type="stream">
				<!-- ���������ע�����������ͷ һ���� -->
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
