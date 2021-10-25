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
			
		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				用户管理 <small>全部用户</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>

				<li class="active">全部用户</li>
			</ol>
			</section>
			<!-- 内容头部 /-->
				<!-- 正文区域 -->
				<section class="content"> <!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">列表</h3>
					</div>

					<div class="box-body">

						<!-- 数据表格 -->
						<div class="table-box">

							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/user-add.jsp'">
											<i class="fa fa-file-o"></i> 新建
										</button>
										<%--<button type="button" class="btn btn-default" title="新建" onclick="location.href='user-add.jsp'">
											<i class="fa fa-file-o"></i> 新建
										</button>--%>
										<button type="button" class="btn btn-default" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>
									</div>
								</div>
							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input type="text" class="form-control input-sm"
										placeholder="搜索"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</div>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">用户名</th>
										<th class="sorting_asc sorting_asc_disabled">邮箱</th>
										<th class="sorting_desc sorting_desc_disabled">联系电话</th>
										<th class="sorting">状态</th>
										<th class="text-center">操作</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${userList}" var="user">
										<tr>
											<td><input name="ids" type="checkbox"></td>
											<td>${user.id }</td>
											<td>${user.username }</td>
											<td>${user.email }</td>
											<td>${user.phoneNum }</td>
											<td>${user.statusStr }</td>											
											<td class="text-center">
												<a href="${pageContext.request.contextPath}/rest/user/findById.do?userId=${user.id}" class="btn bg-olive btn-xs">详情</a>
												<%--<a href="../pages/user-show.jsp" class="btn bg-olive btn-xs">详情</a>--%>
												<a href="${pageContext.request.contextPath}/rest/user/findByOtherRolesId.do?userId=${user.id}" class="btn bg-olive btn-xs">添加角色</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
							</table>
							<!--数据列表/-->

						</div>
						<!-- 数据表格 /-->

					</div>
					<!-- /.box-body -->

					<!-- .box-footer-->
					<div class="box-footer">
						<div class="pull-left">
							<div class="form-group form-inline">
								总共2 页，共14 条数据。 每页 <select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select> 条
							</div>
						</div>

						<div class="box-tools pull-right">
							<ul class="pagination">
								<li><a href="#" aria-label="Previous">首页</a></li>
								<li><a href="#">上一页</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">下一页</a></li>
								<li><a href="#" aria-label="Next">尾页</a></li>
							</ul>
						</div>

					</div>
					<!-- /.box-footer-->

				</div>

				</section>
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