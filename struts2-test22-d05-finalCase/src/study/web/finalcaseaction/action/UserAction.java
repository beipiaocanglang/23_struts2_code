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
	 * 用户登录
	 * @return
	 */
	public String userLogin(){
		
		//调用service接口
		User dbUser = userService.login(user.getLoginName(), user.getLoginPwd());
		//判断用户是否存在
		if(dbUser == null){
			//不存在--返回错误信息
			addActionError("登录失败，用户名或密码不正确");//在页面上应该接受这个错误信息
			return INPUT;
		}
		//存在--放入session中
		ServletActionContext.getRequest().getSession().setAttribute("userInfo", dbUser);
		return SUCCESS;
	}
	
	/**
	 * 获取中间右侧用户列表
	 */
	//定义list集合接受查询出来的对象
	private List<User> users;
	public String findAllUser() {
		//调用service的接口
		users = userService.findAllUser();
		return SUCCESS;
	}

	/**
	 * 添加用户按钮--目的只是为了经过服务器
	 * @return
	 */
	public String addUIUser(){
		System.out.println("跳转到添加用户页面");
		return SUCCESS;
	}
	
	/**
	 * 添加用户--保存用户
	 * @return
	 */
	private File upload;
	private String uploadFileName;
	
	public String addUser(){
		if (upload != null) {
			//获取要存储图片的位置
			String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			//2.使用当前日期作为分级的目录
			String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//2016-05-31
			
			//3.判断目录是否存在
			File file = new File(basePath,datePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//4.处理文件名，防止重名文件
			/*
			 * UUID:	Uniform unique  Identifer
			 * 			由32个16进制的数组成的
			 * 			xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx
			 * GUID：	General Uniform Identifer
			 * 			DSLK32234LKMSADFJK12342345
			 * 			TokenHelper工具类是struts2框架自己的，
			 * 			页面上的token就是GUID
			 */
			String GUID = TokenHelper.generateGUID();
			String GUIDFileName = GUID+"_"+uploadFileName;
			//5.上传文件
			upload.renameTo(new File(file,GUIDFileName));
			//6.给模型之中没有的数据复制(fileName和path)
			user.setPath(datePath);
			user.setFilename(GUIDFileName);
		}
		//保存用户
		userService.saveUser(user);
		return SUCCESS;
	}
	
	/**
	 * 根据用户id查看用户信息信息
	 * @return
	 */
	public String findUserById(){
		//根据当前用户名查询用户详细信息
		User findUserById = userService.findUserById(user.getUserID());
		//方法一：判断是否有简历
		if (findUserById.getFilename() != null) {
			String substring = findUserById.getFilename().substring(findUserById.getFilename().indexOf("_")+1, findUserById.getFilename().length());
			findUserById.setFilename(substring);
		}
		//方法二：在页面上截取
		//<s:property value="filename.substring(filename.indexOf('_')+1,filename.length())"/>
		//获取ValueStack对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//将查询出来的数据压栈
		valueStack.push(findUserById);
		return SUCCESS;
	}
	
	/**
	 * 简历下载
	 * @return
	 */
	private InputStream inputStream;
	private String downloadFileName;
	
	public String download() throws Exception{
		//获取文件存储的位置
		String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
		//2.根据用户id，查询用户信息
		User dbUser = userService.findUserById(user.getUserID());//日期路径
		//3.给字节输入流赋值
		inputStream = new FileInputStream(basePath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());
		//4.给下载文件名赋值
		downloadFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1, dbUser.getFilename().length());//简历.docx
		
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String deleteUser(){
		//调用删除接口，返回影响数据库的行数
		int removeUser = userService.removeUser(user.getUserID());
		//判断是否成功
		if (removeUser != 1) {
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 显现编辑用户视图
	 * @return
	 */
	public String editUIUser(){
		//获取用户信息
		User findUserById = userService.findUserById(user.getUserID());
		//获取ValueStack对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		//压栈
		valueStack.push(findUserById);
		return SUCCESS;
	}
	/**
	 * 保存编辑完成的用户信息
	 * 分为一下几种情况：
	 * 		原来有简历		修改时	提交了简历			用新简历
	 * 		原来有简历		修改时	没有提交简历		用原来的简历						
	 * 		原来没有简历		修改时	提交了简历			用新上传的简历
	 * 		原来没有简历		修改时	没有提交简历		没有简历
	 * @return
	 */
	public String editUser(){
		//判断是否长传了文件
		if (upload == null) {//不管选择不上传还是一开始就没有文件，都用原来的
			//插叙当前用户的信息
			User findUserById = userService.findUserById(user.getUserID());
			//使用原来用户信息中的path和filename，给模型赋值
			user.setPath(findUserById.getPath());
			user.setFilename(findUserById.getFilename());
		}else {//不管是新上传的还是修改后上传的，都要上传文件
			//获取要存储图片的位置
			String basePath = ServletActionContext.getServletContext().getRealPath("WEB-INF/upload");
			//2.使用当前日期作为分级的目录
			String datePath = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//2016-05-31
			
			//3.判断目录是否存在
			File file = new File(basePath,datePath);
			if(!file.exists()){
				file.mkdirs();
			}
			//4.处理文件名，防止重名文件
			String GUID = TokenHelper.generateGUID();
			String GUIDFileName = GUID+"_"+uploadFileName;
			//5.上传文件
			upload.renameTo(new File(file,GUIDFileName));
			//6.给模型之中没有的数据复制(fileName和path)
			user.setPath(datePath);
			user.setFilename(GUIDFileName);
		}
		userService.modifyUser(user);
		return SUCCESS;
	}
	
	/**
	 * 多条件查询
	 * @return
	 */
	//定义是否上传简历的那么属性
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
