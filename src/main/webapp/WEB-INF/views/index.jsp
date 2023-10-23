<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
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
