<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-26
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/addList" method="post">
    title<br><input type="text" name = "title"> <br>
    dueDate<br><input type="date" name = "dueDate"> <br>
    finished<br><input type="checkbox" name="finished"> <br>
    <button onclick="window.location.href='/todo/list'">글 등록</button>
</form>
</body>
</html>
