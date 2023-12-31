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
    <link rel="stylesheet" href="/resources/css/lecture/info.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container">
            <div class="lecture-img">
                강의번호: ${lectureVO.lectureNo}
            </div>
            <div class="lecture-data">
                <div class="lecture-name">
                    <div class="name-title">강의제목: </div>
                    <div class="name-data">${lectureVO.lectureName}</div>
                </div>
                <div class="lecture-sub">
                    <div class="lecture-teacher">강사명: ${teacherVO.userName}</div>
                    <div class="lecture-count">수강생: ${lectureVO.lectureStudentCount}명</div>
                </div>
                <div class="lecture-content">
                    <div class="content-title">강의설명: </div>
                    <div class="content-data">${lectureVO.getLectureContentRepl()}</div>
                </div>
            </div>
            <div class="lecture-btn">
                <c:if test="${userLecture}">
                    <label class="btn btn-outline-secondary btn-ing">수강중</label>
                </c:if>
                <c:if test="${!userLecture}">
                    <input type="button" class="btn btn-outline-secondary btn-enroll" value="강의신청">
                </c:if>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function() {
            $(".btn-enroll").on('click', function() {
                if (!confirm('강의를 신청하시겠습니까?')) return;

                let form = document.createElement('form');
                form.setAttribute('charset', 'UTF-8');
                form.setAttribute('method', 'post');
                form.setAttribute('action', '/lecture/enrollLecture');

                let hidden1 = document.createElement('input');
                hidden1.setAttribute('type', 'hidden');
                hidden1.setAttribute('name', 'lectureNo');
                hidden1.setAttribute('value', ${lectureVO.lectureNo});

                let hidden2 = document.createElement('input');
                hidden2.setAttribute('type', 'hidden');
                hidden2.setAttribute('name', 'lectureName');
                hidden2.setAttribute('value', '${lectureVO.lectureName}');

                form.appendChild(hidden1);
                form.appendChild(hidden2);

                document.body.appendChild(form);

                form.submit();
            });
        });
    </script>
</body>
</html>