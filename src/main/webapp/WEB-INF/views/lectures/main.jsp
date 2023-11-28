<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/lectures/main.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container-header" id="container-header">
            <div class="header-div"><a class="header-link" href="/lectures">전체 강의</a></div>
            <c:if test="${courseName != null}"><div class="header-div">/ <a class="header-link" href="/lectures/${courseName}">${courseName}</a></div>
            <c:if test="${categoryName != null}"><div class="header-div">/ <a class="header-link" href="/lectures/${courseName}/${categoryName}">${categoryName}</a></div></c:if></c:if>
        </div>
        <div class="container">
            <c:forEach items="${lectureList}" var="lectureVO">
                <a class="lecture" href="/lecture/${lectureVO.lectureName}">
                    <div class="lecture-img">강의번호: ${lectureVO.lectureNo}</div>
                    <div class="lecture-title">강의제목: ${lectureVO.lectureName}</div>
                    <div class="lecture-sub1">강사이름: ${mapTeacher.get(lectureVO.lectureTeacherNo).userName}(${lectureVO.lectureTeacherNo})</div>
                    <div class="lecture-sub2">수강생: ${lectureVO.lectureStudentCount}명</div>
                    <div class="lecture-content">강의설명: ${lectureVO.lectureContent}</div>
                </a>
            </c:forEach>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            // let h = document.getElementById('container-header').lastElementChild.getElementsByTagName('a');
            // h.style.fontSize = '50px';
            // h.style.fontWeight = '700';
            // h.style.color = 'black';
        });
    </script>
</body>
</html>