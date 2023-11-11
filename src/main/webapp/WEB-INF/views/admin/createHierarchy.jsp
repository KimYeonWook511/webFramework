<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>분류 추가</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/admin/createHierarchy.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container">
            <form method="post" action="/admin/createHierarchy" class="hierarchy">
                <div class="hierarchy-courses">
                    <div class="course-title">대분류</div>
                    <div class="course-data">
                    <c:forEach items="${courseList}" var="courseVO">
                        <input class="btn-check" type="radio" autocomplete="off" name="courseNo" value="${courseVO.courseNo}" id="${courseVO.courseName}">
                        <label class="btn btn-outline-secondary" for="${courseVO.courseName}">${courseVO.courseName}</label>
                    </c:forEach>
                    </div>
                </div>
                <div class="hierarchy-categories">
                    <div class="category-title">중분류</div>
                    <div class="category-data">
                    <c:forEach items="${categoryList}" var="categoryVO">
                        <input class="btn-check" type="radio" autocomplete="off" name="categoryNo" value="${categoryVO.categoryNo}" id="${categoryVO.categoryName}">
                        <label class="btn btn-outline-secondary" for="${categoryVO.categoryName}">${categoryVO.categoryName}</label>
                    </c:forEach>
                    </div>
                </div>
                <div class="hierarchy-skills">
                    <div class="skill-title">소분류</div>
                    <div class="skill-data">
                    <c:forEach items="${skillList}" var="skillVO" varStatus="skillStatus">
                        <input class="btn-check" type="radio" autocomplete="off" name="skillNo" value="${skillVO.skillNo}" id="${skillVO.skillName}">
                        <label class="btn btn-outline-secondary" for="${skillVO.skillName}">${skillVO.skillName}</label>
                    </c:forEach>
                    </div>
                </div>
                <input type="submit" class="btn btn-outline-secondary form-control hierarchy-btn" value="추가하기">
            </form>
<%--            <div class="hierarchyTemp">--%>
<%--            </div>--%>
        </div>
    </div>
    <script>
        document.addEventListener('keydown', function(event) {
            if (event.keyCode === 13) {
                event.preventDefault();
            }
        }, true);

        if ('${errorCode}' == '1') {
            alert("실패: 대분류 값이 잘못되었습니다.");

        } else if ('${errorCode}' == '2') {
            alert("실패: 중분류 값이 잘못되었습니다.");

        } else if ('${errorCode}' == '3') {
            alert("실패: 소분류 값이 잘못되었습니다.");

        } else if ('${errorCode}' == '4') {
            alert("실패: 이미 존재하는 분류 계층입니다.");

        } else if ('${errorCode}' == '0') {
            alert("성공: 분류 계층을 추가하였습니다.");
        }

        document.addEventListener('DOMContentLoaded', function() {
            if ('${courseNo}' != '') document.querySelector('input[name="courseNo"][value="${courseNo}"]').checked = true;
            if ('${categoryNo}' != '') document.querySelector('input[name="categoryNo"][value="${categoryNo}"]').checked = true;
            if ('${skillNo}' != '') document.querySelector('input[name="skillNo"][value="${skillNo}"]').checked = true;
        });
    </script>
</body>
</html>