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
        <s:iterator value="courseList">
            <a href="">
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <s:property value="courseName"/>
                    <s:property value="courseDesc"/>
                    <img src="${pageContext.request.contextPath}/images/course/<s:property value='id'/>.<s:property value='courseImg'/>"
                         onerror="onerror=null;
                                 src='${pageContext.request.contextPath}/images/course/defalut.png'" height="20%"
                         width="20%"/>
                    <s:property value="courseTeacher"/>
                    <s:property value="courseType"/>
                    <a href="<s:url action="playVideoInfo">
                            <s:param name="course.videoId" value="videoId"/>
                            </s:url> ">视频教程
                    </a>
                </p>
            </a>
        </s:iterator>
    </s:iterator>
</s:iterator>
</body>
</html>