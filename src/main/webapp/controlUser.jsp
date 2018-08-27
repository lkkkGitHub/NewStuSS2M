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
<table>
    <tr><%--id,firstname,lastname,main,privilege,deleteFlag--%>
        <td>id</td>
        <td>名字</td>
        <td>邮箱</td>
        <td>权限</td>
        <td>是否被删除</td>
    </tr>
    <td style="color:red;"> <s:property value="#request.messageUpdate"/> </td>
    <p style="color:red;">${requestScope.messageFind}</p>
    <s:iterator value="#request['users']">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="firstName"/><s:property value="lastName"/></td>
            <td><s:property value="mail"/></td>
            <td><s:property value="privilege"/></td>
            <s:if test="deleteFlag == 1">
                <td>是</td>
            </s:if>
            <s:if test="deleteFlag == 0">
                <td>否</td>
            </s:if>
            <td><s:a href="findUserById?user.id=%{id}">编辑</s:a></td>
            <td><a href="delete.action?user.id=${id}&user.deleteFlag=${deleteFlag}"> 删除 </a></td>
            <%--没有显示--%>1
        </tr>
    </s:iterator>
</table>
</body>
</html>