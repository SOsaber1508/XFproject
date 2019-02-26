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
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>配货大厅</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!-- css -->
<link rel="stylesheet" href="../css/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/assets/css/font.css">
<link rel="stylesheet" href="../css/assets/css/ready.css">
<link rel="stylesheet" href="../css/assets/css/demo.css">
<link href="../css/my/css/toastr.css" rel="stylesheet" />
<!-- js -->
<script src="../css/assets/js/core/jquery.3.2.1.min.js"></script>
<script src="../css/assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script src="../css/assets/js/core/popper.min.js"></script>
<script src="../css/assets/js/core/bootstrap.min.js"></script>
<script src="../css/assets/js/plugin/chartist/chartist.min.js"></script>
<script src="../css/assets/js/plugin/chartist/plugin/chartist-plugin-tooltip.min.js"></script>
<script src="../css/assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>
<script src="../css/assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<script src="../css/assets/js/plugin/jquery-mapael/jquery.mapael.min.js"></script>
<script src="../css/assets/js/plugin/chart-circle/circles.min.js"></script>
<script src="../css/assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<script src="../css/assets/js/ready.min.js"></script>
<script src="../css/my/js/default.js"></script>
<script src="../css/my/js/echarts.js"></script>
<script src="../css/my/js/toastr.js"></script>
<script src="../css/my/layer/layer.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- head -->
		<div class="main-header">
			<div class="logo-header">
				<a href="index.html" class="logo">配货管理中心</a>
				<button class="navbar-toggler sidenav-toggler ml-auto" type="button"
					data-toggle="collapse" data-target="collapse"
					aria-controls="sidebar" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<button class="topbar-toggler more">
					<i class="la la-ellipsis-v"></i>
				</button>
			</div>
			<nav class="navbar navbar-header navbar-expand-lg">
			<div class="container-fluid">

				<form class="navbar-left navbar-form nav-search mr-md-3" action="">
					<div class="input-group">
						<input type="text" placeholder="Search ..." class="form-control">
						<div class="input-group-append">
							<span class="input-group-text"> <i
								class="la la-search search-icon"></i>
							</span>
						</div>
					</div>
				</form>
				<ul class="navbar-nav topbar-nav ml-md-auto align-items-center">
					<li class="nav-item dropdown hidden-caret"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="la la-envelope"></i>
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item dropdown hidden-caret"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> <i class="la la-bell"></i> <span
							class="notification">3</span>
					</a>
						<ul class="dropdown-menu notif-box"
							aria-labelledby="navbarDropdown">
							<li>
								<div class="dropdown-title">You have 4 new notification</div>
							</li>
							<li>
								<div class="notif-center">
									<a href="#">
										<div class="notif-icon notif-primary">
											<i class="la la-user-plus"></i>
										</div>
										<div class="notif-content">
											<span class="block"> New user registered </span> <span
												class="time">5 minutes ago</span>
										</div>
									</a> <a href="#">
										<div class="notif-icon notif-success">
											<i class="la la-comment"></i>
										</div>
										<div class="notif-content">
											<span class="block"> Rahmad commented on Admin </span> <span
												class="time">12 minutes ago</span>
										</div>
									</a> <a href="#">
										<div class="notif-img">
											<img src="../css/assets/img/profile2.jpg" alt="Img Profile">
										</div>
										<div class="notif-content">
											<span class="block"> Reza send messages to you </span> <span
												class="time">12 minutes ago</span>
										</div>
									</a> <a href="#">
										<div class="notif-icon notif-danger">
											<i class="la la-heart"></i>
										</div>
										<div class="notif-content">
											<span class="block"> Farrah liked Admin </span> <span
												class="time">17 minutes ago</span>
										</div>
									</a>
								</div>
							</li>
							<li><a class="see-all" href="javascript:void(0);"> <strong>See
										all notifications</strong> <i class="la la-angle-right"></i>
							</a></li>
						</ul></li>
					<li class="nav-item dropdown"><a
						class="dropdown-toggle profile-pic" data-toggle="dropdown"
						href="#" aria-expanded="false"> <img
							src="../css/assets/img/profile.jpg" alt="user-img" width="36"
							class="img-circle"><span>Hizrian</span></span>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li>
								<div class="user-box">
									<div class="u-img">
										<img src="../css/assets/img/profile.jpg" alt="user">
									</div>
									<div class="u-text">
										<h4>Hizrian</h4>
										<p class="text-muted">hello@themekita.com</p>
										<a href="profile.html"
											class="btn btn-rounded btn-danger btn-sm">View Profile</a>
									</div>
								</div>
							</li>
							<div class="dropdown-divider"></div>
							<%--<a class="dropdown-item" href="#"><i class="ti-user"></i> My
								Profile</a>
							<a class="dropdown-item" href="#"></i> My Balance</a>
							<a class="dropdown-item" href="#" id="register"><i class="ti-email"></i>
								注册</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#"><i class="ti-settings"></i>
								Account Setting</a>
							<div class="dropdown-divider"></div>--%>
							<a class="dropdown-item" href="#" id="Logout"><i class="fa fa-power-off"></i>
								退出登录</a>
						</ul> <!-- /.dropdown-user --></li>
				</ul>
			</div>
			</nav>
		</div>

		<!-- left -->
		<div class="sidebar">
			<div class="scrollbar-inner sidebar-wrapper">
				<div class="user">
					<div class="photo">
						<img src="../css/assets/img/profile.jpg">
					</div>
					<div class="info">
						<a class="" data-toggle="collapse" href="#collapseExample"
							aria-expanded="true"> <span> 管理员: <span
								class="user-level">${sessionScope.username}</span> <span class="caret"></span>
						</span>
						</a>
						<div class="clearfix"></div>

						<div class="collapse in" id="collapseExample" aria-expanded="true"
							style="">
							<ul class="nav">
								<%--<li><a href="#profile"> <span class="link-collapse">My
											Profile</span>
								</a></li>
								<li><a href="#edit"> <span class="link-collapse">Edit
											Profile</span>
								</a></li>--%>
								<li><a href="#" data-toggle="modal" data-target="#Updatepassword"> <span class="link-collapse">修改密码</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<ul class="nav" id="left_nav">
					<li class="nav-item active"><a href="../admin/welcome.htm"> <i
							class="la la-dashboard"></i>
							<p>总览</p> <span class="badge badge-count">5</span>
					</a></li>
					<li class="nav-item"><a href="../admin/components.htm"> <i
							class="la la-table"></i>
							<p>进度</p> <span class="badge badge-count">14</span>
					</a></li>
					<li class="nav-item"><a href="../admin/forms.htm"> <i
							class="la la-keyboard-o"></i>
							<p>表</p> <span class="badge badge-count">50</span>
					</a></li>
					<li class="nav-item"><a href="../admin/tables.htm"> <i
							class="la la-th"></i>
							<p>表格</p> <span class="badge badge-count">6</span>
					</a></li>
					<li class="nav-item"><a href="../admin/notifications.htm"> <i
							class="la la-bell"></i>
							<p>待办事项</p> <span class="badge badge-success">3</span>
					</a></li>
					<li class="nav-item"><a href="../admin/typography.htm"> <i
							class="la la-font"></i>
							<p>Typography</p> <span class="badge badge-danger">25</span>
					</a></li>
					<li class="nav-item"><a href="../admin/icons.htm"> <i
							class="la la-fonticons"></i>
							<p>Icons</p>
					</a></li>
					<li class="nav-item update-pro">
						<button data-toggle="modal" data-target="#modalUpdate">
							<i class="la la-hand-pointer-o"></i>
							<p>注册用户</p>
						</button>
					</li>
				</ul>
			</div>
		</div>
		<!-- 内容 -->
		<sitemesh:write property='body' />
	</div>
	<!-- Modal -->
	<div class="modal fade" id="modalUpdate" tabindex="-1" role="dialog"
		aria-labelledby="modalUpdatePro" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h6 class="modal-title">
						<i class="la la-frown-o"></i> 注册用户：
					</h6>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form class="form-horizontal">
					<div class="modal-body text-center">

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" id="inputEmail3" placeholder="username">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-11">
									<input type="password" class="form-control" id="inputPassword3" placeholder="password">
								</div>
						</div>
					</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10"> </div>
						</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" onclick="register()">注册</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 修改密码 -->
	<div class="modal fade" id="Updatepassword" tabindex="-1" role="dialog"
		aria-labelledby="modalUpdatePro" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h6 class="modal-title">
						<i class="la la-frown-o"></i> 修改密码：
					</h6>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form class="form-horizontal">
					<div class="modal-body text-center">

						<div class="form-group">
							<label for="inputPassword1" class="col-sm-5 control-label">原密码：</label>
							<div class="col-sm-11">
								<input type="password" class="form-control" id="inputPassword1" placeholder="password">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword2" class="col-sm-5 control-label">新密码：</label>
							<div class="col-sm-11">
								<input type="password" class="form-control" id="inputPassword2" placeholder="password">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword4" class="col-sm-5 control-label">再次输入新密码：</label>
							<div class="col-sm-11">
								<input type="password" class="form-control" id="inputPassword4" placeholder="password">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10"> </div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default" onclick="Updatepassword()">修改密码</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
					</div>
				</form>
			</div>
		</div>
	</div>




	<script type="text/javascript" src="../css/my/js/md5.js"></script>

	<script type="text/javascript">

		//失去焦点用户名
		$("#inputEmail3").blur(function () {
			var username = $(this).val();
			var reg = /^[a-zA-Z][a-zA-Z0-9]{4,9}$/;
				if(username==""||username==null){
                    // layer.msg('用户名不得为空');
                    alert("用户名不得为空");
				}else if(!reg.test(username)){
					alert("用户名不符合要求（字母开头，5-9位）");
				}
		});
		//失去焦点密码
		$("#inputPassword3").blur(function () {
				var password = $(this).val();
				var reg = /^[a-zA-Z0-9]{5,10}$/;
				if(password==""||password==null){
					alert("密码不得为空");
				}else if(!reg.test(password)){
					alert("密丶码不符合要求（字母或数字 6-11位）");
				}
		});


		//注册
		function register() {
		//注册点击判断
		function check() {
			var reg1 = /^[a-zA-Z][a-zA-Z0-9]{4,9}$/;
			if ($("#inputEmail3").val() == "") {
				alert("用户名不得为空");
				return false;
			}else if(!reg1.test($("#inputEmail3").val())){
				alert("用户名不符合要求（字母开头，5-9位）");
				return false;
			}
			var reg2 = /^[a-zA-Z0-9]{5,10}$/;
			if ($("#inputPassword3").val() == "") {
				alert("密码不得为空");
				return false;
			}else if (!reg2.test($("#inputPassword3").val())){
				alert("密丶码不符合要求（字母或数字 6-11位）");
				return false;
			}
			return true;
		}
		if(check()){
			var une = $("#inputEmail3").val();
			var pwd = $("#inputPassword3").val();
			var md5pwd = $.md5(pwd);
			$.ajax({
				url:"<%=basePath%>login/register.htm",
				type:"POST",
				data:{"user_name":une,
				"user_password":md5pwd },
				dataType:"json",
				success:function(data) {
				if(data==1){
					alert("用户已存在，注册失败！！！")
				} else if (data==2) {
					alert("注册成功！！！")
				}

				},
				error:function () {
					alert("请求失败");
				},
				complete:function () {
					//alert("请求成功与否，都会执行");
				}
			});
			}else {

			}
		}

		//失去焦点判断密码
		$("#inputPassword1").blur(function () {
			var password = $(this).val();
			var reg = /^[a-zA-Z0-9]{5,10}$/;
			if(password==""||password==null){
				alert("密码不得为空");
			}else if(!reg.test(password)){
				alert("密丶码不符合要求（字母或数字 6-11位）");
			}
		});
		$("#inputPassword2").blur(function () {
			var password = $(this).val();
			var reg = /^[a-zA-Z0-9]{5,10}$/;
			if(password==""||password==null){
				alert("密码不得为空");
			}else if(!reg.test(password)){
				alert("密丶码不符合要求（字母或数字 6-11位）");
			}
		});
		$("#inputPassword4").blur(function () {
			var password = $(this).val();
			var password1 = $("#inputPassword2").val();

			if(password!=password1){
				alert("两次密码输入不一致");
			}
		});

		//修改密码
		function Updatepassword() {
			//修改密码点击判断
			function check() {
				var reg = /^[a-zA-Z0-9]{5,10}$/;
				if ($("#inputPassword1").val() == "") {
					alert("密码不得为空");
					return false;
				}else if(!reg.test($("#inputPassword1").val())){
					alert("密丶码不符合要求（字母或数字 6-11位）");
					return false;
				}
				if ($("#inputPassword2").val() == "") {
					alert("密码不得为空");
					return false;
				}else if (!reg.test($("#inputPassword2").val())){
					alert("密丶码不符合要求（字母或数字 6-11位）");
					return false;
				}
				if($("#inputPassword2").val()!=$("#inputPassword4").val()){
					alert("两次密码输入不一致");
					return false;
				}
				return true;
			}
			if(check()){
				var pwd = $("#inputPassword1").val();
				var upwd = $("#inputPassword4").val();
				var md5pwd = $.md5(pwd);
				var md5upwd = $.md5(upwd);
				$.ajax({
					url:"<%=basePath%>login/updatePassword.htm",
					type:"POST",
					data:{"user_password":md5pwd,
					"user_upassword":md5upwd },
					dataType:"json",
					success:function(data) {
						if(data==1){
						alert("原密码输入有误，修改失败！！！")
						} else if (data==2) {
						alert("修改成功！！！")
						}
					},
					error:function () {
						alert("请求失败");
					},
					complete:function () {
						//alert("请求成功与否，都会执行");
					}
				});
			}else {

			}
		}

	</script>
</body>
<script src="../css/assets/js/plugin/jquery-mapael/maps/world_countries.min.js"></script>
<script src="../css/assets/js/demo.js"></script>
</html>