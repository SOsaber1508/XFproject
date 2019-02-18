<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>配货大厅</title>
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
//取消默认选中+添加默认选中
$("#left_nav").find('li').eq(0).removeClass("active");
$("#left_nav").find('li').eq(4).addClass("active");
});
</script>
	<div class="main-panel">
				<div class="content">
					<div class="container-fluid">
						<h4 class="page-title">Notifications</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Bootstrap Notify</div>
										<div class="card-category">Turn standard bootstrap alerts into "growl" like notifications from <a class="link" href="http://bootstrap-notify.remabledesigns.com/">Bootstrap Notify</a></div>
									</div>
									<div class="card-body">
										<div class="form">
											<div class="form-group from-show-notify row">
												<div class="col-lg-3 col-md-3 col-sm-12 text-right">
													<label>Placement :</label>
												</div>
												<div class="col-lg-4 col-md-9 col-sm-12">
													<select class="form-control input-fixed" id="notify_placement_from">
														<option value="top">Top</option>
														<option value="bottom">Bottom</option>
													</select>
													<select class="form-control input-fixed" id="notify_placement_align">
														<option value="left">Left</option>
														<option value="right" selected="">Right</option>
														<option value="center">Center</option>
													</select>
												</div>
											</div>
											<div class="form-group from-show-notify row">
												<div class="col-lg-3 col-md-3 col-sm-12 text-right">
													<label>State :</label>
												</div>
												<div class="col-lg-4 col-md-9 col-sm-12">
													<select class="form-control input-fixed" id="notify_state">
														<option value="primary">Primary</option>
														<option value="info">Info</option>
														<option value="success">Success</option>
														<option value="warning">Warning</option>
														<option value="danger">Danger</option>
													</select>
												</div>
											</div>
											<div class="form-group from-show-notify row">
												<div class="col-lg-3 col-md-3 col-sm-12 text-right">
													<label>Style :</label>
												</div>
												<div class="col-lg-4 col-md-9 col-sm-12">
													<select class="form-control input-fixed" id="notify_style">
														<option value="plain">Plain</option>
														<option value="withicon">With Icon</option>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="card-footer">
										<div class="form">
											<div class="form-group from-show-notify row">
												<div class="col-lg-3 col-md-3 col-sm-12">

												</div>
												<div class="col-lg-4 col-md-9 col-sm-12">
													<button id="displayNotif" class="btn btn-success">Display</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<footer class="footer">
					<div class="container-fluid">
						<nav class="pull-left">
							<ul class="nav">
								<li class="nav-item">
									<a class="nav-link" href="#">
										ThemeKita
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#">
										Help
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="#license/#free-item">
										Licenses
									</a>
								</li>
							</ul>
						</nav>
						<div class="copyright ml-auto">
							2018, made with <i class="la la-heart heart text-danger"></i> by <a href="#">ThemeKita</a> - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></div>				
					</div>
				</footer>
			</div>
</body>
</html>