<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
	<table width=780 align="center">
		<tr>
			<td>请输入用户名和密码来登录<br /> 
			<s:if test="tip!=null">
					<div class="error">
						<s:property value="tip" />
					</div>
				</s:if> 
				<div align="center">
					<s:form action="login" namespace="/">
						<s:textfield name="user.loginname" label="用户名" />
						<s:textfield name="user.passwd" label="密码" />
						<s:textfield name="vercode" label="验证码" />
						<tr>
							<td colspan="2"><s:submit value="登录" theme="simple" /> <s:reset
									theme="simple" value="重填" /></td>
						</tr>
					</s:form>
				</div> 验证码： <img name="d" src="authImg" />
			</td>
		</tr>
	</table>
</body>
</html>