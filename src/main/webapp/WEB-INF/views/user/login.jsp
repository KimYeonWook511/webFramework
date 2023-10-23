<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
    <!-- 라이브러리 등록 - jQuery, Bootstrap : CDN 방식-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="container-fluid text-center">
        <div class="row align-items-center">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <div style="padding-top: 20px;">
                    <form method="post" action="/user/login">
                        <h3 style="text-align: center;">로그인</h3>
                        <br>
                        <br>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="아이디" name="userId" maxlength="20" id="userId">
                        </div>
                        <br>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
                        </div>
                        <br>
                        <br>
                        <div class="form-group" style="text-align: right;">
                            <input type="submit" class="btn btn-outline-secondary form-control" value="로그인">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script>
        if ('${loginResult}' == -2) {
            alert("아이디가 존재하지 않습니다.");

        } else if ('${loginResult}' == -1) {
            alert("비밀번호가 일치하지 않습니다.");

            document.getElementById("userId").value = '${userId}';
        }
    </script>
</body>
</html>
