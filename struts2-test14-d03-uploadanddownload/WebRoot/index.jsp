<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2文件上传</title>
  </head>
  <body>
  	<!-- 单个文件上传
  		struts2的form标签中的method属性值默认是post 
  	-->
	<s:actionerror/>
	<s:form action="upload1" enctype="multipart/form-data">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:file name="photo" label="照片"></s:file>
		<s:submit value="上传" ></s:submit>
	</s:form>
	<br/>
	<!-- 文件下载 -->
	<a href="${pageContext.request.contextPath }/download">点击开始下载</a>
	<br/>
	<!-- 多文件上传 -->
	<s:form action="upload2" enctype="multipart/form-data">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:file name="photo" label="图片"></s:file>
		<s:file name="photo" label="图片"></s:file>
		<s:submit value="多文件上传" ></s:submit>
	</s:form>
  </body>
</html>
