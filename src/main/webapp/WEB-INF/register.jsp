<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
회원가입에 필요한 정보를 입력받겠습니다.<br>
아이디<br><input type="text" name = "mid"> <br>
비밀번호<br><input type="text" name = "mpw"> <br>
이름<br><input type="text" name = "mname"> <br>
나이<br><input type="number" name="age"> <br>
이메일주소<br><input type="text" name = "Email"> <br>
<button type="submit">회원가입</button>
</form>
</body>
</html>
