<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/8
  Time: 20:54
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
    <title>添加道具信息</title>
    <link href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/3.1.1/core.js" type="text/javascript" charset="utf-8">
    </script>
    <script src="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.js" type="text/javascript" charset="utf-8">
    </script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap-grid.css" type="text/css">
</head>
<body>
<div style="    padding: 50px;">
    <form class="form-horizontal" method="post" enctype="multipart/form-data" action="<%=path%>/item/insertItem">
        <fieldset>
            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">道具名称</label>
                <div class="controls">
                    <input type="text"  name="itemName" placeholder="道具名称" class="input-xlarge">
                    <p class="help-block"></p>
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">道具功能</label>
                <div class="controls">
                    <input type="text" name="itemFunction" placeholder="道具功能" class="input-xlarge">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">道具价格</label>
                <div class="controls">
                    <input type="text" name="price" placeholder="道具价格" class="input-xlarge">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">道具图片</label>

                <!-- File Upload -->
                <div class="controls">
                    <input class="input-file" id="fileInput" type="file" name="itemImage">
                </div>
            </div>


            <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">道具类型</label>
                <div class="controls">
                    <input type="text" placeholder="道具类型" class="input-xlarge" name="itemType">
                    <p class="help-block"></p>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">确认提交</label>

                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">提交</button>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">取消</label>

                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">取消</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
