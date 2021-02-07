<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>处理器方法返回String表示视图名称</p>

    <form action="returnString-view.do" method="post">
        姓名：<input type="text" name="name"/>
        年龄：<input type="text" name="age" />
        <input type="submit" value="提交参数"/>
    </form>

    <br/>

    <p>处理器方法返回String表示视图完整路径</p>
    <form action="returnString-view2.do" method="post">
        姓名：<input type="text" name="name"/>
        年龄：<input type="text" name="age" />
        <input type="submit" value="提交参数"/>
    </form>

</body>
</html>
