<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/static/laydate/laydate.js"></script>
</head>
<body>
	<div>
		<table>
			<!-- 表头123-->
			<thead>
				<tr>
					<td colspan="5" align="center"><h2>航班信息管理系统</h2></td>
					<td align="right">
						<input type="button" value="添加航班" name="add_flight"/>
						<input type="button" value="编辑航班" name="edit_flight"/>
						<input type="button" value="删除航班" name="del_flight" onclick="delFlightInfo()"/>
					</td>
				</tr>
				<tr>
					<td colspan="6" align="center">
						出发地：<select name="start"></select>&nbsp;&nbsp;&nbsp;
						到达地：<select name="dest"></select>&nbsp;&nbsp;&nbsp;
						<!--触发事件使用My97DatePicker日期组件 -->
     <font color="green">出发日期：</font><input type="text" id="test2" placeholder="请选择日期" readonly="readonly">
     <!-- <input type="text"  onClick="WdatePicker()" readonly="readonly" name="startime"> -->&nbsp;&nbsp;&nbsp;
     					<input type="button" value="查询" onclick="getPageInfo(1)"/>
					</td>
				</tr>
				<tr>
					<th align="center"><input type="checkbox" name='flightNoOne'/></th>
					<th align="center">航班号</th>
					<th align="center">出发地</th>
					<th align="center">目的地</th>
					<th align="center">起飞时间</th>
					<th align="center">到达时间</th>
					<th align="center">机票价格</th>
				</tr>
			</thead>
			<tbody id="tb"></tbody>
			<tfoot id="tf"></tfoot>
		</table>
		<br/>
		<table id="saveFlight" style="display:none;">
			<form>
			<tbody>
				<tr>
					<th>航班号：</th>
					<td><input type="text" name="filghtId" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>出发地：</th>
					<td>
						<select name="origin"></select>
					</td>
				</tr>
				<tr>
					<th>到达地：</th>
					<td>
						<select name="destination"></select>
					</td>
				</tr>
				<tr>
					<th>起飞时间：</th>
					<td>
					<input type="text" name="takeOffTime"/>
					<input type="text" placeholder="请选择日期" id="test1">
					</td>
				</tr>
				<tr>
					<th>到达时间：</th>
					<td><input type="text" name="arriveTime"/></td>
				</tr>
				<tr>
					<th>机票价格：</th>
					<td><input type="text" name="price"/></td>
				</tr>
			</tbody>
			</form>
			<tfoot>
				<td colspan="2" align="center">
					<input type="button" value="保存" onclick="editFlightInfo()"/>
					<input type="button" value="返回" name="return_flight"/>
				</td>
			</tfoot>
		</table>
	</div>
	
	<script type="text/javascript">
		$(function(){
			getAddressInfo();
			getPageInfo(1);
			$("input[name='add_flight']").click(function(){
				getFlightNo();
				$("#saveFlight").show();
			});
			$("input[name='return_flight']").click(function(){
				$("#saveFlight").hide();
			});
			$("input[name='edit_flight']").click(function(){
				getFlightInfo();
			});
			//执行一个laydate实例
			 laydate.render({
			  elem: '#test1',
			  type:'datetime' //指定元素
			}); 
			 laydate.render({
				  elem: '#test2'
				}); 
		});
		//获取航班号
		function getFlightNo(){
				$.ajax({
					url:"${pageContext.request.contextPath}/flight/getFlightNo",
					type:"post",
					dataType:"text",
					success:function(data){
						if(data!=""){
							$("input[name='filghtId']").val(data);
						}
					}
				});
		}
		
		//删除航班信息
		function delFlightInfo(){
			var flightNo=$("input[name='flightNo']:checked").val();
				if(flightNo!=null){
					var flag=confirm("确定删除航班："+flightNo+" 吗？");
					if(flag){
						$.post("${pageContext.request.contextPath}/flight/delFlightInfo",{"flightNo":flightNo},function(data){
							if(data=="ok"){
								alert("删除成功！");
								getPageInfo(1);
							}else{
								alert("删除失败！");
							}
						},"text");	
					}
				}else{
					alert("请选择要删除的航班！");
				}
		}
		
		//编辑航班信息
		function editFlightInfo(){
			var flightNo=$("input[name='flightNo']:checked").val();
			var filghtId=$("input[name='filghtId']").val().trim();
			var origin=$("select[name='origin']").val();
			var destination=$("select[name='destination']").val();
			var takeOffTime=$("input[name='takeOffTime']").val();
			var arriveTime=$("input[name='arriveTime']").val();
			var price=$("input[name='price']").val().trim();
			if(flightNo!=null){
				$.ajax({
					url:"${pageContext.request.contextPath}/flight/editFlightInfo",
					type:"post",
					data:{"filghtId":filghtId,"origin":origin,"destination":destination,"takeOffTime":takeOffTime,"arriveTime":arriveTime,"price":price},
					dataType:"text",
					success:function(data){
						if(data=="ok"){
							alert("保存成功！");
							$("input[name='filghtId']").val("");
							$("select[name='origin']").val(0);
							$("select[name='destination']").val(0);
							$("input[name='takeOffTime']").val("");
							$("input[name='arriveTime']").val("");
							$("input[name='price']").val("");
							getPageInfo(1);
						}else{
							alert("保存失败！");
						}
					}
				});
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/flight/saveFlightInfo",
					type:"post",
					data:{"filghtId":filghtId,"origin":origin,"destination":destination,"takeOffTime":takeOffTime,"arriveTime":arriveTime,"price":price},
					dataType:"text",
					success:function(data){
						if(data=="ok"){
							alert("保存成功！");
							getFlightNo();
							$("select[name='origin']").val(0);
							$("select[name='destination']").val(0);
							$("input[name='takeOffTime']").val("");
							$("input[name='arriveTime']").val("");
							$("input[name='price']").val("");
							getPageInfo(1);
						}else{
							alert("保存失败！");
						}
					}
				});	
			}
		}
		
		//根据航班号获取航班信息
		function getFlightInfo(){
			var flightNo=$("input[name='flightNo']:checked").val();
			if(flightNo!=null){
				$.post("${pageContext.request.contextPath}/flight/getFlight",{"flightNo":flightNo},function(data){
					$("input[name='filghtId']").val(data.filghtId)
					$("select[name='origin']").val(data.origin);
					$("select[name='destination']").val(data.destination);
					$("input[name='takeOffTime']").val(data.takeOffTime);
					$("input[name='arriveTime']").val(data.arriveTime);
					$("input[name='price']").val(data.price);
					$("#saveFlight").show();
				},"json");
			}else{
				alert("请选择要编辑的航班！");
			}
		}
		
		
		//获取所有航班地点信息
		function getAddressInfo(){
			$.ajax({
				url:"${pageContext.request.contextPath}/address/getAllAddress",
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.length>0){
						var op="<option value='0'>请选择</option>";
						$.each(data,function(i,e){
							op+="<option value='"+e.addressId+"'>"+e.addressName+"</option>";
						});
						$("select[name='start']").html(op);
						$("select[name='dest']").html(op);
						$("select[name='destination']").html(op);
						$("select[name='origin']").html(op);
					}
				}
			});
		}
		
		
		//获取航班页码信息
		function getPageInfo(pageIndex){
			var start=$("select[name='start']").val();
			var dest=$("select[name='dest']").val();
			var startime=$("input[name='startime']").val();
			var flag=true;
			if(start!=0&&dest==0){
				alert("请选择到达地！！！");
				flag=false;
			}else if(start==0&&dest!=0){
				alert("请选择出发地！！！");
				flag=false;
			}
			if(flag){
				$.ajax({
					url:"${pageContext.request.contextPath}/flight/getPageInfo",
					type:"post",
					data:{"pageIndex":pageIndex,"start":start,"dest":dest,"startTime":startime},
					dataType:"json",
					success:function(data){
						if(data.data_list.length>0){
							var tr="";
							var page="<tr>"+
										"<td colspan='4' align='center' >";
							$.each(data.data_list,function(i,e){
								tr+="<tr>"+
										"<td align='center'><input type='checkbox' name='flightNo' value='"+e.filghtId+"'/></td>"+
										"<td align='center'>"+e.filghtId+"</td>"+
										"<td align='center'>"+e.originInfo+"</td>"+
										"<td align='center'>"+e.destinationInfo+"</td>"+
										"<td align='center'>"+e.takeOffTime+"</td>"+
										"<td align='center'>"+e.arriveTime+"</td>"+
										"<td align='center'>"+e.price+"</td>"+
									"</tr>";
							});
							if(data.pageIndex>1){
								page+="<a href='javascript:getPageInfo(1)'>首页</a>&nbsp;&nbsp;<a href='javascript:getPageInfo("+(data.pageIndex-1)+")'>上一页</a>";
							}
							if(data.pageIndex<data.pageCount){
								page+="&nbsp;&nbsp;<a href='javascript:getPageInfo("+(data.pageIndex+1)+")'>下一页</a>&nbsp;&nbsp;<a href='javascript:getPageInfo("+data.pageCount+")'>末页</a></td>";
							}
							page+="<td colspan='2' align='right'>当前:第"+data.pageIndex+"页/共:"+data.pageCount+"页</td></tr>";
							$("#tb").html(tr);
							$("#tf").html(page);
						}else{
							$("#tb").html("");
							$("#tb").html("<tr><td colspan='6' align='center'>没有找到相关的航班信息！！！</td></tr>");
							$("#tf").html("<tr><td colspan='6' align='right'>当前:第0页/共:0页</td></tr>");
						}
					}
				}); 	
			}
		}
	</script>
</body>
</html>