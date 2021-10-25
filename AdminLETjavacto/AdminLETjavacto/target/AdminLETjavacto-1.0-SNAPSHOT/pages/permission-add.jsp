<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
			<!-- 导航侧栏 -->
							
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- 导航侧栏 /-->
			<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				资源权限管理 <small>资源权限表单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/pages/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/rest/permission/findAll.do">资源权限管理</a></li>
				<li class="active">资源权限表单</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<form action="${pageContext.request.contextPath}/rest/permission/save.do"
				method="post">
				<!-- 正文区域 -->

				<section class="content"> <!--产品信息-->

				<div class="panel panel-default">
					<div class="panel-heading">资源权限信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">权限名称</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="permissionName"
								placeholder="权限名称" value="">
						</div>
						<div class="col-md-2 title">RUL</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" name="url"
								placeholder="URL" value="">
						</div>
										

					</div>
				</div>
				<!--订单信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
						onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/--> </section>
				<!-- 正文区域 /-->
			</form>
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