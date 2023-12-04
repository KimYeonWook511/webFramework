<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>관리자 탭</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/resources/css/admin/main.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container">
            <div class="tab">
                <div class="tab-title">관리자 탭</div>
                <div class="tab-data">
                    <a href="/admin/createHierarchy" class="btn btn-outline-secondary tab-createHierarchy">분류계층생성</a>
                    <div class="tab-createMaster">
                        <a href="/admin/createMaster?master=course" class="btn btn-outline-secondary tab-createCourse">대분류생성</a>
                        <a href="/admin/createMaster?master=category" class="btn btn-outline-secondary tab-createCategory">중분류생성</a>
                        <a href="/admin/createMaster?master=skill" class="btn btn-outline-secondary tab-createSkill">소분류생성</a>
                    </div>
                    <a href="/admin/createLecture" class="btn btn-outline-secondary tab-createLecture">강의등록</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>