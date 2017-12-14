<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>验证码</title>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath}/LoginServlet" method="GET">
  		用户名:<input type="text" name="username"/><br/>
  		密码:<input type="password" name="password"/><br/>
  		验证码：<input type="text" name="fcode"/>
  		     <img src="${pageContext.request.contextPath}/ImageServlet" width="200px" height="35px"/>
  			<br/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
