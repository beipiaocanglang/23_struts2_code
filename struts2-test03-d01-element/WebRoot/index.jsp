<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2的配置文件讲解</title>
  </head>
  
  <body>
  	<%--
  		基于之前的分析：
  			在原来的servlet中，
  				有三部分：
  					1、要做什么事情
  					2、由哪个类执行
  					3、执行哪个方法
  		在页面上我们只需要提供一个：要做什么事情。
  		hello.action说的就是要做什么事情。
  		struts2框架（核心的控制器-过滤器）默认会拦截以.action为后缀的URL。或者是什么后缀都没有的。
  	--%>
    <a href="${pageContext.request.contextPath}/hello.action">struts2的第一个入门案例-以.action为后缀</a>
    <br>
    <a href="${pageContext.request.contextPath}/hello">struts2的第一个入门案例-没有后缀</a>
    <br>
    <a href="${pageContext.request.contextPath}/hello.do">struts2的第一个入门案例-以.do结尾的</a>
    
  </body>
</html>
