<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>封装请求参数-动态封装</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/demo01" method="POST">
    	用户名：<input type="text" name="name"><br/>
    	年龄：<input type="text" name="age"><br/>
    	<input type="submit" value="提交">
    </form>
  </body>
</html>
