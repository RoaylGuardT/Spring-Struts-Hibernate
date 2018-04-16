<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
登陆成功！欢迎
<p>用户名：<s:property value="#session.username"/></p>
<p>密码：<s:property value="#session.password"/></p>
<p>在线人数：<s:property value="#application.num"/></p>
<a href="logout">注销</a>
</body>
</html>