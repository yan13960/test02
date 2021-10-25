<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="comm.jsp"%>
<html>
	<head>
		<!-- 页面meta -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>数据 - AdminLTE2定制版</title>
		<meta name="description" content="AdminLTE2定制版">
		<meta name="keywords" content="AdminLTE2定制版">

		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
		
	</head>

	<body class="hold-transition skin-purple sidebar-mini">

		<div class="wrapper">
			<!-- 页面头部 -->
			
						
			<jsp:include page="header.jsp"></jsp:include>
			<!-- 导航侧栏 -->
			
					
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- 导航侧栏 /-->
			
		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				订单管理 <small>全部订单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="all-admin-index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="all-order-manage-list.jsp">订单管理</a></li>
				<li class="active">订单详情</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!--订单信息-->
			<div class="panel panel-default">
				<div class="panel-heading">订单信息</div>
				<div class="row data-type">

					<div class="col-md-2 title">订单编号</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="订单编号"
							value="${orders.orderNum }" readonly="readonly">
					</div>

					<div class="col-md-2 title">下单时间</div>
					<div class="col-md-4 data">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>

							<input type="text" class="form-control pull-right"
								id="datepicker-a3" readonly="readonly"
								value="<fmt:formatDate value='${orders.orderTime }' pattern='yyyy-MM-dd HH:mm:ss'></fmt:formatDate>">
						</div>
					</div>
					<div class="col-md-2 title">路线名称</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="路线名称"
							value="${orders.product.productName }" readonly="readonly">
					</div>

					<div class="col-md-2 title">出发城市</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="出发城市"
							value="${orders.product.cityName }" readonly="readonly">
					</div>

					<div class="col-md-2 title">出发时间</div>
					<div class="col-md-4 data">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right"
								id="datepicker-a6" value="<fmt:formatDate value='${orders.product.departureTime}' pattern='yyyy-MM-dd HH:mm:ss'></fmt:formatDate>"
								readonly="readonly">
						</div>
					</div>
					<div class="col-md-2 title">出游人数</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="出游人数"
							value="${orders.peopleCount}" readonly="readonly">
					</div>

					<div class="col-md-2 title rowHeight2x">其他信息</div>
					<div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" rows="3" placeholder="其他信息">
							${orders.orderDesc }
						</textarea>
					</div>

				</div>
			</div>
			<!--订单信息/--> <!--游客信息-->
			<div class="panel panel-default">
				<div class="panel-heading">游客信息</div>
				<!--数据列表-->
				<table id="dataList"
					class="table table-bordered table-striped table-hover dataTable">
					<thead>
						<tr>
							<th class="">人群</th>
							<th class="">姓名</th>
							<th class="">性别</th>
							<th class="">手机号码</th>
							<th class="">证件类型</th>
							<th class="">证件号码</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="traveller" items="${orders.travellers}">

							<tr>
								<td>${traveller.travellerTypeStr}</td>
								<td><input type="text" size="10" value="${traveller.name }"
									readonly="readonly"></td>
								<td><input type="text" size="10" value="${traveller.sex }"
									readonly="readonly"></td>
								<td><input type="text" size="20"
									value="${traveller.phoneNum }" readonly="readonly"></td>
								<td><input type="text" size="15"
									value="${traveller.credentialsTypeStr}" readonly="readonly"></td>
								<td><input type="text" size="28"
									value="${traveller.credentialsNum }" readonly="readonly"></td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
				<!--数据列表/-->
			</div>
			<!--游客信息/--> <!--联系人信息-->
			<div class="panel panel-default">
				<div class="panel-heading">联系人信息</div>
				<div class="row data-type">

					<div class="col-md-2 title">会员</div>
					<div class="col-md-4 data text">${orders.member.nickname }</div>

					<div class="col-md-2 title">联系人</div>
					<div class="col-md-4 data text">${orders.member.name}</div>

					<div class="col-md-2 title">手机号</div>
					<div class="col-md-4 data text">${orders.member.phoneNum}</div>

					<div class="col-md-2 title">邮箱</div>
					<div class="col-md-4 data text">${orders.member.email}</div>

				</div>
			</div>
			<!--联系人信息/--> <!--费用信息--> <c:if test="${orders.orderStatus==1}">
				<div class="panel panel-default">
					<div class="panel-heading">费用信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">支付方式</div>
						<div class="col-md-4 data text">在线支付-${orders.payTypeStr}</div>

						<div class="col-md-2 title">金额</div>
						<div class="col-md-4 data text">￥${orders.product.productPrice}</div>

					</div>
				</div>
			</c:if> <!--费用信息/--> <!--工具栏-->
			<div class="box-tools text-center">

				<button type="button" class="btn bg-default"
					onclick="history.back(-1);">返回</button>
			</div>
			<!--工具栏/--> </section>
			<!-- 正文区域 /-->


		</div>
		<!-- 内容区域 /-->
			<!-- 底部导航 -->
			<footer class="main-footer">
				<div class="pull-right hidden-xs">
					<b>Version</b> 1.0.8
				</div>
				<strong>Copyright &copy; 2028-2038 <a href="">研究院研发部</a>.</strong> All rights reserved.
			</footer>
			<!-- 底部导航 /-->
		</div>

		
		
	</body>

</html>
<!---->