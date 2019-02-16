<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>错误页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1.0" />
<meta name="apple-wap-web-app-capable" content="yes">
<meta name="apple-wap-web-app-status-bar-style"
	content="black-translucent">
</head>
<body>
	<div align="center">hei hei yo yo qie ke nao jian bing guo zi lai
		yitao everbody hei wei GO</div>
	<div align="center">
		<a href="<%=basePath%>admin/welcome.htm"
			class="list-group-item active">回首页 </a>
	</div>
</body>
</html>