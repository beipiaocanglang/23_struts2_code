<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>苍狼论坛</title>
  </head>
  <body>
    <%--要求：
  		1、必须先登录再浏览，如果没有登录，不能访问 
  		2、不能在浏览器地址栏直接输出.jsp浏览页面。必须通过动作访问
  	--%>
  	<h1>欢迎访问苍狼论坛</h1>
  	<hr/>
  	<a href="${pageContext.request.contextPath}/showOther.action">热门板块</a>
  </body>
</html>
