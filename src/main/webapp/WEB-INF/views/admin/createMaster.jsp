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
    <link rel="stylesheet" href="/resources/css/admin/createMaster.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container">
            <form method="post" action="/admin/createMaster" class="master">
                <div class="master-title">
                    <c:if test="${master.equals('course')}">
                        대분류생성
                    </c:if>
                    <c:if test="${master.equals('category')}">
                        중분류생성
                    </c:if>
                    <c:if test="${master.equals('skill')}">
                        소분류생성
                    </c:if>
                </div>
                <div class="master-data">
                    <c:if test="${courseList != null}">
                        <c:forEach items="${courseList}" var="courseVO">
                            <label class="btn btn-outline-secondary master-items">${courseVO.courseName}</label>
                        </c:forEach>
                    </c:if>
                    <c:if test="${categoryList != null}">
                        <c:forEach items="${categoryList}" var="categoryVO">
                            <label class="btn btn-outline-secondary master-items">${categoryVO.categoryName}</label>
                        </c:forEach>
                    </c:if>
                    <c:if test="${skillList != null}">
                        <c:forEach items="${skillList}" var="skillVO">
                            <label class="btn btn-outline-secondary master-items">${skillVO.skillName}</label>
                        </c:forEach>
                    </c:if>
                </div>
                <div class="master-submit">
                    <input type="text" class="form-control master-input"
                           name="${master}Name" maxlength="30" id="${master}Name"
                           placeholder="${master.equals('course') ? '대분류 이름을 입력해 주세요.' : master.equals('category') ? '중분류 이름을 입력해 주세요.' : '소분류 이름을 입력해 주세요.'}">
                    <input type="submit" class="btn btn-outline-secondary form-control" value="+">
                </div>
            </form>
        </div>
    </div>
    <script>
        $('input[type="text"]').keydown(function() {
            if (event.keyCode === 13) {
                event.preventDefault();
            }
        });

        if ('${errorCode}' == '1') {
            alert("실패: 올바르지 않은 처리입니다.");

        } else if ('${errorCode}' == '2') {
            alert("실패: 입력한 값이 중복됩니다.${msg}");

        } else if ('${errorCode}' == '0') {
            alert("성공: 정상적으로 추가되었습니다.${msg}");
        }
    </script>
</body>
</html>