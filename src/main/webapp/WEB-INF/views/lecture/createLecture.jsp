<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의 등록</title>
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
    <form method="post" action="/lecture/createLecture">
        <%--forEach써서 course, category, skill 보여주고 선택하게(지금은 임시)--%>
        <label><input type="checkbox" name="courses" value="1">IT</label>
        <label><input type="checkbox" name="courses" value="2">수학</label>
        <label><input type="checkbox" name="courses" value="3">과학</label>
        <label><input type="checkbox" name="courses" value="4">영어</label>
        <label><input type="checkbox" name="courses" value="5">국어</label>
        <br>
        <%--course에 따른 카테고리만 보이도록--%>
        <label><input type="checkbox" name="categories" value="1">프론트엔드</label>
        <label><input type="checkbox" name="categories" value="2">백엔드</label>
        <label><input type="checkbox" name="categories" value="3">알고리즘</label>
        <label><input type="checkbox" name="categories" value="4">데이터베이스</label>
        <label><input type="checkbox" name="categories" value="5">데브옵스&인프라</label>
        <br>
        <%--category에 따른 기술만 보이도록--%>
        <label><input type="checkbox" name="skills" value="1">Java</label>
        <label><input type="checkbox" name="skills" value="2">Python</label>
        <label><input type="checkbox" name="skills" value="3">HTML/CSS</label>
        <label><input type="checkbox" name="skills" value="4">Node.js</label>
        <label><input type="checkbox" name="skills" value="5">Vue.js</label>
        <input type="submit" class="btn btn-outline-secondary form-control" value="등록하기">

    </form>
</body>