<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>

    <base href="<%=basePath%>">
    <title></title>
</head>
<body>

<%--<a href="<s:url action="adminInterceptor" namespace="/admin"/> ">创建</a>--%>

<%--顶部导航栏--%>
<nav class="navbar navbar-default">
    <div style="float:right ;">
        <s:if test="#session.loginUser.privilege == 0">
            <%--<a href=" <s:url action="findAllUser"/> ">管理员</a>--%>
            <a href="adminJsp/adminIndex.jsp">管理员</a>
        </s:if>
        <a href="">
            <s:property value="#session.loginUser.firstName"/>
            <s:property value="#session.loginUser.lastName"/>
        </a>
        ,欢迎走进创新学堂&nbsp;&nbsp;&nbsp;&nbsp;
    </div>

    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                    data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='indexOne.jsp'></a><h1>创新学堂</h1></a>
        </div>
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-right">
                <li class="active"><a href="indexOne.jsp">网站首页</a></li>
                <li><a href="CourseServlet?method=searchCourse&secondId=100" class="root">课程</a>
                    <ul>
                        <s:iterator value="#request['courseFirsts']">
                            <li>
                                <a href="CourseServlet?method=searchCourse&secondId=100">
                                    <s:property value="name"/>
                                </a>
                            </li>
                        </s:iterator>
                    </ul>
                </li>
                <li><a href="<s:url action='showLogin' />">用户登录</a></li>
                <li><a href="<s:url action='showRegister' />">用户注册</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="nullSpace"></div>
<!--banner-->
<div class="banner">
    <div id="carousel-example-generic" class="carousel slide"
         data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0"
                class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="images/banner/ban4.jpg">
            </div>
            <div class="item">
                <img src="images/banner/ban1.jpg">
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic"
           role="button" data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic"
           role="button" data-slide="next"> <span
                class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<!--roate-->
<div class="roate padT80 padD80 bgGrey">
    <div class="roList container bgWhite">
        <section class="title ">
            <h2>精品课程</h2>
        </section>
        <ul class=" padT80">
            <li class="col-sm-3 col-xs-6"><a href="products2.html"><img
                    src="images/hibernate.JPG"/></a></li>
            <li class="col-sm-3 col-xs-6"><a href="products.html"><img
                    src="images/spring.JPG"/></a></li>
            <li class="col-sm-3 col-xs-6"><a href="products.html"><img
                    src="images/struts2.JPG"/></a></li>
            <li class="col-sm-3 col-xs-6"><a href="products.html"><img
                    src="images/fileUpload.JPG"/></a></li>
        </ul>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row padT80">
            <div class="col-sm-8 col-xs-12 address">
                <p>为您提供快捷、安全、方便、优质的服务</p>
                <div>
                    <img src="images/gw.jpg" title="微信二维码">
                    <ul>
                        <li><span class="glyphicon glyphicon-user"></span>联 系 人：***</li>
                        <li><span class="glyphicon glyphicon-phone-alt"></span>联系电话：17862666888
                        </li>
                        <li><span class="glyphicon glyphicon-envelope"></span>联系邮箱：1508785927@qq.com</li>
                        <li><span class="glyphicon glyphicon-map-marker"></span>公司地址：中山青软基地</li>
                    </ul>
                </div>
            </div>

            <div class="col-xs-12 reserve">
                <p>创新学堂 2018 ©all rights reserved</p>
            </div>
        </div>
    </div>
</footer>
<script src="js/jquery.min.js" type="text/javascript"
        charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript"
        charset="utf-8"></script>
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/nav.js"></script>

</body>
</html>