<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/" ;
%>

<html>
<head>
    <title>Title</title>

</head>
<body>
    <p>处理异常的，全局异常处理</p>
    <form action="some.do" method="post">
        姓名：<input type="text" name="name" />
        年龄：<input type="text" name="age" />
        <input type="submit" value="提交请求" />
    </form>

</body>
</html>
