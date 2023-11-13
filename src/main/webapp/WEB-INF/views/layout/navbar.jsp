<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>navbar</title>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" href="/resources/css/layout/navbar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
<div class="wrapper">
    <nav>
        <input type="checkbox" id="show-search">
        <input type="checkbox" id="show-menu">
        <label for="show-menu" class="menu-icon"><i class="fas fa-bars"></i></label>
        <div class="content">
            <div class="logo"><a href="/">webFramework</a></div>
            <ul class="links">
                <li><a href="/">메인으로</a></li>
                <li>
                    <a href="/lectures" class="desktop-link">강의</a>
                    <input type="checkbox" id="show-courses">
                    <label for="show-courses">강의</label>
                    <ul>
                        <c:forEach items="${hierarchyMap.keySet()}" var="courseName" varStatus="courseStatus">
                            <li>
                                <a href="/lectures/${courseName}" class="desktop-link">${courseName}</a>
                                <input type="checkbox" id="show-categories-${courseStatus.count}">
                                <label for="show-categories-${courseStatus.count}">${courseName}</label>
                                <ul>
                                    <c:forEach items="${hierarchyMap.get(courseName).keySet()}" var="categoryName" varStatus="categoryStatus">
                                        <li>
                                            <a href="/lectures/${courseName}/${categoryName}" class="desktop-link">${categoryName}</a>
                                            <input type="checkbox" id="show-skills-${categoryStatus.count}">
                                            <label for="show-skills-${categoryStatus.count}">${categoryName}</label>
                                            <ul>
                                                <c:forEach items="${hierarchyMap.get(courseName).get(categoryName)}" var="skillName">
                                                    <li><a href="/lectures/${courseName}/${categoryName}?skill=${skillName}">${skillName}</a></li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            <c:if test="${loginVO.userAuthority == 'admin'}">
                <li>
                    <a href="/admin" class="desktop-link">관리자탭</a>
                    <input type="checkbox" id="show-adminTab">
                    <label for="show-adminTab">관리자탭</label>
                    <ul>
                        <li>
                            <a href="/admin/createHierarchy">분류계층생성</a>
                        </li>
                    </ul>
                </li>
            </c:if>
                <c:if test="${empty loginVO}">
                    <li>
                        <a href="#" class="desktop-link">접속하기</a>
                        <input type="checkbox" id="show-login">
                        <label for="show-login">접속하기</label>
                        <ul>
                            <li><a href="/user/login">로그인</a></li>
                            <li><a href="/user/signup">회원가입</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${not empty loginVO}">
                    <li>
                        <a href="#" class="desktop-link">
                            <c:if test="${loginVO.userAuthority == 'member' }">
                                ${loginVO.userName } 회원
                            </c:if>
                            <c:if test="${loginVO.userAuthority == 'teacher' }">
                                ${loginVO.userName } 강사
                            </c:if>
                            <c:if test="${loginVO.userAuthority == 'admin' }">
                                ${loginVO.userName } 관리자
                            </c:if>
                        </a>
                        <input type="checkbox" id="show-user">
                        <label for="show-user">
                            <c:if test="${loginVO.userAuthority == 'member' }">
                                ${loginVO.userName } 회원
                            </c:if>
                            <c:if test="${loginVO.userAuthority == 'teacher' }">
                                ${loginVO.userName } 강사
                            </c:if>
                            <c:if test="${loginVO.userAuthority == 'admin' }">
                                ${loginVO.userName } 관리자
                            </c:if>
                        </label>
                        <ul>
                            <li><a href="/user/logout">로그아웃</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
        <label for="show-search" class="search-icon"><i class="fas fa-search"></i></label>
        <form action="#" class="search-box">
            <input type="text" placeholder="Type Something to Search..." required>
            <button type="submit" class="go-icon"><i class="fas fa-long-arrow-alt-right"></i></button>
        </form>
    </nav>
</div>

<%--<div class="dummy-text">--%>
<%--    <h2>Responsive Dropdown Menu Bar with Searchbox</h2>--%>
<%--    <h2>using only HTML & CSS - Flexbox</h2>--%>
<%--</div>--%>

</body>
</html>