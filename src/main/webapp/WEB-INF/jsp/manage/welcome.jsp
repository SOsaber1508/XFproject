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
	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
	<!--  <script src="<%=basePath%>css/my/js/echarts.js"></script>-->
</head>
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
													<p class="card-category">用户数量</p>
													<h4 class="card-title">${requestScope.userNumber}</h4>
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
													<p class="card-category">车源总量</p>
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
													<p class="card-category">货源总量</p>
													<h4 class="card-title">${requestScope.doodsNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="card card-stats card-primary">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-check-circle"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">车源完成数量</p>
													<h4 class="card-title">${requestScope.vehiceStateNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2">
								<div class="card card-stats card-default">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-bar-chart text-success"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">货源完成数量</p>
													<h4 class="card-title">${requestScope.doodsStateNumber}</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
<!-- 							<div class="col-md-3">
								<div class="card card-stats">
									<div class="card-body ">
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
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats">
									<div class="card-body ">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-bar-chart text-success"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">Revenue</p>
													<h4 class="card-title">$ 1,345</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats">
									<div class="card-body">
										<div class="row">
											<div class="col-5">
												<div class="icon-big text-center">
													<i class="la la-times-circle-o text-danger"></i>
												</div>
											</div>
											<div class="col-7 d-flex align-items-center">
												<div class="numbers">
													<p class="card-category">Errors</p>
													<h4 class="card-title">23</h4>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="card card-stats">
									<div class="card-body">
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
							</div> -->
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
										<h4 class="card-title">年度订单信息：</h4>
										<p class="card-category">
											请选择要查询的年份：
											<select id="year" class="form-control col-md-6">
												<c:forEach var="years" items="${requestScope.year}">
													<option value="${years.year}">${years.year}</option>
												</c:forEach>
											</select>
										</p>
									</div>
									<%--<div class="card-body">
										<div class="mapcontainer" id="biao" style="width: 600px;height:400px;">

										</div>
									</div>--%>
									<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
									<div id="main" class="col-xs-12" style="width: 90%;height: 50%;left: 5%"></div>
									<script type="text/javascript">
										var myChart;
										$("#year").change(function(){
											if(myChart != null && myChart != "" && myChart != undefined) {
												myChart.dispose();
											}
											//要触发的事件
											// 基于准备好的dom，初始化echarts实例
											myChart = echarts.init(document.getElementById('main'));
											$.ajax({
												url:"<%=basePath%>login/selectGoodsOrderNumber.htm",
												type:"POST",
												data:{"year":$("#year").val()},
												dataType:"json",
												success:function(data) {

													// 指定图表的配置项和数据
													var option = {
														tooltip: {
															trigger: 'axis',
															axisPointer: {
																type: 'cross',
																crossStyle: {
																	color: '#999'
																}
															}
														},
														toolbox: {
															feature: {
																dataView: {show: true, readOnly: false},
																magicType: {show: true, type: ['line', 'bar']},
																restore: {show: true},
																saveAsImage: {show: true}
															}
														},
														legend: {
															data:['货源发布数量','车源发布数量'/*,'平均温度'*/]
														},
														xAxis: [
															{
																type: 'category',
																data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
																axisPointer: {
																	type: 'shadow'
																}
															}
														],
														yAxis: [
															{
																type: 'value',
																name: '发布数量',
																min: 0,
																max: 200,
																interval: 50,
																axisLabel: {
																	formatter: '{value} 单'
																}
															},
															{
																type: 'value',
																/*name: '温度',
                                                                min: 0,
                                                                max: 25,
                                                                interval: 5,
                                                                axisLabel: {
                                                                    formatter: '{value} °C'
                                                                }*/
															}
														],
														series: [
															{
																name:'货源发布数量',
																type:'bar',
																data:[data.Goods1, data.Goods2, data.Goods3, data.Goods4, data.Goods5, data.Goods6,
																	data.Goods7, data.Goods8, data.Goods9, data.Goods10, data.Goods11, data.Goods12]
																//json.y
															},
															{
																name:'车源发布数量',
																type:'bar',
																data:[data.Vehice1, data.Vehice2, data.Vehice3, data.Vehice4, data.Vehice5, data.Vehice6,
																	data.Vehice7, data.Vehice8, data.Vehice9, data.Vehice10, data.Vehice11, data.Vehice12]
															},
															/*{
                                                                name:'平均温度',
                                                                type:'line',
                                                                yAxisIndex: 1,
                                                                data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                                                            }*/
														]
													};
													myChart.setOption(option);
													window.addEventListener("resize",function () {
														myChart.resize();
													})


												},
												error:function () {
													alert("请求失败");
												},
												complete:function () {
													//alert("请求成功与否，都会执行");
												}
											});



										});
										// 基于准备好的dom，初始化echarts实例
										myChart = echarts.init(document.getElementById('main'));
										$.ajax({

											url:"<%=basePath%>login/selectGoodsOrderNumber.htm",
											type:"POST",
											data:{"year":$("#year").val()},
											dataType:"json",
											success:function(data) {

												// 指定图表的配置项和数据
												var option = {
													tooltip: {
														trigger: 'axis',
														axisPointer: {
															type: 'cross',
															crossStyle: {
																color: '#999'
															}
														}
													},
													toolbox: {
														feature: {
															dataView: {show: true, readOnly: false},
															magicType: {show: true, type: ['line', 'bar']},
															restore: {show: true},
															saveAsImage: {show: true}
														}
													},
													legend: {
														data:['货源发布数量','车源发布数量'/*,'平均温度'*/]
													},
													xAxis: [
														{
															type: 'category',
															data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
															//data:json.x
															axisPointer: {
																type: 'shadow'
															}
														}
													],
													yAxis: [
														{
															type: 'value',
															name: '发布数量',
															min: 0,
															max: 200,
															interval: 50,
															axisLabel: {
																formatter:'{value}'
															}
														},
														{
															type: 'value',
															/*name: '温度',
															min: 0,
															max: 25,
															interval: 5,
															axisLabel: {
																formatter: '{value} °C'
															}*/
														}
													],
													series: [
														{
															name:'货源发布数量',
															type:'bar',
															data:[data.Goods1, data.Goods2, data.Goods3, data.Goods4, data.Goods5, data.Goods6,
																data.Goods7, data.Goods8, data.Goods9, data.Goods10, data.Goods11, data.Goods12]
															//json.y
														},
														{
															name:'车源发布数量',
															type:'bar',
															data:[data.Vehice1, data.Vehice2, data.Vehice3, data.Vehice4, data.Vehice5, data.Vehice6,
																data.Vehice7, data.Vehice8, data.Vehice9, data.Vehice10, data.Vehice11, data.Vehice12]
														},
														/*{
															name:'平均温度',
															type:'line',
															yAxisIndex: 1,
															data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
														}*/
													]
												};
												myChart.setOption(option);
												window.addEventListener("resize",function () {
													myChart.resize();
												})


											},
											error:function () {
												alert("请求失败");
											},
											complete:function () {
												//alert("请求成功与否，都会执行");
											}
										});
									</script>
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
										<h4 class="card-title">Users Statistics</h4>
										<p class="card-category">
										Users statistics this month</p>
									</div>
									<div class="card-body">
										<div id="monthlyChart" class="chart chart-pie"></div>
									</div>
								</div>
							</div>
							<div class="col-md-8">
								<div class="card">
									<div class="card-header">
										<h4 class="card-title">2018 Sales</h4>
										<p class="card-category">
										Number of products sold</p>
									</div>
									<div class="card-body">
										<div id="salesChart" class="chart"></div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card">
									<div class="card-header ">
										<h4 class="card-title">Table</h4>
										<p class="card-category">Users Table</p>
									</div>
									<div class="card-body">
										<table class="table table-head-bg-success table-striped table-hover">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">First</th>
													<th scope="col">Last</th>
													<th scope="col">Handle</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Mark</td>
													<td>Otto</td>
													<td>@mdo</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Jacob</td>
													<td>Thornton</td>
													<td>@fat</td>
												</tr>
												<tr>
													<td>3</td>
													<td colspan="2">Larry the Bird</td>
													<td>@twitter</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
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
</body>

</html>