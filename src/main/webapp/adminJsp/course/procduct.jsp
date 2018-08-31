<!DOCTYPE HTML>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="zh-CN">
<head>
    <title>创新学堂</title>
    <meta charset="utf-8"/>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>

    <!-- Custom Theme files -->
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet" type="text/css" media="all"/>

</head>

<body>

<nav class="navbar navbar-default">
    <div style="float:right ;">
        <a href="<s:url value='myinfo' />">
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
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><h1>创新学堂</h1></a>
        </div>
        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-right">
                <li class="active"><a href="/index.jsp">网站首页</a></li>
                <li>
                    <a href="<s:url action='cata_course'/> " class="root">课程</a>
                    <ul>
                        <s:iterator value="#request['courseFirsts']">
                            <p>
                                <a href="">
                                    <s:property value="name"/>
                                </a>
                            </p>
                        </s:iterator>

                        <%--&lt;%&ndash;从类别表中取出类别，遍历之，以形成菜单项&ndash;%&gt;--%>
                        <%--<s:iterator value="#session.catagoryList" var="catagory">--%>
                            <%--<li>--%>
                                <%--<a href="<s:url action='cata_course'><s:param name='id' value='#catagory.id' /></s:url>">--%>
                                    <%--<s:property value="#catagory.name"/>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                        <%--</s:iterator>--%>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- header-section-ends -->
<div class="nullSpace"></div>
<!-- content-section-starts -->
<div class="container">
    <div class="ft-ball">
        <div class="rsidebar span_1_of_left">
            <section class="sky-form">
                <%--从类别表中取出类别，遍历之，以形成菜单项--%>
                <s:iterator value="#request['courseFirsts']">
                    <h4><s:property value="#catagory.name"/></h4>
                    <div class="row row1 scroll-pane">
                        <div class="col col-4">
                                <%--迭代一级类别中的所有二级类别，形成二级菜单--%>
                            <s:iterator value="secondList">
                                <%--跟据类别的id，判断出当前选中的类别，以特殊颜色标示出来--%>
                                <s:if test="id == id">
                                    <label class="checkbox" style="background-color: #c0a16b;">
                                        <i></i>
                                        <a href="<s:url action='cata_course'><s:param name='id' value='id' /></s:url>">
                                            <s:property value="name"/>
                                        </a>
                                    </label>
                                </s:if>
                                <s:else>
                                    <label class="checkbox">
                                        <i></i>
                                        <a href="<s:url action='cata_course'><s:param name='id' value='id' /></s:url>">
                                            <s:property value="name"/>
                                        </a>
                                    </label>
                                </s:else>
                            </s:iterator>
                        </div>
                    </div>
                </s:iterator>
            </section>
        </div>

        <div class="cont span_2_of_3">
            <form action="SearchCourseServlet">
                <div class="" id="signin" style="width: 580px">
                    <div style="font-size: 30px;" class="">
                        <center>
                            <span>检索条件</span>
                        </center>
                    </div>
                    <br>


                    <div class="form-group has-feedback">
                        <div class="input-group">
                            <span class="input-group-addon">课程名称</span>
                            <input id="phoneNum"
                                   class="form-control"
                                   placeholder="请输入课程名称" maxlength="11"
                                   type="text" name="courseName">
                        </div>
                        <span style="color: red; display: none;" class="tips"></span>
                        <span style="display: none;"
                              class="glyphicon glyphicon-remove form-control-feedback"></span>
                        <span style="display: none;"
                              class="glyphicon glyphicon-ok form-control-feedback"></span>
                    </div>
                    <br>
                    <div class="form-group" style="width: 80px">
                        <input class="form-control btn btn-warning" value="检索" type="submit">
                    </div>
                </div>
            </form>
            <div class="box1">
                <%--这里开始是各课程的块--%>
                <s:iterator value="courseList" var="cou">
                    <div class="col_1_of_single1 span_1_of_single1">
                        <div class="view1 view-fifth1">
                            <div class="top_box">
                                <h3 class="m_1"><s:property value="#cou.name"/></h3>
                                <p class="m_2"><s:property value="#cou.desc"/></p>
                                <a href="prod/single-pic.html">
                                    <!--   <div class="grid_img"> -->
                                    <div class="css3">
                                        <img src="${pageContext.request.contextPath}/images/course/<s:property value='#cou.imageFileName' />"
                                             onerror="onerror=null;src='${pageContext.request.contextPath}/images/course/default.jpg'"/>
                                    </div>
                                    <div class="mask1">
                                        <div class="info">查看详情</div>
                                    </div>
                                    <!--  </div> -->
                                </a>
                                <div class="price"></div>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </s:iterator>

                <div class="clearfix"></div>
            </div>

            <div style="text-align: center;">
                <%--显示分页相关控件--%>
                <div class="btn-group">
                    <a href="<s:url action='cata_course'><s:param name='secondId' value='secondId'/><s:param name='pageNum' value='1'/></s:url>"
                       type="button" class="btn btn-default">首页</a>
                    <s:if test="pageInfo.isFirstPage">
                        <button type="button" class="btn btn-disable">上一页</button>
                    </s:if>
                    <s:else>
                        <a href="<s:url action='cata_course'><s:param name='secondId' value='secondId'/><s:param name='pageNum' value='pageInfo.pageNum-1'/></s:url>"
                           type="button" class="btn btn-default">上一页</a>
                    </s:else>
                    <%--显示当前的页号--%>
                    <button type="button" class="btn btn-default"><s:property value="pageInfo.pageNum"/></button>
                    <s:if test="pageInfo.isLastPage">
                        <button type="button" class="btn btn-disable">下一页</button>
                    </s:if>
                    <s:else>
                        <a href="<s:url action='cata_course'><s:param name='secondId' value='secondId'/><s:param name='pageNum' value='pageInfo.pageNum+1'/></s:url>"
                           type="button" class="btn btn-default">下一页</a>
                    </s:else>
                    <a href="<s:url action='cata_course'><s:param name='secondId' value='secondId'/><s:param name='pageNum' value='pageInfo.pages'/></s:url>"
                       type="button" class="btn btn-default">末页</a>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<footer>
    <div class="container">
        <div class="row padT80">
            <div class="col-sm-8 col-xs-12 address">
                <p>为您提供快捷、安全、方便、优质的服务</p>
                <div>
                    <img src="${pageContext.request.contextPath}/images/gw.jpg" title="微信二维码">
                    <ul>
                        <li><span class="glyphicon glyphicon-user"></span>联 系 人：***</li>
                        <li><span class="glyphicon glyphicon-phone-alt"></span>联系电话：17862666888</li>
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
<script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"
        charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"
        charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/nav.js"></script>
</body>
</html>