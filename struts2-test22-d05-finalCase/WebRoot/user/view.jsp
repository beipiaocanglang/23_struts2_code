<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style.css" type="text/css" rel="stylesheet">
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
	</HEAD>
	<body>
		<s:debug/>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/user/userAction_save.do" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4" height="26">
						<STRONG>查看用户</STRONG>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">登录名：</td>
					<td class="ta_01" bgColor="#ffffff">${loginName }</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">用户姓名：</td>
					<td class="ta_01" bgColor="#ffffff">${userName }</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">性别：</td>
					<td class="ta_01" bgColor="#ffffff">${gender }</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">学历：</td>
					<td class="ta_01" bgColor="#ffffff">${education }</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">出生日期：</td>
					<td class="ta_01" bgColor="#ffffff">${birthday }</td>
					<td align="center" bgColor="#f5fafe" class="ta_01">电话：</td>
					<td class="ta_01" bgColor="#ffffff">${telephone }</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">兴趣爱好：</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3"> ${hobby }</td>
				</tr>
				<tr>
					<td align="center" bgColor="#f5fafe" class="ta_01">简历资料：</td>
					<td class="ta_01" bgColor="#ffffff" colSpan="3">
						<s:if test="filename != null">
							<s:url action="download" var="url_download">
								<!-- 方法一：使用param标签传递参数 -->
								<s:param name="userID" value="userID"/>
								<!-- 方法二：在点击事件后面拼接参数${url_download }?${userID} -->
							</s:url>
							<a href="#" onclick="openWindow('${url_download }','700','400')" class="cl_01">
								<!-- 方法一：在类中截取 -->
								${filename }
								<!-- 方法二： 在页面上截取-->
								<%-- <s:property value="filename.substring(filename.indexOf('_')+1,filename.length())"/> --%>
							</a>
						</s:if>
					</td>
				</tr>
				<TR>
					<TD class="ta_01" align="center" bgColor="#f5fafe">备注：</TD>
					<TD class="ta_01" bgColor="#ffffff" colSpan="3">${remark }</TD>
				</TR>
				<TR>
					<td align="center" colSpan="4" class="sep1">
						<img src="${pageContext.request.contextPath}/images/shim.gif">
					</td>
				</TR>
				<TR>
					<td class="ta_01" style="WIDTH: 100%" align="right" bgColor="#f5fafe" colSpan="4">
						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</TR>
			</table>
		</form>
	</body>
</HTML>