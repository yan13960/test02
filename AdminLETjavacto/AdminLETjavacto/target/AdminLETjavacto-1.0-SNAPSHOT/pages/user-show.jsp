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
    <!-- @@master = admin-layout.jsp-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                用户管理
                <small>用户详情</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/user/findAll.do">用户管理</a></li>
                <li class="active">用户详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">

                <!--树表格-->
                <div class="tab-pane" id="tab-treetable">
                    <table id="collapse-table" class="table table-bordered table-hover dataTable">
                        <thead>
                        <tr>
                            <th>用户</th>
                            <th>描述</th>

                        </tr>
                        </thead>
                        <tr data-tt-id="0">
                            <td colspan="2">${user.username}</td>
                        </tr>
                        <tbody>
                        <c:forEach items="${user.roles}" var="role" varStatus="vs">
                            <tr data-tt-id="${vs.index+1}" data-tt-parent-id="0">
                                <td>${role.roleName}</td>
                                <td>${role.roleDesc}</td>
                            </tr>
                            <c:forEach items="${role.permissions}" var="p">
                                <tr data-tt-id="1-1" data-tt-parent-id="${vs.index+1}">
                                    <td>${p.permissionName}</td>
                                    <td>${p.url}</td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                      </tbody>
                    </table>
                </div>
                <!--树表格/-->

            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
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