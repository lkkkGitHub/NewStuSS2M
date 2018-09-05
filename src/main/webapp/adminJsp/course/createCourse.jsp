<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <title></title>
</head>
<body>
<div class="container">

    <div class="" id="signin" style="width:380px">
        <br>
        <div style="font-size:30px;" class="">
            <center><span>创建课程</span></center>
        </div>
        <br>
        <form action="<s:url namespace="/admin" action='createCourse'/>"
              enctype="multipart/form-data" class="" method="post">

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">课程名称</span>
                    <input id="phoneNum" class="form-control"
                           placeholder="请输入课程名称" maxlength="11" type="text"
                           name="courseName">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">课程描述</span>
                    <input id="phoneNum" class="form-control"
                           placeholder="请输入课程描述" maxlength="11" type="text"
                           name="courseDesc">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">封面图片</span>

                    <input type="text" size="36" name="upfile" placeholder="   请上传图片"
                           id="upfile" class="" style="height:30px;border:1px solid #ccc;background:#fff">
                    <%--浏览查找文件--%>
                    <input type="button" value="浏览" onclick="path.click()"
                           style="height:30px;border:1px solid #ccc;background:#fff">
                    <%--具体文件--%>
                    <input name="imgFile" type="file" id="path" style="display:none"
                           onchange="upfile.value=this.value">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">课程讲师</span>
                    <input id="phoneNum" class="form-control" placeholder="请输入课程讲师"
                           maxlength="11" type="text" name="courseTeacher">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">课程所属</span>
                    <input id="phoneNum" class="form-control" placeholder="请输入课程所属"
                           maxlength="11" type="text" name="courseType">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">&nbsp;二级ID&nbsp;&nbsp;</span>
                    <input id="phoneNum" class="form-control" placeholder="请输入二级课程ID"
                           maxlength="11" type="text" name="secondId">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">课程视频</span>

                    <input type="text" size="36" name="videoes" placeholder="   请上传视频"
                           id="videoes" class="" style="height:30px;border:1px solid #ccc;background:#fff">
                    <%--浏览查找文件--%>
                    <input type="button" value="浏览" onclick="path1.click()"
                           style="height:30px;border:1px solid #ccc;background:#fff">
                    <%--具体文件--%>
                    <input name="videoFile" type="file" id="path1" style="display:none"
                           onchange="videoes.value=this.value">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <br>
            <div class="form-group">
                <input class="form-control btn btn-warning" value="&nbsp;&nbsp;创&nbsp;&nbsp;建&nbsp;&nbsp;"
                       type="submit">
            </div>

        </form>
    </div>

</div>

</body>
</html>