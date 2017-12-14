<%@page import="com.sun.org.apache.bcel.internal.classfile.Attribute"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2文件上传</title>
  </head>
  <body>
  	<s:debug/>
  	<!-- 
  		s:property标签类似于jsp中的jsp表达式，把value的值直接输出到页面
  		注意：
  			value的值是OGNL表达式而不是字符串
  		如果想要输出的结果是字符串，请加引号
  	 -->
  	<!-- 普通方法的调用 -->
	  	<!-- 1、将value值作为OGNL表达式输出 -->
	  	<s:property value="OGNL-Expression"/><!-- 输出结果是：0 -->
	  	<br/>
	  	<!-- 2、将value值作为字符串输出到页面 -->
	  	<s:property value="'OGNL-Expression'"/><!-- 输出结果是:OGNL-Expression  -->
	  	<br/>
	  	<s:property value="'OGNL-Expression'.length()"/><!-- 输出结果是：15(指的是字符个数) -->
	  	<br/>
	  	<s:property value="'OGNL-Expression'.toUpperCase()"/><!-- 输出结果是：OGNL-EXPRESSION(转成大写) -->
	  	<br/>
	  	<s:property value="'OGNL-Expression'.split('-')[0]"/><!-- 输出结果是：OGNL(以"-"分割，取第一个) -->
	  	<br/>
  	<!-- 访问静态成员(静态属性、静态方法) -->
	  	<!--
	  		1、访问静态属性
	  		格式：
				@包名.包名.类名@属性名称
	  	-->
	  	<s:property value="@java.lang.Integer@MAX_VALUE"/><!-- 输出结果是：2147483647 -->
	  	<br/>
	  	<!-- 
	  		2、访问静态方法
	  		@包名.包名.类名@方法名称
	  		注意：
	  			直接以下的写法是不行的，因为在struts.properties配置文件中默认是禁用访问静态方法的
		  		需要在struts.xml配置文件中开启访问静态方法调用：
		  		<constant name="struts.ognl.allowStaticMethodAccess" value="true"/>
	  	-->
	  	<s:property value="@java.lang.Math@random()"/><!-- 输出结果是：0.6297105853859672(随机数) -->
		<br/>
  	<!-- OGNL操作集合 -->
  		<!-- 
  			操作集合对象
  			s:radio标签的list属性取值是一个OGNL表达式。
			{'男','女'}就相当于创建了一个List集合，里面包含了两个元素 
			例如：
				<input type="radio" name="gender" id="gender男" value="男"><label for="gender男">男</label>
				<input type="radio" name="gender" id="gender女" value="女"><label for="gender女">女</label>
  		 -->
  		<s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
		
		<br/>
		<!-- 
			操作map对象
			井号{'male':'男','female':'女'}就相当于创建了一个map。冒号左侧的作为key，冒号右侧的作为value。
			在生成浏览器认识的html标签时：
				会把map的key给html标签的value赋值
				把map的value作为文本显示在页面上
			例如：
				<input type="radio" name="gender" id="gendermale" value="male"><label for="gendermale">男</label>
				<input type="radio" name="gender" id="genderfemale" value="female"><label for="genderfemale">女</label>
		 -->
		<s:radio list="#{'male':'男','female':'女'}" name="gender" label="性别"></s:radio>  		
  	<% session.setAttribute("canglang", "yeying"); %>
  </body>
</html>
