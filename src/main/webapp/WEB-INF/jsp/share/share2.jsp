<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>配货大厅</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1.0" />
<meta name="apple-wap-web-app-capable" content="yes">
<meta name="apple-wap-web-app-status-bar-style"
	content="black-translucent">
<link href="../ico/peihuo.icon" rel="shortcut icon">
<!-- js -->
<script src="../css/assets/js/core/jquery.3.2.1.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

img {
	max-width: 100%;
	height: auto;
}
</style>
</head>
<body>
	<!--  <div class="test">
		<a
			href="http://mp.weixin.qq.com/mp/redirect?url=http://mobile.xinlianwang.com/android/distributor/DistributorApp.apk#weixin.qq.com#wechat_redirect ">有效跳转</a>
	</div>-->
	<script type="text/javascript">
		function is_weixin() {
			var ua = navigator.userAgent.toLowerCase();
			if (ua.match(/MicroMessenger/i) == "micromessenger") {
				return true;
			} else {
				return false;
			}
		}
		var isWeixin = is_weixin();
		var winHeight = typeof window.innerHeight != 'undefined' ? window.innerHeight
				: document.documentElement.clientHeight;
		var weixinTip = $('<div id="weixinTip"><p><img src="../image/live_weixin2.png" alt="微信打开"/></p><p><a href="http://www.peihuodating.cn:8080/epreport/evaluate/shareDownload.htm"><p>取消</p></a></p></div>');

		if (isWeixin) {
			$("body").append(weixinTip);
		} else {
			window.location.href = "http://huomanbang.cn/apppeihuo.apk";
		}
		$("#weixinTip").css({
			"position" : "fixed",
			"left" : "0",
			"top" : "0",
			"height" : winHeight,
			"width" : "100%",
			"z-index" : "1000",
			"background-color" : "rgba(0,0,0,0.8)",
			"filter" : "alpha(opacity=80)",
		});
		$("#weixinTip p").css({
			"text-align" : "center",
			"margin-top" : "0%",
			"padding-left" : "0%",
			"padding-right" : "0%"
		});
	</script>
</body>
</html>