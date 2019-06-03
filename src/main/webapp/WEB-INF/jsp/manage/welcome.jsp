<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
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
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<!--  <script src="<%=basePath%>css/my/js/echarts.js"></script>-->


    <%--<script src="<%=basePath%>css/my/js/jquery.min.js"></script>--%>


</head>
<script type="text/javascript">
//置空会话框中的内容,例:时间会话框
function kill() {
	$("#start").val("");
	$("#end").val("");
}
</script>
<body>
<div class="main-panel">
				<div class="content">
					<div class="container-fluid">
						<h4 class="page-title">总览</h4>
						<div class="row">
							<div class="col-md-2">
								<div class="card card-stats card-warning">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">真实授权用户数量</p>
													<h4 class="card-title">${requestScope.userNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="card card-stats card-warning">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-users"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">认证用户数量</p>
													<h4 class="card-title">${requestScope.user_renzheng}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="card card-stats card-success">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-bar-chart"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">真实发布车源数量</p>
													<h4 class="card-title">${requestScope.vehiceNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="card card-stats card-danger">
									<div class="card-body">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-newspaper-o"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">真实发布货源总量</p>
													<h4 class="card-title">${requestScope.doodsNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
									<!-- 时间筛选 -->
						<div class="col-md-4">
						<form action="<%=basePath%>admin/welcome.htm"method="GET">
							<div>
								查询日期:<input id="start" placeholder="请选择开始日期"
									value="${startTime}" name="startTime"
									style="text-align: center" class="laydate-icon"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" autocomplete="off">
								-<input id="end" placeholder="请选择结束日期" value="${endTime}"
									name="endTime" style="text-align: center" class="laydate-icon"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"autocomplete="off">
							</div>
							<div align="center">
								<input type="submit" class="btn btn-primary" value="查询">
								<button type="button" class="btn btn-secondary"
									onclick="kill();" style="margin-left: 10px">重置</button>
							</div>
									</form>
						</div>
						</div>
						<div class="row">
							<div class="col-md-3">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">Task</h4>
										<p class="card-category">Complete</p>
									</div>
									<div class="card-body">
										<div id="task-complete" class="chart-circle mt-4 mb-3"></div>
									</div>
									<div class="card-footer">
										<div class="legend"><i class="la la-circle text-primary"></i> Completed</div>
									</div>
								</div>
							</div>
							<div class="col-md-9">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">年度车源货源信息：</h4>
										<p class="card-category">
											请选择要查询的年份：
											<select id="year" class="form-control col-md-6">
												<c:forEach var="years" items="${requestScope.year}">
													<option value="${years.year}">${years.year}</option>
												</c:forEach>
											</select>
										</p>
									</div>
									<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
									<div id="main" class="col-xs-12" style="width: 90%;height: 90%;left: 8%"></div>
								</div>
							</div>
						</div>
						<div class="row row-card-no-pd">
							<div class="col-md-4">
								<div class="card">
									<div class="card-body">
										<p class="fw-bold mt-1">My Balance</p>
										<h4><b>$ 3,018</b></h4>
										<a href="#" class="btn btn-primary btn-full text-left mt-3 mb-3"><i class="la la-plus"></i> Add Balance</a>
									</div>
									<div class="card-footer">
										<ul class="nav">
											<li class="nav-item"><a class="btn btn-default btn-link" href="#"><i class="la la-history"></i> History</a></li>
											<li class="nav-item ml-auto"><a class="btn btn-default btn-link" href="#"><i class="la la-refresh"></i> Refresh</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-5">
								<div class="card">
									<div class="card-body">
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1">
												<span class="text-muted">Profit</span>
												<span class="text-muted fw-bold"> $3K</span>
											</div>
											<div class="progress mb-2" style="height: 7px;">
												<div class="progress-bar bg-success" role="progressbar" style="width: 78%" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="78%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1">
												<span class="text-muted">Orders</span>
												<span class="text-muted fw-bold"> 576</span>
											</div>
											<div class="progress mb-2" style="height: 7px;">
												<div class="progress-bar bg-info" role="progressbar" style="width: 65%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="65%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1">
												<span class="text-muted">Tasks Complete</span>
												<span class="text-muted fw-bold"> 70%</span>
											</div>
											<div class="progress mb-2" style="height: 7px;">
												<div class="progress-bar bg-primary" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="70%"></div>
											</div>
										</div>
										<div class="progress-card">
											<div class="d-flex justify-content-between mb-1">
												<span class="text-muted">Open Rate</span>
												<span class="text-muted fw-bold"> 60%</span>
											</div>
											<div class="progress mb-2" style="height: 7px;">
												<div class="progress-bar bg-warning" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" data-toggle="tooltip" data-placement="top" title="60%"></div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats">
									<div class="card-body">
										<p class="fw-bold mt-1">Statistic</p>
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center icon-warning">
													<i class="la la-pie-chart text-warning"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">Number</p>
													<h4 class="card-title">150GB</h4>
												</div>
											</div>
										</div>
										<hr/>
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-heart-o text-primary"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">Followers</p>
													<h4 class="card-title">+45K</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">用户：</h4>
										<p class="card-category">
										认证与未认证所占比例</p>
									</div>
									<div class="card-body">
										<%--<div id="monthlyChart" class="chart chart-pie"></div>--%>
										<div id="user2" class="col-xs-12" style="width: 90%;height: 90%;left: 5%"></div>
											
									</div>
								</div>
							</div>
							<div class="col-md-8">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">年度用户信息：</h4>
										<p class="card-category">
											请选择要查询的年份：
											<select id="year1" class="form-control col-md-6">
												<c:forEach var="userYear" items="${requestScope.userYear}">
													<option value="${userYear.year}">${userYear.year}</option>
												</c:forEach>
											</select>
										</p>
									</div>
									<div class="card-body">
										<%--<div id="salesChart" class="chart"></div>--%>
										<div id="user" class="col-xs-12" style="width: 90%;height: 90%;left: 5%"></div>

										



									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">用户货源车源信息（天）：</h4>
									</div>
									<div class="card-body">
										<%--<div id="salesChart" class="chart"></div>--%>
										<div id="userGoods" class="col-xs-12" style="width: 90%;height: 90%;left: 5%"></div>

									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="card">
									<div class="card-header ">
										<h4 class="card-title">认证用户信息：</h4>
										<p class="card-category">根据名字查询用户信息：</p>
										<div class="col-lg-6">
											<div class="input-group">
												<input type="text" class="form-control">
												<span class="input-group-btn">
                        						<button class="btn btn-default" type="button">查询</button>
                    							</span>
											</div><!-- /input-group -->
										</div>
									</div>
									<div class="card-body">
										<table class="table table-head-bg-success table-striped table-hover col-md-6">
											<thead>
												<tr>
													<th scope="col">id</th>
													<th scope="col">姓名</th>
													<%--<th scope="col">性别</th>--%>
													<th scope="col">身份证号</th>
													<th scope="col">手机号</th>
												</tr>
											</thead>
											<tbody id="users">
												<c:forEach items="${userlist.list}" var="user" varStatus="status">
													<tr>
														<td style="word-break: break-all;">${user.user_id}</td>
														<td style="word-break: break-all;">${user.wx_nickname}</td>
														<%--<td style="word-break: break-all;">${user.user_sex}</td>--%>
														<td style="word-break: break-all;">${user.user_idnumber}</td>
														<td style="word-break: break-all;">${user.user_phonenumber}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div align="center" id="fenye">
											<p id="fenye1">
												<span>
												当前 ${userlist.pageNum }页,总${userlist.pages } 页,总${userlist.total } 条记录 <input type="hidden" name="page" id="page" />
												</span>
											</p>
											<span id="fenye2">
												<a href="javascript:" onclick="toPage(1)">第一页</a>
											</span>

											<span id="fenye3">
												<c:if test="${userlist.hasPreviousPage }">
													<a href="javascript:" onclick="toPage(${userlist.pageNum-1})">上一页</a>
												</c:if>
											</span>
											<span id="fenye4">
												<c:if test="${userlist.hasNextPage}">
													<a href="javascript:" onclick="toPage(${userlist.pageNum+1})">下一页</a>
												</c:if>
											</span>
											<span id="fenye5">
												<a href="javascript:" onclick="toPage(${userlist.pages})">最后页</a>
											</span>

										</div>

									</div>

								</div>
							</div>

							<script type="text/javascript">
								function toPage(yema) {
									$.ajax({
										url:"<%=basePath%>demo/demo.htm",
										type:"post",
										data:{"pageNo":yema},
										dataType:"json",
										success:function (data) {
											/*console.log(data.pageNum);
											console.log(data.pages);*/
											//console.log(data.list);
											$("#users").html("");
											for(var i = 0;i<data.list.length;i++){
												var users = $("<tr>\n" +
														"<td style=\"word-break: break-all;\">"+data.list[i].user_id+"</td>" +
														"<td style=\"word-break: break-all;\">"+data.list[i].wx_nickname+"</td>" +
														// "<td style=\"word-break: break-all;\">"+data.list[i].user_sex+"</td>" +
														"<td style=\"word-break: break-all;\">"+data.list[i].user_idnumber+"</td>" +
														"<td style=\"word-break: break-all;\">"+data.list[i].user_phonenumber+"</td>" +
														"</tr>");
												$("#users").append(users);
											}
											$("#fenye3").html("");
											if (data.hasPreviousPage) {
												var fenye3 = $("<a href=\"javascript:\" onclick=\"toPage("+(data.pageNum-1)+")\">上一页</a>");
												$("#fenye3").append(fenye3);
											}
											$("#fenye4").html("");
											if (data.hasNextPage) {
												var fenye4 = $("<a href=\"javascript:\" onclick=\"toPage("+(data.pageNum+1)+")\">下一页</a>");
												$("#fenye4").append(fenye4);
											}
											$("#fenye5").html("");
											var fenye5 = $("<a href=\"javascript:\" onclick=\"toPage("+data.pages+")\">最后页</a>");
											$("#fenye5").append(fenye5);

											$("#fenye1").html("");
											var fenye1 = $("<span>" +
													"当前 "+data.pageNum+"页,总"+data.pages+" 页,总"+data.total+" 条记录 <input type=\"hidden\" name=\"page\" id=\"page\" />" +
													"</span>");
											$("#fenye1").append(fenye1);
										},
										error:function () {
											alert("服务器繁忙，请稍后重试")
										}
									});
								}
							</script>


							<div class="col-md-6">
								<div class="card card-tasks">
									<div class="card-header ">
										<h4 class="card-title">Tasks</h4>
										<p class="card-category">To Do List</p>
									</div>
									<div class="card-body ">
										<div class="table-full-width">
											<table class="table">
												<thead>
													<tr>
														<th>
															<div class="form-check">
																<label class="form-check-label">
																	<input class="form-check-input  select-all-checkbox" type="checkbox" data-select="checkbox" data-target=".task-select">
																	<span class="form-check-sign"></span>
																</label>
															</div>
														</th>
														<th>Task</th>
														<th>Action</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label">
																	<input class="form-check-input task-select" type="checkbox">
																	<span class="form-check-sign"></span>
																</label>
															</div>
														</td>
														<td>Planning new project structure</td>
														<td class="td-actions text-right">
															<div class="form-button-action">
																<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">
																	<i class="la la-edit"></i>
																</button>
																<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">
																	<i class="la la-times"></i>
																</button>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label">
																	<input class="form-check-input task-select" type="checkbox">
																	<span class="form-check-sign"></span>
																</label>
															</div>
														</td>
														<td>Update Fonts</td>
														<td class="td-actions text-right">
															<div class="form-button-action">
																<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">
																	<i class="la la-edit"></i>
																</button>
																<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">
																	<i class="la la-times"></i>
																</button>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label">
																	<input class="form-check-input task-select" type="checkbox">
																	<span class="form-check-sign"></span>
																</label>
															</div>
														</td>
														<td>Add new Post
														</td>
														<td class="td-actions text-right">
															<div class="form-button-action">
																<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">
																	<i class="la la-edit"></i>
																</button>
																<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">
																	<i class="la la-times"></i>
																</button>
															</div>
														</td>
													</tr>
													<tr>
														<td>
															<div class="form-check">
																<label class="form-check-label">
																	<input class="form-check-input task-select" type="checkbox">
																	<span class="form-check-sign"></span>
																</label>
															</div>
														</td>
														<td>Finalise the design proposal</td>
														<td class="td-actions text-right">
															<div class="form-button-action">
																<button type="button" data-toggle="tooltip" title="Edit Task" class="btn btn-link <btn-simple-primary">
																	<i class="la la-edit"></i>
																</button>
																<button type="button" data-toggle="tooltip" title="Remove" class="btn btn-link btn-simple-danger">
																	<i class="la la-times"></i>
																</button>
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="card-footer ">
										<div class="stats">
											<i class="now-ui-icons loader_refresh spin"></i> Updated 3 minutes ago
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
							2019, made with <i class="la la-heart heart text-danger"></i> by <a href="#">奈落落</a> - More Templates - Collect from <a href="https://tieba.baidu.com/f?fr=wwwt&kw=%E5%A5%88%E8%90%BD%E8%90%BD" title="奈落落" target="_blank">奈落落</a></div>				
					</div>
				</footer>
			</div>
<script src="<%=basePath%>css/assets/js/demo.js"></script>
<script src="<%=basePath%>js/manage/welcome.js"></script>
</body>

</html>