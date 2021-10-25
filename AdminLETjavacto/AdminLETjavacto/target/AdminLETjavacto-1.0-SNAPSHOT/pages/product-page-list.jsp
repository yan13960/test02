<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="comm.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <script>
        function checkIds() {
            var ids = document.getElementsByName("ids");
            for(var i in ids){
                var input = ids[i];
                if(input.checked){
                    input.checked=false;
                }else{
                    input.checked=true;
                }
            }
        }

        function deletes() {
            var ids = document.getElementsByName("ids");
            var  strs=new Array(0);

            for(var i in ids){
                var input = ids[i];
                if(input.checked){
                    input.checked=false;
                    strs[i]=ids[i].value;
                }
            }
            ids=strs.join(",");
            if(strs.length==0){
                alert("请选择数据");
                return false;
            }

            window.location.href="${pageContext.request.contextPath}/rest/product/deleteIds?ids="+ids;

        }
        function changePageSize() {
            //获取下拉框的值
            var pageSize = $("#changePageSize").val();
                alert(pageSize);
            //向服务器发送请求，改变没页显示条数
            location.href = "${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=1&pageSize="
                + pageSize;
        }
    </script>
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
                数据管理 <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
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
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='${pageContext.request.contextPath}/pages/product-add.jsp'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"
                                            onclick="deletes();"
                                    >
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启">
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽">
                                        <i class="fa fa-ban"></i> 屏蔽
                                    </button>
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
                                <th class="" style="padding-right: 0px;"><input
                                        id="selall" type="checkbox" class="icheckbox_square-blue" value="选择"
                                        onclick="checkIds();"
                                >
                                </th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">编号</th>
                                <th class="sorting_asc sorting_asc_disabled">产品名称</th>
                                <th class="sorting_desc sorting_desc_disabled">出发城市</th>
                                <th class="sorting">出发时间</th>
                                <th class="text-center sorting">产品价格</th>
                                <th class="sorting">产品描述</th>
                                <th class="text-center sorting">状态</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>
                            <tbody>


                            <c:forEach items="${productList}" var="product">

                                <tr>
                                    <td><input name="ids" type="checkbox" value="${product.id}"></td>
                                    <td>${product.id }</td>
                                    <td>${product.productNum }</td>
                                    <td>${product.productName }</td>
                                    <td>${product.cityName }</td>
                                    <td>
                                        <fmt:formatDate value="${product.departureTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                                    </td>
                                    <td class="text-center">${product.productPrice }</td>
                                    <td>${product.productDesc }</td>
                                    <td class="text-center">${product.productStatusStr }</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs">订单</button>
                                        <button type="button" class="btn bg-olive btn-xs">详情</button>
                                        <button type="button" class="btn bg-olive btn-xs"
                                                onclick="location.href='${pageContext.request.contextPath}/rest/product/findById/${product.id }'">编辑</button>
                                        <button type="button" class="btn bg-olive btn-xs"
                                                onclick="location.href='${pageContext.request.contextPath}/rest/product/productDelete/${product.id }'">删除</button>
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

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除">
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启">
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽">
                                        <i class="fa fa-ban"></i> 屏蔽
                                    </button>
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

                    </div>
                    <!-- 数据表格 /-->


                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${info.pages} 页，共${info.total} 条数据。 每页


                            <select class="form-control"  id="changePageSize" onchange="changePageSize()">

                            <option value="1"  <c:if test='${pageSize==1}'>selected</c:if>>1</option>
                            <option value="2"  <c:if test='${pageSize==2}'>selected</c:if>>2</option>
                            <option value="3"  <c:if test='${pageSize==3}'>selected</c:if>>3</option>
                            <option value="4"  <c:if test='${pageSize==4}'>selected</c:if>>4</option>
                            <option value="5"  <c:if test='${pageSize==5}'>selected</c:if>>5</option>
                        </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li><a href="${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=1&pageSize=${pageSize}" aria-label="Previous">首页</a></li>
                            <li><a href="${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=${info.pageNum-1}&pageSize=${pageSize}">上一页</a></li>

                            <c:forEach begin="1" end="${info.pages}" var="pageNum">

                                <li><a href="${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=${pageNum}&pageSize=${pageSize}">${pageNum}</a></li>
                            </c:forEach>

                            <li><a href="${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=${info.pageNum+1}&pageSize=${pageSize}">下一页</a></li>
                            <li><a href="${pageContext.request.contextPath}/rest/product/productPageList.do?pageNum=${info.pages}&pageSize=${pageSize} " aria-label="Next">尾页</a></li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->



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