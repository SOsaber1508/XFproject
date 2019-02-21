<%@ page import="org.apache.commons.lang3.RandomStringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String path = request.getContextPath();
%>

<%
	String suijizifu=RandomStringUtils.randomAlphanumeric(10);
	request.getSession().setAttribute("md5RandomKey", suijizifu);//产生随机数，和密码一起生成MD5
%>
<html lang="en">

<head>
	<title>登陆</title>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link rel="stylesheet" href="css/login/bootstrap.min.css" />
	<link rel="stylesheet" href="css/login/css/camera.css" />
	<link rel="stylesheet" href="css/login/bootstrap-responsive.min.css" />
	<link rel="stylesheet" href="css/login/matrix-login.css" />
	<link rel="stylesheet" href="css/login/font-awesome.css" />


	<script src="css/js/jquery-1.7.2.js"></script>
	<script src="css/login/js/bootstrap.min.js"></script>
	<!-- 软键盘控件start -->
	<%--<link href="css/login/keypad/css/framework/form.css" rel="stylesheet" type="text/css"/>--%>
	<!-- 软键盘控件end -->
	<style type="text/css">
		/*
       body{
        -webkit-transform: rotate(-3deg);
        -moz-transform: rotate(-3deg);
        -o-transform: rotate(-3deg);
        padding-top:20px;
        }
        */
		.cavs{
			z-index:1;
			position: fixed;
			width:95%;
			margin-left: 20px;
			margin-right: 20px;
		}
	</style>
	<script>
		//window.setTimeout(showfh,3000);
		var timer;
		function showfh(){
			fhi = 1;
			//关闭提示晃动屏幕，注释掉这句话即可
			timer = setInterval(xzfh2, 10);
		};
		var current = 0;
		function xzfh(){
			current = (current)%360;
			document.body.style.transform = 'rotate('+current+'deg)';
			current ++;
			if(current>360){current = 0;}
		};
		var fhi = 1;
		var current2 = 1;
		function xzfh2(){
			if(fhi>50){
				document.body.style.transform = 'rotate(0deg)';
				clearInterval(timer);
				return;
			}
			current = (current2)%360;
			document.body.style.transform = 'rotate('+current+'deg)';
			current ++;
			if(current2 == 1){current2 = -1;}else{current2 = 1;}
			fhi++;
		};
	</script>
	<script type="text/javascript" src="css/my/js/md5.js"></script>
</head>
<body>

<!--小键盘承载器-->
<canvas class="cavs"></canvas>
<div style="width:100%;text-align: center;margin: 0 auto;position: absolute;">
	<!-- 登录 -->
	<div id="windows1" name="<%=suijizifu%>">
		<div id="loginbox" >
			<form action="" method="post" name="loginForm" id="loginForm" style="margin-top: 65px;">
				<div class="control-group normal_text">
					<h3 style="margin-top: 65px;">
						<img src="css/login/logos1.png" alt="Logos1" style="width: 65%;height: 11%;"/>
					</h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box" style="margin-top: 80px;">
							<span class="add-on bg_lg">
							<i><img height="37" src="css/login/user.png" /></i>
							</span><input type="text" name="loginname" id="loginname" value="" placeholder="请输入用户名" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly">
							<i><img height="37" src="css/login/suo.png" /></i>
							</span><input type="password" name="password" id="password" placeholder="请输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
						</div>
					</div>
				</div>
				<div style="float:right;padding-right:10%;">
					<div style="float: left;margin-top:3px;margin-right:2px;">
						<font color="white">记住密码</font>
					</div>
					<div style="float: left;">
						<input name="form-field-checkbox" id="saveid" type="checkbox"
							   onclick="savePaw();" style="padding-top:0px;" />
					</div>
				</div>
				<div class="form-actions">
					<div style="width:86%;padding-left:8%;">

						<%--<div style="float: left;padding-top:2px;">
							<i><img src="css/login/yan.png" /></i>
						</div>
						<div style="float: left;" class="codediv">
							<input type="text" name="code" id="code" class="login_code"
								   style="height:22px; padding-top:4px;" />
						</div>--%>
						<%--<div style="float: left;">
							<i><img style="height:22px;" id="codeImg" alt="点击更换" title="点击更换" src="" /></i>
						</div>--%>
						<c:if test="${pd.isZhuce == 'yes' }">
							<%--<span class="pull-right" style="padding-right:3%;"><a href="javascript:changepage(1);" class="btn btn-success">注册</a></span>--%>
						</c:if>
						<span class="pull-right"><a onclick="severCheck();" class="flip-link btn btn-info" id="to-recover">登录</a></span>
					</div>
				</div>
			</form>
			<div class="controls">
				<div class="main_input_box">
					<font color="white"><span id="nameerr"> © 信丰科技 2019</span></font>
				</div>
			</div>
		</div>
	</div>
	<!-- 注册 -->
	<div id="windows2" style="display: none;">
		<div id="loginbox">
			<form action="" method="post" name="loginForm">
				<div class="control-group normal_text">
					<h3>
						<img src="css/login/logo.png" alt="Logo" />
					</h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg">
							<i>用户</i>
							</span><input type="text" name="USERNAME" id="USERNAME" value="" placeholder="请输入用户名" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly">
							<i>密码</i>
							</span><input type="password" name="PASSWORD" id="PASSWORD" placeholder="请输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly">
							<i>重输</i>
							</span><input type="password" name="chkpwd" id="chkpwd" placeholder="请重新输入密码" class="keypad" keypadMode="full" allowKeyboard="true" value=""/>
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg">
							<i>手机</i>
							</span><input type="text" name="EMAIL" id="EMAIL" value="" placeholder="请输入手机号" />
						</div>
					</div>
				</div>
				<div class="form-actions">
					<div style="width:86%;padding-left:8%;">

						<div style="float: left;padding-top:2px;">
							<i><img src="css/login/yan.png" /></i>
						</div>
						<div style="float: left;" class="codediv">
							<input type="text" name="rcode" id="rcode" class="login_code"
								   style="height:22px; padding-top:4px;" />
						</div>
						<div style="float: left;">
							<i><img style="height:22px;" id="zcodeImg" alt="点击更换" title="点击更换" src="" /></i>
						</div>
						<span class="pull-right" style="padding-right:3%;"><a href="javascript:changepage(2);" class="btn btn-success">登陆</a></span>
						<span class="pull-right"><a onclick="register();" class="flip-link btn btn-info" id="to-recover">注册</a></span>
					</div>
				</div>
			</form>
			<div class="controls">
				<div class="main_input_box">
					<font color="white"><span id="nameerr">Copyright © XX科技 2100</span></font>
				</div>
			</div>
		</div>
	</div>

</div>
<div id="templatemo_banner_slide" class="container_wapper">
	<div class="camera_wrap camera_emboss" id="camera_slide">
		<!-- 背景图片 -->
		<div data-src="css/login/images/banner_slide_01.jpg"></div>
		<div data-src="css/login/images/banner_slide_02.jpg"></div>
		<div data-src="css/login/images/banner_slide_03.jpg"></div>
		<div data-src="css/login/images/banner_slide_04.jpg"></div>
		<div data-src="css/login/images/banner_slide_05.jpg"></div>
	</div>
	<!-- #camera_wrap_3 -->
</div>

<script type="text/javascript">
	//登陆
	//服务器校验
	function severCheck(){
		if(check()){
			var str = $("#windows1").attr("name");
			var pwd = $("#password").val();
			var md5str = $.md5(str);
			var md5pwd = $.md5(pwd);
			var md5strpwd = md5str+ md5pwd;

			$.ajax({
				url:"/epreport/admin/adminLand.htm",
				type:"POST",
				data:{"user_name":$("#loginname").val(),
					"user_password":md5strpwd
					/*$("#password").val()*/
				},
				dataType:"json",
				success:function(data) {
					if(data ==0|| data==1){
						$("#loginname").tips({
							side : 1,
							msg : "用户名或密码有误",
							bg : '#FF5080',
							time : 4
						});
						showfh();
						$("#loginname").focus();
					} else{
						self.location.href="/epreport/admin/welcome.htm";
					}

				},
				error:function () {
					alert("请求失败");
				},
				complete:function () {
					//alert("请求成功与否，都会执行");
				}
			});
			/*var user_name=$("#loginname").val();
            var user_password=$("#password").val();
            self.location.href="/background01/user/selectAUser?user_name="+user_name+"&user_password="+user_password*/;
		}else {
//            alert("请填写正确的用户名或密码");
		}
	}

	$(document).ready(function() {
		changeCode1();
		$("#codeImg").bind("click", changeCode1);
		$("#zcodeImg").bind("click", changeCode2);
	});

	$(document).keyup(function(event) {
		if (event.keyCode == 13) {
			$("#to-recover").trigger("click");
		}
	});

	function genTimestamp() {
		var time = new Date();
		return time.getTime();
	}

	function changeCode1() {
		$("#codeImg").attr("src", "code.do?t=" + genTimestamp());
	}
	function changeCode2() {
		$("#zcodeImg").attr("src", "code.do?t=" + genTimestamp());
	}


	//失去焦点用户名
	$("#loginname").blur(function () {
		var username = $(this).val();
		var reg = /^[a-zA-Z][a-zA-Z0-9]{4,9}$/;
		if(username==""||username==null){
			$("#loginname").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});
		}else if(!reg.test(username)){
			$("#loginname").tips({
				side : 2,
				msg : '用户名不符合要求（字母开头，4-9位）',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//失去焦点密码
	$("#password").blur(function () {
		var password = $(this).val();
		var reg = /^[a-zA-Z0-9]{5,10}$/;
		if(password==""||password==null){
			$("#password").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});
		}else if(!reg.test(password)){
			$("#password").tips({
				side : 2,
				msg : '密丶码不符合要求（字母或数字 6-11位）',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//客户端校验
	function check() {
		var reg1 = /^[a-zA-Z][a-zA-Z0-9]{4,9}$/;
		if ($("#loginname").val() == "") {
			$("#loginname").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});
			showfh();
			$("#loginname").focus();
			return false;
		}else if(!reg1.test($("#loginname").val())){
			$("#loginname").tips({
				side : 2,
				msg : '用户名不符合要求（字母开头，4-9位）',
				bg : '#AE81FF',
				time : 3
			});
			showfh();
			$("#loginname").focus();
			return false;
		}else {
			$("#loginname").val(jQuery.trim($('#loginname').val()));
		}
		var reg2 = /^[a-zA-Z0-9]{5,10}$/;
		if ($("#password").val() == "") {
			$("#password").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});
			showfh();
			$("#password").focus();
			return false;
		}else if (!reg2.test($("#password").val())){
			$("#password").tips({
				side : 2,
				msg : '密丶码不符合要求（字母或数字 6-11位）',
				bg : '#AE81FF',
				time : 3
			});
			showfh();
			$("#loginname").focus();
			return false;
		}
		if ($("#code").val() == "") {
			$("#code").tips({
				side : 1,
				msg : '验证码不得为空',
				bg : '#AE81FF',
				time : 3
			});
			showfh();
			$("#code").focus();
			return false;
		}
		$("#loginbox").tips({
			side : 1,
			msg : '正在登录 , 请稍后 ...',
			bg : '#68B500',
			time : 3
		});

		return true;
	}

	function savePaw() {
		if (!$("#saveid").attr("checked")) {
			$.cookie('loginname', '', {
				expires : -1
			});
			$.cookie('password', '', {
				expires : -1
			});
			$("#loginname").val('');
			$("#password").val('');
		}
	}

	function saveCookie() {
		if ($("#saveid").attr("checked")) {
			$.cookie('loginname', $("#loginname").val(), {
				expires : 7
			});
			$.cookie('password', $("#password").val(), {
				expires : 7
			});
		}
	}

	jQuery(function() {
		var loginname = $.cookie('loginname');
		var password = $.cookie('password');
		if (typeof(loginname) != "undefined"
				&& typeof(password) != "undefined") {
			$("#loginname").val(loginname);
			$("#password").val(password);
			$("#saveid").attr("checked", true);
			$("#code").focus();
		}
	});

	//登录注册页面切换
	function changepage(value) {
		if(value == 1){
			$("#windows1").hide();
			$("#windows2").show();
			changeCode2();
		}else{
			$("#windows2").hide();
			$("#windows1").show();
			changeCode1();
		}
	}

	//失去焦点用户名
	$("#USERNAME").blur(function () {
		var username = $(this).val();
		var reg = /^[a-zA-Z][a-zA-Z0-9]{3,8}$/;
		if(username==""||username==null){
			$("#USERNAME").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});
		}else if(!reg.test(username)){
			$("#USERNAME").tips({
				side : 2,
				msg : '用户名不符合要求（字母开头，4-9位）',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//失去焦点密码
	$("#PASSWORD").blur(function () {
		var password = $(this).val();
		var reg = /^[a-zA-Z0-9]{5,10}$/;
		if(password==""||password==null){
			$("#PASSWORD").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});
		}else if(!reg.test( $("#PASSWORD").val())){
			$("#PASSWORD").tips({
				side : 2,
				msg : '密丶码不符合要求（字母或数字 6-11位）',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//失去焦点第二次密码
	$("#chkpwd").blur(function () {
		var password = $(this).val();
		var reg = /^[a-zA-Z0-9]{5,10}$/;
		if($("#PASSWORD").val()!=$("#chkpwd").val()){
			$("#chkpwd").tips({
				side : 2,
				msg : '两次密码不相同',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//失去焦点手机号
	$("#EMAIL").blur(function () {
		var emali = $(this).val();
		var reg = /^1[3|4|5|6|7|8|9][0-9]\d{8}$/;
		if(emali==""||emali==null){
			$("#EMAIL").tips({
				side : 2,
				msg : '手机号不得为空',
				bg : '#AE81FF',
				time : 3
			});
		}else if(!reg.test( $("#EMAIL").val())){
			$("#EMAIL").tips({
				side : 2,
				msg : '手机号格式不正确',
				bg : '#AE81FF',
				time : 3
			});
		}
	});
	//注册
	function rcheck(){
		var reg1 = /^[a-zA-Z][a-zA-Z0-9]{3,8}$/;
		if($("#USERNAME").val()==""){
			$("#USERNAME").tips({
				side:3,
				msg:'输入用户名',
				bg:'#AE81FF',
				time:2
			});
			$("#USERNAME").focus();
			$("#USERNAME").val('');
			return false;
		}else if(!reg1.test($("#USERNAME").val())){
			$("#USERNAME").tips({
				side : 2,
				msg : '用户名不符合要求（字母开头，4-9位）',
				bg : '#AE81FF',
				time : 3
			});
			$("#USERNAME").focus();
			$("#USERNAME").val('');
			return false;
		}else{
			$("#USERNAME").val(jQuery.trim($('#USERNAME').val()));
		}
		var reg2 = /^[a-zA-Z0-9]{5,10}$/;
		if($("#PASSWORD").val()==""){
			$("#PASSWORD").tips({
				side:3,
				msg:'输入密码',
				bg:'#AE81FF',
				time:2
			});
			$("#PASSWORD").focus();
			return false;
		}else if(!reg2.test( $("#PASSWORD").val())){
			$("#PASSWORD").tips({
				side : 2,
				msg : '密丶码不符合要求（字母或数字 6-11位）',
				bg : '#AE81FF',
				time : 3
			});
			$("#PASSWORD").focus();
			return false;
		}
		if($("#PASSWORD").val()!=$("#chkpwd").val()){
			$("#chkpwd").tips({
				side:3,
				msg:'两次密码不相同',
				bg:'#AE81FF',
				time:3
			});
			$("#chkpwd").focus();
			return false;
		}
//        if($("#name").val()==""){
//            $("#name").tips({
//                side:3,
//                msg:'输入姓名',
//                bg:'#AE81FF',
//                time:3
//            });
//            $("#name").focus();
//            return false;
//        }
		var reg3 = /^1[3|4|5|6|7|8|9][0-9]\d{8}$/;
		if($("#EMAIL").val()==""){
			$("#EMAIL").tips({
				side:3,
				msg:'输入手机号',
				bg:'#AE81FF',
				time:3
			});
			$("#EMAIL").focus();
			return false;
		}else if(!reg3.test( $("#EMAIL").val())){
			$("#EMAIL").tips({
				side:3,
				msg:'手机号格式不正确',
				bg:'#AE81FF',
				time:3
			});
			$("#EMAIL").focus();
			return false;
		}
		if ($("#rcode").val() == "") {
			$("#rcode").tips({
				side : 1,
				msg : '验证码不得为空',
				bg : '#AE81FF',
				time : 3
			});
			$("#rcode").focus();
			return false;
		}
		return true;
	}



	//提交注册
	function register(){
		if(rcheck()){
			$.ajax({
				type: "POST",
				url: '/background01/user/insertAUser',
				data:{"user_name":$("#USERNAME").val(),"user_password":$("#PASSWORD").val(),"user_phongnumber":$("#EMAIL").val()},
				dataType:'text',
				success: function(data){
					if(data==1){
						$("#windows2").hide();
						$("#windows1").show();
						$("#loginbox").tips({
							side : 1,
							msg : '注册成功,请登录',
							bg : '#68B500',
							time : 3
						});
						changeCode1();
					}else if(data==3){
						$("#USERNAME").tips({
							side : 1,
							msg : "用户名已存在",
							bg : '#FF5080',
							time : 3
						});
						showfh();
						$("#USERNAME").focus();
					}else if(data==4){
						$("#EMAIL").tips({
							side : 1,
							msg : "手机号已存在",
							bg : '#FF5080',
							time : 3
						});
						showfh();
						$("#EMAIL").focus();
					}

				}
			});
		}
	}


	//邮箱格式校验
	function ismail(mail){
		return(new RegExp(/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/).test(mail));
	}
	//js  日期格式
</script>

<script src="css/login/js/jquery.easing.1.3.js"></script>
<script src="css/login/js/jquery.mobile.customized.min.js"></script>
<script src="css/login/js/camera.min.js"></script>
<script src="css/login/js/templatemo_script.js"></script>
<script src="css/login/js/ban.js"></script>
<script type="text/javascript" src="css/js/jQuery.md5.js"></script>
<script type="text/javascript" src="css/js/jquery.tips.js"></script>
<script type="text/javascript" src="css/js/jquery.cookie.js"></script>

<!-- 软键盘控件start -->
<%--<script type="text/javascript" src="css/login/keypad/js/form/keypad.js"></script>
<script type="text/javascript" src="css/login/keypad/js/framework.js"></script>--%>
<!-- 软键盘控件end -->

</body>

</html>