<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2023-09-26
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>회원가입 승인 대기 명단</h1>
<ul>
  <c:forEach items="${dtoList}" var="dto">
    <li>
      <input type="checkbox">
      <span>${dto.mid}</span>
      <span>${dto.mpw}</span>
      <span>${dto.mname}</span>
      <span>${dto.age}</span>
      <span>${dto.email}</span>
      <br>
    </li>
  </c:forEach>
  <button onclick="window.location.href='/todo/list'">뒤로</button>

</ul>
</body>
</html>
