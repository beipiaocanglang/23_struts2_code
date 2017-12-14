<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
		body
		{
			SCROLLBAR-ARROW-COLOR: #ffffff;  SCROLLBAR-BASE-COLOR: #dee3f7;
		}
    </style>
  </head>
  
<frameset rows="103,*,43" frameborder=0 border="0" framespacing="0">
	<!--页面上半部分 -->
	<frame src="${pageContext.request.contextPath}/login/top.jsp" name="topFrame" scrolling="NO" noresize>
	<!-- 页面中间部分 -->
	<frameset cols="159,*" frameborder="0" border="0" framespacing="0">
		<!-- 页面中间部分的左半部分 -->
		<frame src="${pageContext.request.contextPath}/login/left.jsp" name="leftFrame" noresize scrolling="YES">
		<!-- 页面中间部分的右半部分 -->
		<frame src="${pageContext.request.contextPath}/login/welcome.jsp" name="mainFrame">
	</frameset>
	<!-- 页面的底部 -->
	<frame src="${pageContext.request.contextPath}/login/bottom.jsp" name="bottomFrame" scrolling="NO"  noresize>
</frameset>
</html>
