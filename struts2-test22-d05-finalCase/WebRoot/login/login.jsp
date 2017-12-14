<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<script type="text/javascript">
function ini(){
   /* 在form1表单下有一个name=logonname的input输入框会获取焦点 */
   document.form1.logonName.focus();
}
</script>

<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<link href="${pageContext.request.contextPath}/css/Style.css" rel="stylesheet" type="text/css">
	</head>

	<body onload="ini()">
		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<table width="452" height="290" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td bgcolor="#FFFFFF">
								<table width="452" height="290" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td height="74">
											<img src="${pageContext.request.contextPath}/images/logintitle.gif">
										</td>
									</tr>
									<tr>
										<td align="center" valign="bottom" background="${pageContext.request.contextPath}/images/loginbg.gif">
											<!-- struts默认post提交 -->
											<s:form action="login" id="loginAction_home" name="form1" target="_parent" >
												<table border="0" align="center" cellpadding="2" cellspacing="0">
													<tr align="center">
														<td height="30" colspan="2" style="border-bottom: 1px dotted #cccccc">
															<strong style="font-size: 14px;">请登录</strong>
														</td>
													</tr>
													<tr>
														<td height="30" nowrap>
															<font color="000F60"><strong>用户名：</strong> </font>
														</td>
														<td>
															<s:textfield name="loginName" id="loginName" cssClass="text" cssStyle="width: 160px;"/>
														</td>
													</tr>
													<tr>
														<td height="30" nowrap>
															<strong><font color="000F60">密码： </font> </strong>
														</td>
														<td>
															<s:password name="loginPwd" id="loginPwd" cssClass="text" cssStyle="width: 160px;"/>
														</td>
													</tr>
													<tr>
														<td height="30" nowrap colspan="2">
															<!-- 页面接受错误信息 -->
															<strong><font color="red"><s:actionerror/></font> </strong>
														</td>
													</tr>
													<tr>
														<td height="30">
														</td>
														<td>
															<s:submit  value="登录" class="buttoninput"/>
															<s:submit value="重置" class="buttoninput"/>
														</td>
													</tr>
												</table>
											</s:form>




											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td height="30" align="center">
													</td>
												</tr>
												<tr>
													<td height="23" align="center"></td>
												</tr>
											</table>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>

