<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div style="background-color: antiquewhite; width: 800px; height: 500px; margin: 0 auto; margin-top: 40px;display: flex;
    justify-content : center;
    align-items : center;">
            <p style="color: black; font-size: 25px; font-weight: bold;">메인 페이지</p>
        </div>
    </div>

    <script>
        var isAutocomplete = false;

            var previousUrl = window.location.href;

            window.addEventListener('keydown', function(event) {
                if (event.keyCode === 13) {
                    var currentUrl = window.location.href;

                    // 주소창이 변경되었고 자동완성이 아닌 경우
                    if (currentUrl !== previousUrl) {
                        isAutocomplete = false;
                        console.log("sR");
                        sendRequestToServer(currentUrl); // 서버로 요청을 보내거나 다른 처리를 수행할 수 있음

                    } else {
                        isAutocomplete = true;
                    }

                    previousUrl = currentUrl;
                }
            });

        function sendRequestToServer(value) {
            // AJAX 또는 다른 방법을 사용하여 서버로 요청을 보낼 수 있음
            // 예: jQuery를 사용한 AJAX 요청
            $.ajax({
                url: '/auto', // 실제 서버 엔드포인트로 변경
                method: 'GET',
                data: { value: '값', isAutocomplete: isAutocomplete },
                success: function(response) {
                    // 서버 응답 처리
                },
                error: function(error) {
                    // 오류 처리
                }
            });
        }
    </script>

</body>
</html>
