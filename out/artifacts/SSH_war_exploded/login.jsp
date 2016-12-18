<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>

    <script>
    </script>
</head>

<body>


    <form action="<%=path%>/admin/checking" method="post">
        <input type="text" name="sAdmin.email"/> <br/>
        <input type="test" name="sAdmin.password"/> <br/>
        <input type="submit" value="登录"/>
    </form>

</body>

</html>