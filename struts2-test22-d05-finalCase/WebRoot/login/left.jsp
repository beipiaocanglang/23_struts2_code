<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<!-- dtree.js是struts2自己的开源包，可以直接使用 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	
	<s:url action="findAllUser" var="user_findAllUser" />
	<script type="text/javascript">
		d = new dTree('d');
		d.add(0,-1,'系统菜单树');
		/* 根据javascripe的传值是不确定的来判断是否有请求参数来判断是否可以点击 */
		d.add(2,0,'员工管理','${pageContext.request.contextPath}/login/welcome.jsp','','mainFrame');
		/*
		 add方法是添加菜单项：参数
		 	当前菜单项id，当前菜单的父id，菜单的名称，请求的URL，当前菜单页面的name，指定打开的位置
		*/
		//子目录添加
		/* 方法一：引用上面的s:url获取域中key*/
		/* d.add(3,2,'用户管理','<s:property value="#user_findAllUser"/>','','mainFrame'); */
		/* 方法二：引用上面的s:url获取域中key*/
		d.add(3,2,'用户管理','${user_findAllUser}','','mainFrame');
		document.write(d);
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
