<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>封装请求参数-静态封装</title>
  </head>
  <body>
    <a href="${pageContext.request.contextPath}/demo01.action">静态参数封装</a>
  </body>
</html>
