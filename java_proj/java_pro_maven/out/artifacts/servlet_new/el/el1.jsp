<%--
  Created by IntelliJ IDEA.
  User: lihe
  Date: 2020/12/28
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
    <%
        session.setAttribute("name","李四");
        request.setAttribute("name","张三");
        request.setAttribute("age",23);

    %>

<h3>el获取值</h3>
${requestScope.name}
${requestScope.age}

${name}

</body>
</html>
