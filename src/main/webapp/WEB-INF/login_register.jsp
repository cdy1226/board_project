

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/registration" method="post">
  <label for="username">아이디:</label>
  <input type="text" id="username" name="username"><br>

  <label for="password">비밀번호:</label>
  <input type="password" id="password" name="password"><br>

  <label for="name">이름:</label>
  <input type="text" id="name" name="name"><br>

  <label for="age">나이:</label>
  <input type="text" id="age" name="age"><br>

  <label for="email">이메일:</label>
  <input type="text" id="email" name="email"><br>

  <input type="submit" value="가입하기">
</form>
</body>
</html>
