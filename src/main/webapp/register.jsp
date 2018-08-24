<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <base href="<%=basePath%>">
    <title>创新学堂</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>

    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/form.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div style="float:right ;">您好！欢迎走进创新学堂&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><h1>创新学堂</h1></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-right">
                <li class="active">
                    <a href="index.jsp">网站首页</a>
                </li>
                <li><a href="CourseServlet?method=searchCourse&secondid=100" class="root">开设课程</a>
                    <ul>
                        <li><a href="CourseServlet?method=searchCourse&secondid=100">JAVA</a></li>
                        <li><a href="CourseServlet?method=searchCourse&secondid=102">WEB前端</a></li>
                        <li><a href="CourseServlet?method=searchCourse&secondid=104">软件测试</a></li>
                        <li><a href="CourseServlet?method=searchCourse&secondid=107">UI设计</a></li>

                    </ul>
                </li>
                <li>
                    <a href="signin.jsp">用户登录</a>
                </li>
                <li>
                    <a href="signup.jsp">用户注册</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- header-section-ends -->
<div class="nullSpace"></div>
<!-- content-section-starts -->
<div class="container">
    <div class="tab-pane fade in active" id="signup" style="width:400px">
        <br>
        <div style="font-size:30px" class="">
            <center><span>用户注册</span></center>
        </div>
        <form action="<s:url action='register'/>" class="register_body" method="post">
            <div class="row">
                <div class="col-xs-7">
                    <div class="form-group has-feedback">
                        <div class="input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input class="form-control" placeholder="请输入名" maxlength="6" type="text" name="user.firstName">
                        </div>
                        <s:if test="fieldErrors.firstName!=null">
                            <span class="label label-danger"><s:property value="fieldErrors['firstName']"/></span>
                        </s:if>
                        <span style="color:red;display: none;" class="tips"></span>
                        <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                </div>
                <div class="col-xs-5 text-center">
                    <input class="form-control" placeholder="请输入姓" maxlength="6" type="text" name="user.lastName">
                </div>
                <s:if test="fieldErrors.lastName!=null">
                    <span class="label label-danger"><s:property value="fieldErrors['lastName']"/></span>
                </s:if>
            </div>

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-envelope"></span>
                    </span>
                    <s:if test="hasFieldErrors() && fieldErrors.mail!=null">
                        <input id="phoneNum" class="form-control" style="border: 1px solid red" placeholder="请输入电子邮件" maxlength="50" type="text"
                               name="mail">
                    </s:if>
                    <s:else>
                        <input id="phoneNum" class="form-control" placeholder="请输入电子邮件" maxlength="50" type="text"
                               name="user.mail">
                    </s:else>
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" class="form-control" placeholder="请输入密码"
                           maxlength="20" type="password" name="user.password">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="passwordConfirm" class="form-control"
                           placeholder="请再次输入密码" maxlength="20"
                           type="password" name="user.passwordTwo">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <br>
            <div class="form-group">
                <input class="form-control btn btn-warning" value="创&nbsp;&nbsp;建&nbsp;&nbsp;账&nbsp;&nbsp;号"
                       type="submit">
            </div>
        </form>

    </div>
</div>
<footer>
    <div class="container">
        <div class="row padT80">
            <div class="col-sm-8 col-xs-12 address">
                <p>
                    为您提供快捷、安全、方便、优质的服务
                </p>
                <div>
                    <img src="images/gw.jpg" title="微信二维码">
                    <ul>
                        <li><span class="glyphicon glyphicon-user"></span>联 系 人：***</li>
                        <li><span class="glyphicon glyphicon-phone-alt"></span>联系电话：17862666888</li>
                        <li><span class="glyphicon glyphicon-envelope"></span>联系邮箱：1508785927@qq.com</li>
                        <li><span class="glyphicon glyphicon-map-marker"></span>公司地址：中山青软基地</li>
                    </ul>
                </div>
            </div>

            <div class="col-xs-12 reserve">
                <p>创新学堂 2018 ©all rights reserved </p>
            </div>
        </div>
    </div>
</footer>
<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/nav.js"></script>

</body>
</html>