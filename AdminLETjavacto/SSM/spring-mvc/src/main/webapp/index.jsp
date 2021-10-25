<%--
  Created by IntelliJ IDEA.
  User: yan
  Date: 2021/9/30
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>xinzhi</title>
    <base href="<%=basePath%>">
</head>
<body>
hello spring mvc
<form action="user12/upload"method="post" enctype="multipart/form-data">
    <input name="username">
    <input name="password" type="password">
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/2.2.2/jquery.js"></script>

<script>
    $.ajax( {
        type : "GET",
        url : "user10/1",
        dataType : "json",
        success : function(data) {
            console.log("get请求！---------------------")
            console.log(data)
        }
    });

    $.ajax( {
        type : "DELETE",
        url : "/user10/1",
        dataType : "json",
        success : function(data) {
            console.log("delete请求！---------------------")
            console.log(data)
        }
    });

    $.ajax( {
        type : "put",
        url : "user10/1",
        dataType : "json",
        data: {id:12,username:"楠哥",password:"123"},
        success : function(data) {
            console.log("get请求！---------------------")
            console.log(data)
        }
    });

    $.ajax( {
        type : "post",
        url : "user10/1",
        dataType : "json",
        data: {id:12,username:"楠哥",password:"123"},
        success : function(data) {
            console.log("get请求！---------------------")
            console.log(data)
        }
    });
</script>
</body>
</html>
