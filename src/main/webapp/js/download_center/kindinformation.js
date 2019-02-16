 	$(function(){
			$.ajax({
			async:false,
			type : 'GET',
			url : 'download_center.htm',
			dataType: 'json',
			success : function(data) {
				managelist=data;
			//	console.log(data);
				//console.log(data.length);
			var html="";
			for ( var i = 0; i < data.length; i++) {
				 html="<option name="+ data[i].kindName+" value=" + data[i].id + ">"+ data[i].kindName +"</option>";  
				 //selectdown为select选择框id 上面的代码拼出所有的 option选项卡
				 $("#selectdown").append(html); 
			}
			}	
			});
		//	console.log(managelist);
			hreflist();
			});
 	
 	function hreflist(){
 		//这里 展示动态的 图片和下载链接
			var options=$("#selectdown option:selected");
			if(options.text()!=null && options.text()!="undefined" ){
				if(managelist!=null && managelist != '{}'){
						for(i=0;i<managelist.length;i++){
							//若查询出的和选中的一致时
							if(managelist[i].kindName == options.text()){
								$("#kindName").val(options.text());
								$("#downhref").val(managelist[i].downHref);
				//				 console.log($("#downhref").val());
							}
						}
						}
			}
			//console.log($("#downhref").val());
	}