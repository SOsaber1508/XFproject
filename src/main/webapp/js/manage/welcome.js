$(document).ready(function(){
	var myChart;
	var myChart1;
	var myChart2;
	var myChart3;
	$("#year").change(function(){
		if(myChart != null && myChart != "" && myChart != undefined) {
			myChart.dispose();
		}
		//要触发的事件
		// 基于准备好的dom，初始化echarts实例
		myChart = echarts.init(document.getElementById('main'));
		$.ajax({
			url:getRootPath()+"/login/selectGoodsOrderNumber.htm",
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
							// min: 0,
							// max: 200,
							// interval: 50,
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
							data:[data.Vehicle1, data.Vehicle2, data.Vehicle3, data.Vehicle4, data.Vehicle5, data.Vehicle6,
								data.Vehicle7, data.Vehicle8, data.Vehicle9, data.Vehicle10, data.Vehicle11, data.Vehicle12]
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
		url:getRootPath()+"/login/selectGoodsOrderNumber.htm",
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
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
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
						// min: 0,
						// max: 200,
						// interval: 50,
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
						data:[data.Vehicle1, data.Vehicle2, data.Vehicle3, data.Vehicle4, data.Vehicle5, data.Vehicle6,
							data.Vehicle7, data.Vehicle8, data.Vehicle9, data.Vehicle10, data.Vehicle11, data.Vehicle12]
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
	

	$("#user").change(function() {
		if (myChart1 != null && myChart1 != "" && myChart1 != undefined) {
			myChart1.dispose();
		}
		myChart1 = echarts.init(document.getElementById('user'));
		$.ajax({
			url:getRootPath()+"/login/selectUserYearNumber.htm",
			type:"POST",
			data:{"year":$("#year1").val()},
			dataType:"json",
			success:function(data) {

				option1 = {
					title: {
						text: '折线图堆叠'
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data:['授权用户数','认证用户数']
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					toolbox: {
						feature: {
							saveAsImage: {}
						}
					},
					xAxis: {
						type: 'category',
						boundaryGap: false,
						data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
					},
					yAxis: {
						type: 'value'
					},
					series: [
						{
							name:'授权用户数',
							type:'line',
							data:[data.ShouQuanUser1, data.ShouQuanUser2, data.ShouQuanUser3, data.ShouQuanUser4, data.ShouQuanUser5, data.ShouQuanUser6,
								data.ShouQuanUser7, data.ShouQuanUser8, data.ShouQuanUser9, data.ShouQuanUser10, data.ShouQuanUser11, data.ShouQuanUser12],
							smooth: true
						},
						{
							name:'认证用户数',
							type:'line',
							data:[data.RenZhengUser1, data.RenZhengUser2, data.RenZhengUser3, data.RenZhengUser4, data.RenZhengUser5, data.RenZhengUser6,
								data.RenZhengUser7, data.RenZhengUser8, data.RenZhengUser9, data.RenZhengUser10, data.RenZhengUser11, data.RenZhengUser12],
							smooth: true
						},
					]
				};

				myChart1.setOption(option1);
				window.addEventListener("resize",function () {
					myChart1.resize();
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

	myChart1 = echarts.init(document.getElementById('user'));
	$.ajax({
		url:getRootPath()+"/login/selectUserYearNumber.htm",
		type:"POST",
		data:{"year":$("#year1").val()},
		dataType:"json",
		success:function(data) {

			option1 = {
				title: {
					text: '折线图堆叠'
				},
				tooltip: {
					trigger: 'axis'
				},
				legend: {
					data:['授权用户数','认证用户数']
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				toolbox: {
					feature: {
						saveAsImage: {}
					}
				},
				xAxis: {
					type: 'category',
					boundaryGap: false,
					data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
				},
				yAxis: {
					type: 'value'
				},
				series: [
					{
						name:'授权用户数',
						type:'line',
						data:[data.ShouQuanUser1, data.ShouQuanUser2, data.ShouQuanUser3, data.ShouQuanUser4, data.ShouQuanUser5, data.ShouQuanUser6,
							data.ShouQuanUser7, data.ShouQuanUser8, data.ShouQuanUser9, data.ShouQuanUser10, data.ShouQuanUser11, data.ShouQuanUser12],
						smooth: true
					},
					{
						name:'认证用户数',
						type:'line',
						data:[data.RenZhengUser1, data.RenZhengUser2, data.RenZhengUser3, data.RenZhengUser4, data.RenZhengUser5, data.RenZhengUser6,
							data.RenZhengUser7, data.RenZhengUser8, data.RenZhengUser9, data.RenZhengUser10, data.RenZhengUser11, data.RenZhengUser12],
						smooth: true
					},
				]
			};

			myChart1.setOption(option1);
			window.addEventListener("resize",function () {
				myChart1.resize();
			})
		},
		error:function () {
			alert("请求失败");
		},
		complete:function () {
			//alert("请求成功与否，都会执行");
		}
	});

	myChart2 = echarts.init(document.getElementById('user2'));
	$.ajax({
		url:getRootPath()+"/login/selectUserBiLi.htm",
		type:"POST",
		data:{},
		dataType:"json",
		success:function(data) {
			option2 = {
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b}: {c} ({d}%)"
				},
				legend: {
					orient: 'vertical',
					x: 'left',
					data:['未认证用户','已认证用户']
				},
				series: [
					{
						name:'访问来源',
						type:'pie',
						radius: ['50%', '70%'],
						avoidLabelOverlap: false,
						label: {
							normal: {
								show: false,
								position: 'center'
							},
							emphasis: {
								show: true,
								textStyle: {
									fontSize: '25',
									fontWeight: 'bold'
								}
							}
						},
						labelLine: {
							normal: {
								show: false
							}
						},
						data:[
							{value:data.weiRenZheng, name:'未认证用户',itemStyle:{color:'#d64230'}},
							{value:data.yiRenZheng, name:'已认证用户',itemStyle:{color:'#a9df55'}}
						]
					}
				]
			};

			myChart2.setOption(option2);
			window.addEventListener("resize",function () {
				myChart2.resize();
			})
		},
		error:function () {
			alert("请求失败");
		},
		complete:function () {
			//alert("请求成功与否，都会执行");
		}
	});

	myChart3 = echarts.init(document.getElementById('userGoods'));
	option3 = {
		tooltip: {
			trigger: 'axis',
			axisPointer: {
				type: 'shadow',
				label: {
					show: true
				}
			}
		},
		toolbox: {
			show: true,
			feature: {
				mark: {show: true},
				dataView: {show: true, readOnly: false},
				magicType: {show: true, type: ['line', 'bar']},
				restore: {show: true},
				saveAsImage: {show: true}
			}
		},
		calculable: true,
		legend: {
			data:['Growth', 'Budget 2011', 'Budget 2012'],
			itemGap: 5
		},
		grid: {
			top: '12%',
			left: '2%',
			right: '10%',
			containLabel: true
		},
		xAxis: [
			{
				name: '日期',
				type: 'category',
				data: []
			}
		],
		yAxis: [
			{
				type: 'value',
				name: '数量',
				axisLabel: {
					formatter: function (a) {
						a= +a;
						return isFinite(a)
								? echarts.format.addCommas(+a / 1)
								: '';
					}
				}
			}
		],
		dataZoom: [
			{
				show : true,
				start: 0,
				end  : 100
			},
			{
				type: 'inside',
				start: 0,
				end: 100
			},
			{
				show: true,
				yAxisIndex: 0,
				filterMode: 'empty',
				width: 30,
				height: '80%',
				showDataShadow: false,
				left: '93%'
			}
		],
		series: [
			{
				name: '用户授权数',
				type: 'bar',
				data: []
			},
			{
				name: '用户认证数',
				type: 'bar',
				data: []
			},
			{
				name: '发布货源数',
				type: 'bar',
				data: []
			},
			{
				name: '发布车源数',
				type: 'bar',
				data: []
			}
		]
	};
	myChart3.setOption(option3);
	window.addEventListener("resize",function () {
	myChart3.resize();
	});
	myChart3.showLoading({
		text: '正在加载...',
		textStyle: { fontSize : 30 , color: '#444' },
		effectOption: {backgroundColor: 'rgba(0, 0, 0, 0)'}
	});
	$.ajax({
		url:getRootPath()+"/login/selectAllUserGoodsNumber.htm",
		type:"POST",
		data:{},
		dataType:"json",
		success:function(data) {
			myChart3.hideLoading();
			myChart3.setOption({        //加载数据图表
				xAxis: [
					{
						name: '日期',
						type: 'category',
						data: data.datas
					}
				],
				series: [
					{
						name: '用户授权数',
						type: 'bar',
						data: data.UserNumber
					},
					{
						name: '用户认证数',
						type: 'bar',
						data: data.UserRenZhengNumber
					},
					{
						name: '发布货源数',
						type: 'bar',
						data: data.GoodsNumber
					},
					{
						name: '发布车源数',
						type: 'bar',
						data: data.VehicleNumber
					}
				]
    });

},
error:function () {
alert("请求失败");
},
complete:function () {
//alert("请求成功与否，都会执行");
}
});

});


//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(0,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    //var path =localhostPaht+projectName;
    return(localhostPaht+projectName);
}