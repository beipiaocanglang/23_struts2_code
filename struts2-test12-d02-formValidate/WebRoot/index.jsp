<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生注册</title>
    <s:head/>
  </head>
  
  <body>
     <s:form action="userRegister">
    	<s:textfield name="username" label="用户名" requiredLabel="true" labelPosition="left"/>
    	<s:password name="password" label="密码" showPassword="true"/>
    	<s:textfield name="birthday" label="生日" />
    	<s:submit value="注册"></s:submit>
    </s:form> 
  </body>
</html>
