
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>配货大厅访问错误500</title>
    <link rel="stylesheet" type="text/css" href="../css/my/css/500.css" />
</head>

<body style="background:#0186a7;">

<!---500--->
<div class="error_new_bg pr">
    <div class="error_new_content">
        <div class="error_new pa">
            <div class="fl error_new_left"><img src="<%=basePath%>css/my/images/error.png"></div>
            <div class="fl error_new_right">
                <div class="error_detail">
                    <p class="error_p_title">哎呦~ 老司机居然累倒了!</p>
                    <p class="error_p_con">※ 500服务器出错啦！！！</p>
                    <p class="error_p_con">※ 请点击以下链接继续浏览网页</p>
                </div>

                <p class="error_new_right_btn pr">
                    <a href="<%=basePath%>index.jsp" class="type-2 type-3">
                        <i> 返回首页</i>
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
