package study.web.finalcaseaction.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import study.web.finalcaseaction.domain.User;
import study.web.finalcaseaction.service.IUserService;
import study.web.finalcaseaction.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();

	private IUserService userService = new UserServiceImpl();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * �û���¼
	 * @return
	 */
	public String userLogin(){
		
		//����service�ӿ�
		User dbUser = userService.login(user.getLoginName(), user.getLoginPwd());
		//�ж��û��Ƿ����
		if(dbUser == null){
			//������--���ش�����Ϣ
			addActionError("��¼ʧ�ܣ��û��������벻��ȷ");//��ҳ����Ӧ�ý������������Ϣ
			return INPUT;
		}
		//����--����session��
		ServletActionContext.getRequest().getSession().setAttribute("userInfo", dbUser);
		return SUCCESS;
	}
	
	/**
	 * ��ȡ�м��Ҳ��û��б�
	 */
	//����list���Ͻ��ܲ�ѯ�����Ķ���
	private List<User> users;
	public String findAllUser() {
		//����service�Ľӿ�
		users = userService.findAllUser();
		return SUCCESS;
	}

	/**
	 * ����û���ť--Ŀ��ֻ��Ϊ�˾���������
	 * @return
	 */
	public String addUIUser(){
		System.out.println("��ת������û�ҳ��");
		return SUCCESS;
	}
	
	/**
	 * ����û�--�����û�
	 * @return
	 */
	private File upload;
	private String uploadFileName;
	
	public String addUser(){
		if (upload != null) {
			//��ȡҪ�洢ͼƬ��λ��
			String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			//2.ʹ�õ�ǰ������Ϊ�ּ���Ŀ¼
			String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//2016-05-31
			
			//3.�ж�Ŀ¼�Ƿ����
			File file = new File(basePath,datePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//4.�����ļ�������ֹ�����ļ�
			/*
			 * UUID:	Uniform unique  Identifer
			 * 			��32��16���Ƶ�����ɵ�
			 * 			xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
			 * GUID��	General Uniform Identifer
			 * 			DSLK32234LKMSADFJK12342345
			 * 			TokenHelper��������struts2����Լ��ģ�
			 * 			ҳ���ϵ�token����GUID
			 */
			String GUID = TokenHelper.generateGUID();
			String GUIDFileName = GUID+"_"+uploadFileName;
			//5.�ϴ��ļ�
			upload.renameTo(new File(file,GUIDFileName));
			//6.��ģ��֮��û�е����ݸ���(fileName��path)
			user.setPath(datePath);
			user.setFilename(GUIDFileName);
		}
		//�����û�
		userService.saveUser(user);
		return SUCCESS;
	}
	
	/**
	 * �����û�id�鿴�û���Ϣ��Ϣ
	 * @return
	 */
	public String findUserById(){
		//���ݵ�ǰ�û�����ѯ�û���ϸ��Ϣ
		User findUserById = userService.findUserById(user.getUserID());
		//����һ���ж��Ƿ��м���
		if (findUserById.getFilename() != null) {
			String substring = findUserById.getFilename().substring(findUserById.getFilename().indexOf("_")+1, findUserById.getFilename().length());
			findUserById.setFilename(substring);
		}
		//����������ҳ���Ͻ�ȡ
		//<s:property value="filename.substring(filename.indexOf('_')+1,filename.length())"/>
		//��ȡValueStack����
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//����ѯ����������ѹջ
		valueStack.push(findUserById);
		return SUCCESS;
	}
	
	/**
	 * ��������
	 * @return
	 */
	private InputStream inputStream;
	private String downloadFileName;
	
	public String download() throws Exception{
		//��ȡ�ļ��洢��λ��
		String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
		//2.�����û�id����ѯ�û���Ϣ
		User dbUser = userService.findUserById(user.getUserID());//����·��
		//3.���ֽ���������ֵ
		inputStream = new FileInputStream(basePath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());
		//4.�������ļ�����ֵ
		downloadFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1, dbUser.getFilename().length());//����.docx
		
		return SUCCESS;
	}
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public String deleteUser(){
		//����ɾ���ӿڣ�����Ӱ�����ݿ������
		int removeUser = userService.removeUser(user.getUserID());
		//�ж��Ƿ�ɹ�
		if (removeUser != 1) {
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * ���ֱ༭�û���ͼ
	 * @return
	 */
	public String editUIUser(){
		//��ȡ�û���Ϣ
		User findUserById = userService.findUserById(user.getUserID());
		//��ȡValueStack����
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//ѹջ
		valueStack.push(findUserById);
		return SUCCESS;
	}
	/**
	 * ����༭��ɵ��û���Ϣ
	 * ��Ϊһ�¼��������
	 * 		ԭ���м���		�޸�ʱ	�ύ�˼���			���¼���
	 * 		ԭ���м���		�޸�ʱ	û���ύ����		��ԭ���ļ���						
	 * 		ԭ��û�м���		�޸�ʱ	�ύ�˼���			�����ϴ��ļ���
	 * 		ԭ��û�м���		�޸�ʱ	û���ύ����		û�м���
	 * @return
	 */
	public String editUser(){
		//�ж��Ƿ񳤴����ļ�
		if (upload == null) {//����ѡ���ϴ�����һ��ʼ��û���ļ�������ԭ����
			//����ǰ�û�����Ϣ
			User findUserById = userService.findUserById(user.getUserID());
			//ʹ��ԭ���û���Ϣ�е�path��filename����ģ�͸�ֵ
			user.setPath(findUserById.getPath());
			user.setFilename(findUserById.getFilename());
		}else {//���������ϴ��Ļ����޸ĺ��ϴ��ģ���Ҫ�ϴ��ļ�
			//��ȡҪ�洢ͼƬ��λ��
			String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			//2.ʹ�õ�ǰ������Ϊ�ּ���Ŀ¼
			String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//2016-05-31
			
			//3.�ж�Ŀ¼�Ƿ����
			File file = new File(basePath,datePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//4.�����ļ�������ֹ�����ļ�
			String GUID = TokenHelper.generateGUID();
			String GUIDFileName = GUID+"_"+uploadFileName;
			//5.�ϴ��ļ�
			upload.renameTo(new File(file,GUIDFileName));
			//6.��ģ��֮��û�е����ݸ���(fileName��path)
			user.setPath(datePath);
			user.setFilename(GUIDFileName);
		}
		userService.modifyUser(user);
		return SUCCESS;
	}
	
	/**
	 * ��������ѯ
	 * @return
	 */
	//�����Ƿ��ϴ���������ô����
	private String isUpload;
	public String findUserByCondition(){
		users = userService.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isUpload);
		return SUCCESS;
	}
	
	
	
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public void setDownloadFileName(String downloadFileName) {
		this.downloadFileName = downloadFileName;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
}
