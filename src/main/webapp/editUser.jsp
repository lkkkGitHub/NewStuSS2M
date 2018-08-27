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
<form action="<s:url action="editUser?user.id=%{user.id}"/>" method="post">
    <%--<p><input type="text" name="user.id" value="${requestScope.user.id}"></p>--%>
    <p>firstName：<input type="text" name="user.firstName" value="${requestScope.user.firstName}"></p>
    <p>lastName：<input type="text" name="user.lastName" value="${requestScope.user.lastName}"></p>
    <p>mail：<input type="text" name="user.mail" value="${requestScope.user.mail}"></p>
    <p>privilege<input type="text" name="user.privilege" value="${requestScope.user.privilege}"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>