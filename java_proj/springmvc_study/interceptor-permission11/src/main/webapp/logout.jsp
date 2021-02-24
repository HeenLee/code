<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    登出系统，从session删除数据
    <%
        session.removeAttribute("name");
    %>
</body>
</html>
