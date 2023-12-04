<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의 조회</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/lecture/main.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container">
            <div class="lecture-img">
                강의번호: ${lectureVO.lectureNo}
            </div>
            <div class="lecture-data">
                <div class="lecture-title">강의제목: ${lectureVO.lectureName}</div>
                <div class="lecture-sub">
                    <div class="lecture-teacher">강사명: ${teacherVO.userName}(${lectureVO.lectureTeacherNo})</div>
                    <div class="lecture-count">수강생: ${lectureVO.lectureStudentCount}명</div>
                </div>
                <div class="lecture-content">
                    강의설명: ${lectureVO.getLectureContentRepl()}
                </div>
            </div>
            <div class="lecture-btn">
                <input type="button" class="btn btn-outline-secondary btn-enroll" value="강의신청">
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            let formObj = $('form[role="form"]');

            $(".btn-enroll").on('click', function() {
                if (!confirm('강의를 신청하시겠습니까?')) return;

                formObj.attr('action', '/lecture/enrollLecture');

                <%--let hidden = document.createElement('input');--%>
                <%--hidden.setAttribute('type', 'hidden');--%>
                <%--hidden.setAttribute('name', 'lectureNo');--%>
                <%--hidden.setAttribute('value', ${lectureVO.lectureNo});--%>

                <%--formObj.append(hidden);--%>
                formObj.submit();
            });
        });

        if ('${errorCode}' == '1') {
            alert("에러코드 1번");
        }
    </script>
</body>
</html>