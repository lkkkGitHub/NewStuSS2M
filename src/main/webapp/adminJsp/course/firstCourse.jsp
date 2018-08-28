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

<%--<s:iterator value="#request['courseFirsts']">--%>
<%--<p>--%>
<%--<s:property value="name"/>--%>
<%--<s:iterator value="secondList">--%>
<%--<s:property value="name"/>--%>
<%--</s:iterator>--%>
<%--</p>--%>
<%--</s:iterator>--%>


<s:iterator value="#request['courseFirsts']">
    <p>
        <a href="">
            <s:property value="name"/>
        </a>
    </p>
    <s:iterator value="secondList">
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="">
                <s:property value="name"/>
            </a>
        </p>
    </s:iterator>
</s:iterator>
</body>
</html>