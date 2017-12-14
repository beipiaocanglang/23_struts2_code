<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>防止表单重复提交</title>
  </head>
  
  <body>
    <s:form action="login">
    	<s:textfield name="username" label="用户名"></s:textfield>
    	<%--struts2中提供一个标签：s:token，在页面上生成一个唯一的标识。类似验证码的功能 --%>
    	<s:token/>
    	<s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
