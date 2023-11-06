<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <h2>/lecture/main.jsp</h2><br>
        <h4>@PathVariable 테스트</h4>
        <br>
        ---------------------------------------------------------
        <c:forEach items="${lectureList}" var="lectureVO">
            lectureNo: ${lectureVO.lectureNo}<br>
            lectureTeacherNo: ${lectureVO.lectureTeacherNo}<br>
            lectureName: ${lectureVO.lectureName}<br>
            lectureContent: ${lectureVO.lectureContent}<br>
            lectureOpenDate: ${lectureVO.lectureOpenDate}<br>
            lectureStudentCount: ${lectureVO.lectureStudentCount}<br>
        </c:forEach>
    </div>
</body>