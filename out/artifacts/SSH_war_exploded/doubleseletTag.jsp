<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>省份--城市级联菜单</title>
    <s:head />
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
   <link rel="stylesheet" type="text/css" href="styles.css">
   -->
</head>
<body>
<s:form action="doubleselectTag">
    <s:doubleselect label="请选择所在省市" name="provice" list="provices"
                    listKey="id" listValue="name" doubleList="cities" doubleListKey="id"
                    doubleListValue="name" doubleName="city" headerKey="-1"
                    headerValue="----请选择----" emptyOption="true" />
</s:form>
</body>
</html>
