<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${param.result=='error'}">
        <h1>로그인에러</h1>
    </c:if>

    <form action="/login" method="post">
        아이디<br><input type="text" name = "mid"><br>
        비밀번호<br><input type="text" name = "mpw"><br>
        <br>자동로그인 <input type="checkbox" name="auto">
        <button type="submit">LOGIN</button>

    </form>

    <button onclick="window.location.href='/registration'">회원가입</button>
</body>
</html>
