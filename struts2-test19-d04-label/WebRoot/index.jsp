<%@page import="com.sun.org.apache.bcel.internal.classfile.Attribute"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>struts2的contextMap结构展示</title>
</head>
<body>
	<!-- s:debug是struts2提供的一个标签 ，用于展示OGNL上下文中的数据-->
	<s:debug />

	<table width="500px" border="1" align="center">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<%--
			s:iterator标签
				作用:用于迭代集合,在页面中显示
				属性:
					value：取值是一个OGNL表达式
					var：取值就是一个普通的字符串
						使用了该属性：会把var的值当做key，把当前遍历的元素当做value，存入ContextMap中（存到大Map）
						没有使用该属性：会把当前遍历的元素，压入栈顶
					begin：遍历开始的索引
					end：遍历的结束索引
					step：步长。for(int i=0;i<size;i=i+step)
					status：遍历的计数器对象。该属性只会存在于contextMap中  <s:property value="#vs"/>  ${vs}
						getIndex：当前遍历元素的索引位置。从0开始
						getCount：当前遍历元素的序号。从1开始
						isOdd：是否是奇数
						isEven：是否是偶数
						isFirst：是否是第一个元素
						isLast：是否是最后一个元素
						
					
		--%>
		<s:iterator value="students" var="s">
			<tr>
	  			<td><s:property value="#s.name"/></td>
	  			<td><s:property value="#s.age"/></td>
	  		</tr>
		</s:iterator>
	</table>
	<hr/>
	<table width="500px" border="1" align="center">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
		<s:iterator value="students">
			<tr>
	  			<td><s:property value="name"/></td>
	  			<td><s:property value="age"/></td>
	  		</tr>
		</s:iterator>
	</table>
	<hr/>
	<table width="500px" border="1" align="center">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<s:iterator value="students" status="vs">
			<tr bgcolor="${vs.odd?'red':'blue'}">
	  			<td>${name}</td>
	  			<td>${age}</td>
	  		</tr>
		</s:iterator>
	</table>
	<hr/>
	<!-- 方式一：使用原始EL表达式和JSTL标签的方式 -->
	<table width="500px" border="1" align="center">
		<tr>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${students}" var="s">
			<tr>
				<td>${s.name }</td>
				<td>${s.age }</td>
		</c:forEach>

	</table>

</body>
</html>
