<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의</title>
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
</body>