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
			<!-- 页面头部 -->
			<!-- 导航侧栏 -->
			<jsp:include page="sidebar.jsp"></jsp:include>
			<!-- 导航侧栏 -->

			<!-- 内容区域 -->
			<div class="content-wrapper">
				<img src="${pageContext.request.contextPath}/img/content.jpg" />
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