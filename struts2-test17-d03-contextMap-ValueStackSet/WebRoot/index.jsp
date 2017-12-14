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
	
	<!-- 当s:property标签没有value属性和取值时，默认取栈顶对象 -->
	<s:property/>
	<hr/>
	<!-- 注意：此时的name不是字符串，而是OGNL表达式 -->
	<s:property value="name"/>
	<hr/>
	<!-- 如果遇有对象属性重名，可以通过OGNL表达式，选择查找的起始位置 -->
	<s:property value="[1].name"/>
	<hr/>
	<s:property value="age"/>
  	
  </body>
</html>
