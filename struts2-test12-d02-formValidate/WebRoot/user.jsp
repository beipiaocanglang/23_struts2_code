<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    <s:head/>
  </head>
  <body>
  	 <!-- 
  		使用<s:actionerror/>的目的是解决密码错误时的提示
  		密码与确认密码一致、确认密码和密码一致，无法确定是确认密码还是密码的错误，所以会执行动作错误
  	 -->
  	 <s:actionerror/>
     <s:form action="saveUser">
    	<s:textfield name="username" label="用户名"/>
    	<s:textfield name="age" label="年龄"/>
    	<s:textfield name="email" label="邮箱"/>
    	<%-- 
    	如果使用这个的话，当密码或确认密码错误时不会回显
    	<s:password name="password" label="密码" />
    	<s:s:password name="repassword" label="确认密码"/> 
    	--%>
    	<s:textfield name="password" label="密码" />
    	<s:textfield name="repassword" label="确认密码"/>
    	<s:textfield name="score" label="成绩" />
    	<s:textfield name="url" label="个人主页"/>
    	<%-- list中的内容：
    			相当于创建一个新的List集合
    	--%>
    	<s:radio list="{'男','女'}" name="gender" label="性别"/>
    	<%--
    		<input type="radio" name="gender" value="男"/>男
    		<input type="radio" name="gender" value="女"/>女
    	 --%>
    	<s:submit value="注册"></s:submit>
    </s:form>
  </body>
</html>
