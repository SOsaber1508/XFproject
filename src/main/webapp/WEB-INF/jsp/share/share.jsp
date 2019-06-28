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
<!-- css -->
<link rel="stylesheet" href="../css/assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<img id="image01" src="../image/share20190628/image_01.jpg" style="width:100%;height:auto;">
			<a href="http://www.peihuodating.cn:8080/epreport/evaluate/download.htm">
			<img src="../image/share20190628/button.png"
				style="position: relative;z-index: 2;width: 68%;margin-top: -60px;margin-bottom: 20px;margin-left:18%;">
		</a>
		</div>
		<div class="row">
			<img id="image02" src="../image/share20190628/image_02.jpg" style="width:100%;height:auto;">
		</div>
	</div>
</body>
<script src="../css/assets/js/core/jquery.3.2.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        var mobile_flag = isMobile(); // true为PC端，false为手机端

        if(mobile_flag){
        	var phoneWidth =  parseInt(window.screen.width);
            var phoneScale = phoneWidth/750;
            var image02Height = phoneScale*1050;
            var image01Height = phoneScale*650;
            $("#image02").css("height", image02Height);  // 设定等比例缩放后的高度
            $("#image01").css("height", image01Height);  // 设定等比例缩放后的高度
        }
    });
    function isMobile() {
        var userAgentInfo = navigator.userAgent;

        var mobileAgents = [ "Android", "iPhone", "SymbianOS", "Windows Phone", "iPad","iPod"];

        var mobile_flag = false;

        //根据userAgent判断是否是手机
        for (var v = 0; v < mobileAgents.length; v++) {
            if (userAgentInfo.indexOf(mobileAgents[v]) > 0) {
                mobile_flag = true;
                break;
            }
        }

         var screen_width = window.screen.width;
         var screen_height = window.screen.height;    

         //根据屏幕分辨率判断是否是手机
         if(screen_width < 500 && screen_height < 800){
             mobile_flag = true;
         }

         return mobile_flag;
    }
</script>
</html>