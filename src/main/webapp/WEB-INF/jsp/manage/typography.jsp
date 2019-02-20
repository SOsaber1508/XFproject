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
$("#left_nav").find('li').eq(5).addClass("active");
});
</script>
	<div class="main-panel">
				<div class="content">
					<div class="container-fluid">
						<h4 class="page-title">Typography</h4>
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="card-header">
										<div class="card-title">Card Title</div>
										<div class="card-category">Card Category</div>
									</div>
									<div class="card-body">
										<table class="table table-typo">
											<tbody>
												<tr>
													<td>
														<p>Header 1</p>

													</td>
													<td><span class="h1">h1. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 2</p>

													</td>
													<td><span class="h2">h2. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 3</p>

													</td>
													<td><span class="h3">h3. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 4</p>

													</td>
													<td><span class="h4">h4. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 5</p>

													</td>
													<td><span class="h5">h5. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Header 5</p>

													</td>
													<td><span class="h6">h6. Bootstrap heading</span></td>
												</tr>
												<tr>
													<td>
														<p>Paragraph</p>

													</td>
													<td><p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Paragraph Lead</p>

													</td>
													<td><p class="lead">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p></td>
												</tr>
												<tr>
													<td>
														<p>Quote</p>

													</td>
													<td><blockquote>
														<p class="blockquote blockquote-primary">
															"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
															<br>
															<br>
															<small>
																- Noaa
															</small>
														</p>
													</blockquote></td>
												</tr>
												<tr>
													<td>
														<p>Primary Text</p>

													</td>
													<td><p class="text-primary">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Info Text</p>

													</td>
													<td><p class="text-info">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Success Text</p>

													</td>
													<td><p class="text-success">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Warning Text</p>

													</td>
													<td><p class="text-warning">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Danger Text</p>

													</td>
													<td><p class="text-danger">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
												<tr>
													<td>
														<p>Muted Text</p>

													</td>
													<td><p class="text-muted">Lorem Ipsum is simply dummy text of the printing and typesetting industry...</p></span></td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="card-footer">
										<hr>
										Card Footer
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
							2019, made with <i class="la la-heart heart text-danger"></i> by <a href="#">奈落落</a> - More Templates - Collect from <a href="https://tieba.baidu.com/f?fr=wwwt&kw=%E5%A5%88%E8%90%BD%E8%90%BD" title="奈落落" target="_blank">奈落落</a></div>				
					</div>
				</footer>
			</div>
			</body>
</html>