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
</head>
<body>
<form action="<s:url action="register"/> " method="post">
    <p>姓：<input type="text" name="user.firstName"></p>
    <p>名：<input type="text" name="user.lastName"></p>
    <p>邮箱：<input type="text" name="user.mail"></p>
    <p>密码：<input type="password" name="user.password"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>