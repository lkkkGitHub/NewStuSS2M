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
    <title></title>
</head>
<body>
<p><a href="<s:url action="findAllFirstCtxSecond"/>">一级课程</a></p>
<p><a href="<s:url action="findAll"/>">二级课程</a></p>
<p><a href="">添加课程</a></p>
</body>
</html>