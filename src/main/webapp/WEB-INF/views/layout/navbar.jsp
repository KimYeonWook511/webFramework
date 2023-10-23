<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>navbar</title>
    <style>
        .navbar-brand {
            background-image: url("/resources/mainImg/logo.png");
            background-size: cover;
            background-position: center;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/" style="width: 150px;"></a>
        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" style="margin-left: 10px;">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">메인으로</a>
                </li>
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" role="button">
                        스터디
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/study/list">스터디 리스트</a></li>
                        <c:if test="${not empty loginVO}">
                        </c:if>
                    </ul>
                </li>
            </ul>
            <c:if test="${empty loginVO}">
                <ul class="navbar-nav navbar-right">
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false" style="font-weight: bold; font-size: 15px; padding-left: 20px; padding-right: 20px;">
                            접속하기
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/user/login">로그인</a></li>
                            <li><a class="dropdown-item" href="/user/signup">회원가입</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
            <c:if test="${not empty loginVO}">
                <ul class="navbar-nav navbar-right">
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false" style="font-weight: bold; font-size: 15px; padding-left: 20px; padding-right: 20px;">
                            <c:if test="${loginVO.userAuthority == 'member' }">
                                ${loginVO.userName } 회원
                            </c:if>
                            <c:if test="${loginVO.userAuthority == 'instructor' }">
                                ${loginVO.userName } 강사
                            </c:if>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/user/logout">로그아웃</a></li>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</nav>
</body>
</html>