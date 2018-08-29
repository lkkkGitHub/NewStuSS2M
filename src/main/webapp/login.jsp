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
    <title></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>

    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/form.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>

<div style="float:right ;">
    <a href="<s:url value='myinfo' />">
        <s:property value="#ession['loginUser'].firstName"/>
    </a>
    ,欢迎走进创新学堂&nbsp;&nbsp;&nbsp;&nbsp;
</div>

<div class="container">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#"><h1>德州创新学堂</h1></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-right">
            <li class="active">
                <a href="indexOne.jsp">网站首页</a>
            </li>
            <li><a href="CourseServlet?method=searchCourse&secondId=100" class="root">开设课程</a>
                <ul>
                    <li><a href="CourseServlet?method=searchCourse&secondId=100">JAVA</a></li>
                    <li><a href="CourseServlet?method=searchCourse&secondId=102">WEB前端</a></li>
                    <li><a href="CourseServlet?method=searchCourse&secondId=104">软件测试</a></li>
                    <li><a href="CourseServlet?method=searchCourse&secondId=107">UI设计</a></li>
                </ul>
            </li>
            <li><a href="<s:url action='showLogin' />">用户登录</a></li>
            <li><a href="<s:url action='showRegister' />">用户注册</a></li>
        </ul>
    </div>
</div>
</nav>
<!-- header-section-ends -->
<div class="nullSpace"></div>
<!-- content-section-starts -->
<div class="container">


    <div class="" id="signin" style="width:380px">
        <br>
        <div style="font-size:30px;" class="">
            <center><span>用户登录</span></center>
        </div>
        <br>
        <form action="<s:url action="login" namespace="/" />"  method="post">
            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
                    <input id="phoneNum" class="form-control" placeholder="请输入电子邮件" maxlength="50" type="text"
                           name="user.mail">
                </div>
                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <div class="input-group">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    <input id="password" class="form-control" placeholder="请输入密码" maxlength="20" type="password"
                           name="user.password">
                </div>

                <span style="color:red;display: none;" class="tips"></span>
                <span style="display: none;" class="glyphicon glyphicon-remove form-control-feedback"></span>
                <span style="display: none;" class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>
            <p style="color:red;">${requestScope.messageLogin}</p>
            <br>
            <div class="form-group">
                <input class="form-control btn btn-warning" value="&nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;"
                       type="submit">
            </div>
            <div class="form-group divcss-forgetPw">
                <center><a href="javascript:$('#myModal').modal('hide');" class="forgetpass" data-toggle="modal"
                           data-target="#resetPwModal">忘记密码&nbsp;?</a></center>
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