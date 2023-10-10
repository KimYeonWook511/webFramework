<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hello</h2>
    <a href="/user/login">로그인</a>
    <a href="/user/signup">회원가입</a>
    <a href="/user/logout">로그아웃</a>
    <br><br>
    ---------------------------------------------------------------
    <br><br>
    userNo : ${loginVO.userNo}<br>
    userId : ${loginVO.userId}<br>
    userName : ${loginVO.userName}<br>
</body>
</html>
