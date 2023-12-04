<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
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
    <div class="main">
        <div class="container-fluid text-center">
            <div class="row align-items-center">
                <div class="col-4"></div>
                <div class="col-4">
                    <div style="padding-top: 20px;">
                        <form method="post">
                            <h3 style="text-align: center;">회원가입</h3>
                            <br>
                            <br>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="아이디"
                                       name="userId" maxlength="20" id="userId" pattern="^[a-zA-Z0-9]+$">
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="비밀번호"
                                       name="userPassword" maxlength="20" id="userPassword">
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="비밀번호 확인"
                                       name="confirmUserPassword" maxlength="20" id="confirmUserPassword">
                            </div>
                            <br>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="이름"
                                       name="userName" maxlength="20" id="userName">
                            </div>
                            <br>
                            <div>
                                <input type="tel" class="form-control"
                                       placeholder="전화번호 / '-'는 빼고 입력해 주세요" name="userCallNumber"
                                       pattern=".{11,11}" title="전화번호는 11자리로 입력해 주세요" id="userCallNumber"
                                       oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                            </div>
                            <br>
                            <div class="form-group" style="text-align: center;">
                                <input type="radio" class="btn-check" name="userGender" autocomplete="off" value="남자" id="male" checked>
                                <label class="btn btn-outline-secondary" for="male">남자</label>
                                <input type="radio" class="btn-check" name="userGender" autocomplete="off" value="여자" id="female"
                                       <c:if test="${dto.userGender == '여자'}">checked</c:if>>
                                <label class="btn btn-outline-secondary" for="female">여자</label>
                            </div>
                            <br>
                            <br>
                            <input type="submit" class="btn btn-outline-secondary form-control" value="회원가입">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $('input[type="text"]').keydown(function() {
            if (event.keyCode === 13) {
                event.preventDefault();
            }
        });

        if ('${signupResult}' == 'fail_id') {
            alert("이미 존재하는 아이디입니다.");

        } else if ('${signupResult}' == 'fail_password') {
            alert("비밀번호를 확인해 주세요.");

        } else if ('${signupResult}' == 'empty_userId') {
            alert("아이디를 입력해 주세요.");

        } else if ('${signupResult}' == 'empty_userPassword') {
            alert("비밀번호를 입력해 주세요.");

        } else if ('${signupResult}' == 'empty_userName') {
            alert("이름을 입력해 주세요.");

        } else if ('${signupResult}' == 'empty_userCallNumber') {
            alert("전화번호를 입력해 주세요.");
        }

        document.getElementById("userId").value = '${dto.userId}';
        document.getElementById("userName").value = '${dto.userName}';
        document.getElementById("userCallNumber").value = '${dto.userCallNumber}';
    </script>
</body>
</html>
