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
    <p>当出来方法返回ModelAndView实现forward</p>
    <form action="doForward.do" method="post">
        姓名：<input type="text" name="name" />
        年龄：<input type="text" name="age" />
        <input type="submit" value="提交请求" />
    </form>

    <br/>
    <br/>
    <p>当出来方法返回ModelAndView实现redirect</p>
    <form action="doRedirect.do" method="post">
        姓名：<input type="text" name="name" />
        年龄：<input type="text" name="age" />
        <input type="submit" value="提交请求" />
    </form>


</body>
</html>
