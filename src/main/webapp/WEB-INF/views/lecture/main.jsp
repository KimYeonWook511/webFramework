<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의 조회</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/css/lecture/view.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <h2>/lecture/view.jsp</h2><br>
        <br>
        ---------------------------------------------------------
        <div class="container">
            <div class="lecture-img">강의번호: ${lectureVO.lectureNo}</div>
            <div class="lecture-title">강의제목: ${lectureVO.lectureName}</div>
            <div class="lecture-sub1">강사번호: ${lectureVO.lectureTeacherNo}</div>
            <div class="lecture-sub2">수강생: ${lectureVO.lectureStudentCount}명</div>
            <div class="lecture-content">강의설명: ${lectureVO.lectureContent}</div>
        </div>
    </div>
</body>
</html>