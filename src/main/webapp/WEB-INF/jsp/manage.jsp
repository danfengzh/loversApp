<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/8
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    request.setCharacterEncoding("UTF-8");
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>维护列表</title>
    <link href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.1.1/core.js" type="text/javascript" charset="utf-8">
    </script>
    <script src="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.js" type="text/javascript" charset="utf-8">
    </script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap-grid.css" type="text/css">
</head>
<body>
<hr>
<hr>
<table class="table">
    <caption></caption>
    <thead>
    <tr>
        <th>道具编号</th>
        <th>道具名称</th>
        <th>道具功能</th>
        <th>道具价格</th>
        <th>道具图片</th>
        <th>道具类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr class="active">
            <td>${item.id}</td>
            <td>${item.itemname}</td>
            <td>${item.itemfunction}</td>
            <td>${item.itemprice}</td>
            <td><img src="<%=path%>/${item.itemimage}"></td>
            <td>${item.itemtype}</td>
            <td><a href="<%=path%>/deleteItemByID/${item.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
