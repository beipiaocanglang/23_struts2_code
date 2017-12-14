<%@page import="com.sun.org.apache.bcel.internal.classfile.Attribute"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2的contextMap结构展示</title>
  </head>
  <body>
  	<!-- s:debug是struts2提供的一个标签 ，用于展示OGNL上下文中的数据-->
  	<s:debug/>
  	
	<!-- 获取request中的数据  -->
	<s:property value="#request.requestMap"/><br/>
	<s:property value="#request.servletRequestMap"/><br/>
	<!-- 获取session中的数据   -->
	<s:property value="#session.sessionMap"/><br/>
	<s:property value="#session.sessionAttr"/><br/>
	<!-- 获取application中的数据 --> 
	<s:property value="#application.applicationMap"/><br/>
	<s:property value="#application.applicationAttr"/><br/>
  	
  </body>
</html>
