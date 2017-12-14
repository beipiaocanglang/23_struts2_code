<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生注册</title>
    <s:head/>
  </head>
  
  <body>
  	<%-- 
  	strutr2标签库：
		s:fielderror
			作用：字段出现错误之后，用于显示错误内容的
			属性有：
				fieldName:用于指定哪个表单字段出的问题
		s:actionerror
			作用：动作类中的动作方法执行出现错误，用于显示错误内容
  	<s:fielderror/>
    <form action="${pageContext.request.contextPath}/userRegister">
    	用户名：<input type="text" name="username" /><br/>
    	密码：<input type="text" name="password" /><br/>
    	生日：<input type="text" name="birthday" />(格式要求：yyyy-MM-dd 例如：1999-09-09)<br/>
    	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
    		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
    		<input type="checkbox" name="hobby" value="写代码"/>写代码<br/>
    	婚否：<input type="checkbox" name="married" value="true"/><br/>
    	<input type="submit" value="注册"/>
    </form> --%>
    <%--使用struts2框架的表单标签
    	struts2的页面标签会自带错误信息提示的功能
    	选择使用html标签还是选择使用struts标签：
    		html标签：
    			浏览器可以单独的访问和解析
    		struts2标签：	
    			有错误信息提示、数据回显、简洁、功能更强大
    			必须借助服务器才能访问
    	s:form标签是struts2框架的表单标签。它里面常用有4个属性
    		action：请求的地址。不用再写前面的EL那段
    		namespace：动作所在的名称空间
    		method：请求的方式.strut2框架表单默认的请求方式就是post。框架只解决了post方式的中文乱码问题。
    		enctype：编码表单的类型。文件上传时所需的
    --%>
     <s:form action="userRegister">
     	<!-- 
     		requiredLabel="true"：在用户面后面会出现一个星号(*) 
     		labelPosition="left"：星号会出现在用户名前面
    		<s:head/>：在html页面的<title>标签下添加这个标签会让星号变红
     	 -->
    	<s:textfield name="username" label="用户名" requiredLabel="true" labelPosition="left"/>
    	<!-- 密码数据也回显的配置showPassword="true" -->
    	<s:password name="password" label="密码" showPassword="true"/>
    	<s:textfield name="birthday" label="生日" />
    	<s:submit value="注册"></s:submit>
    </s:form> 
  </body>
</html>
