<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>강의 등록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/admin/createLecture.css">
</head>
<body>
    <jsp:include page="/WEB-INF/views/layout/navbar.jsp" flush="false"/>
    <div class="main">
        <div class="container-header">
            강의 등록
        </div>
        <div class="container">
            <form method="post" action="/admin/createLecture" class="lecture">
                <div class="lecture-info">
                    <div class="lecture-teacher">
                        강사ID
                        <div class="teacher-data">
                            <input type="text" name="lectureTeacher" id="lectureTeacher" maxlength="20" class="form-control teacher-id" placeholder="강사ID" style="height: 50px">
                            <input type="button" class="btn btn-outline-secondary form-control teacher-btn" value="검색" onclick="checkTeacher()">
                        </div>
                    </div>
                    <div class="lecture-name">
                        강의명
                        <input type="text" name="lectureName" id="lectureName" maxlength="100" class="form-control" placeholder="강의명" style="height: 50px">
                    </div>
                    <div class="lecture-content">
                        강의내용
                        <textarea name="lectureContent" id="lectureContent" maxlength="2000" class="form-control" placeholder="강의내용" style="height: 400px;"></textarea>
                    </div>
                </div>
                <div class="lecture-hierarchy">
                    <hr>
                    <div class="lecture-select">
                        <div class="select-title">선택한 분류 계층</div>
                        <div class="select-data" id="select-data"></div>
                    </div>
                    <div class="lecture-course">
                        <div class="course-title">대분류</div>
                        <div class="course-data">
                            <c:forEach items="${courseList}" var="courseVO">
                                <input class="btn-check" type="radio" autocomplete="off" name="courseName" value="${courseVO.courseName}" id="${courseVO.courseName}" onclick="showCategory('${courseVO.courseName}')">
                                <label class="btn btn-outline-secondary" for="${courseVO.courseName}">${courseVO.courseName}</label>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="lecture-category" id="lecture-category">
                        <div class="category-title">중분류</div>
                        <div class="category-data" id="category-data"></div>
                    </div>
                    <div class="lecture-skill" id="lecture-skill">
                        <div class="skill-title">소분류</div>
                        <div class="skill-data" id="skill-data"></div>
                    </div>
                    <div class="lecture-add" id="lecture-add">
                        <input type="button" class="btn btn-outline-secondary form-control" value="분류 추가" onclick="hierarchyAdd()">
                    </div>
                </div>
                <div class="lecture-submit">
                    <hr><br>
                    <input type="submit" class="btn btn-outline-secondary form-control" value="강의 등록">
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

        function checkTeacher() {
            let input = document.getElementById('lectureTeacher');
            let id = input.value.trim();
            let result = false;

            if (!id) {
                alert('강사ID를 입력해 주세요.');
                return result;
            }

            $.ajax({
                url: './checkTeacherAjax.do',
                type: 'POST',
                dataType : "json",
                data: {
                    teacherId: id
                },
                success : function(res) { // 비동기 통신 성공 success 콜백, res는 응답받은 데이터
                    let resCode = res.resCode;

                    if (resCode == 1) {
                        // 혹시 모를 빈 문자열 체크
                        alert('강사ID를 입력해 주세요.');
                        input.focus();

                    } else if (resCode == 2) {
                        alert('존재하지 않는 ID입니다.');
                        input.focus();

                    } else if (resCode == 0) {
                        alert('ID: ' + res.id + '\n이름: ' + res.name + '(' + res.auth + ')');

                        if (res.auth != '강사') {
                            alert('강사ID를 입력해 주세요.');
                        } else {
                            result = true;
                        }
                    }
                },
                error : function(request, error) { // 비동기 통신 실패 error 콜백
                    // alert("통신 실패");
                    alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
                    location.href = '/';
                }
            });

            return result;
        }

        function showCategory(courseName) {
            document.getElementById('lecture-category').style.display = 'grid';

            $.ajax({
                url: './getCategoryAjax.do',
                type: 'POST',
                dataType : "json",
                data: {
                    courseName: courseName
                },
                success : function(res) { // 비동기 통신 성공 success 콜백, res는 응답받은 데이터
                    let categoryData = document.getElementById('category-data');

                    categoryData.replaceChildren(); // 초기화

                    let categoryList = res.categoryList;

                    for (let i = 0; i < categoryList.length; i++) {
                        let val = categoryList[i].categoryName;

                        categoryData.innerHTML += '<input class="btn-check" type="radio" autocomplete="off" name="categoryName" ' +
                                                   'value="' + val + '" id="' + val + '" ' +
                                                   'onclick="showSkill(' + "'" + courseName + "', '" + val + "'" + ')"> ';
                        categoryData.innerHTML += '<label class="btn btn-outline-secondary" for="' + val + '">' + val + '</label>';
                    }

                    // categoryData.appendChild(categoryData);
                    // categoryData.update(categoryData)
                },
                error : function(request, error) { // 비동기 통신 실패 error 콜백
                    // alert("통신 실패");
                    alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
                    location.href = '/';
                }
            });
        }

        function showSkill(courseName, categoryName) {
            document.getElementById('lecture-skill').style.display = 'grid';

            $.ajax({
                url: './getSkillAjax.do',
                type: 'POST',
                dataType : "json",
                data: {
                    courseName: courseName,
                    categoryName: categoryName
                },
                success : function(res) { // 비동기 통신 성공 success 콜백, res는 응답받은 데이터
                    let skillData = document.getElementById('skill-data');

                    skillData.replaceChildren(); // 초기화

                    let skillList = res.skillList;
                    // alert(skillList.length);
                    for (var i = 0; i < skillList.length; i++) {
                        let val = skillList[i].skillName;

                        skillData.innerHTML += '<input class="btn-check" type="radio" autocomplete="off" name="skillName" ' +
                                                'value="' + val + '" id="' + val + '" onclick="showAdd()"> ';
                        skillData.innerHTML += '<label class="btn btn-outline-secondary" for="' + val + '">' + val + '</label>';
                    }
                },
                error : function(request, error) { // 비동기 통신 실패 error 콜백
                    // alert("통신 실패");
                    alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
                    location.href = '/';
                }
            });
        }

        function showAdd() {
            document.getElementById('lecture-add').style.display = 'grid';
        }

        function hierarchyAdd() {
            if($('input[name="courseName"]').is(':checked') && $('input[name="categoryName"]').is(':checked') && $('input[name="skillName"]').is(':checked')){
                let val = $('input[name="courseName"]:checked').val() + "," + $('input[name="categoryName"]:checked').val() + "," + $('input[name="skillName"]:checked').val();

                if (document.getElementById(val)) {
                    alert('이미 선택된 분류 계층입니다.');

                } else {
                    let selectData = document.getElementById('select-data');

                    let hidden = document.createElement('input');
                    hidden.setAttribute('type', 'hidden');
                    hidden.setAttribute('name', 'hierarchyArr');
                    hidden.setAttribute('value', val);

                    let newButton = document.createElement('input');
                    newButton.setAttribute('class', 'btn-check');
                    newButton.setAttribute('type', 'button');
                    newButton.setAttribute('autocomplete', 'off');
                    newButton.setAttribute('id', val);

                    let newLabel = document.createElement('label');
                    newLabel.setAttribute('class', 'btn btn-outline-secondary select-items');
                    newLabel.setAttribute('for', val);
                    newLabel.textContent = val;
                    newLabel.style.color = '#ffffff';
                    newLabel.style.backgroundColor = '#6c757d';
                    newLabel.style.borderColor = '#6c757d';

                    newLabel.addEventListener('mouseover', function () {
                        newLabel.textContent = 'x';
                        newLabel.style.color = '';
                        newLabel.style.backgroundColor = '';
                        newLabel.style.borderColor = '';
                    });

                    newLabel.addEventListener('mouseout', function () {
                        newLabel.textContent = val; // 마우스가 벗어났을 때 다시 원래 텍스트로 변경

                        newLabel.style.color = '#ffffff';
                        newLabel.style.backgroundColor = '#6c757d';
                        newLabel.style.borderColor = '#6c757d';
                        newLabel.style.width = newLabel.offsetWidth + 'px';
                    });

                    newButton.addEventListener('click', function () {
                        selectData.removeChild(newButton);
                        selectData.removeChild(newLabel);
                    });

                    selectData.appendChild(hidden);
                    selectData.appendChild(newButton);
                    selectData.appendChild(newLabel);

                    $('input[name="courseName"]').prop('checked', false);
                    document.getElementById('lecture-category').style.display = 'none';
                    document.getElementById('lecture-skill').style.display = 'none';
                    document.getElementById('lecture-add').style.display = 'none';
                    document.getElementById('category-data').replaceChildren();
                    document.getElementById('skill-data').replaceChildren();
                }

            } else {
                alert('분류를 선택해 주세요.');
            }
        }

        document.getElementById("lectureTeacher").value = '${lectureTeacher}';
        document.getElementById("lectureName").value = '${lectureName}';
        document.getElementById("lectureContent").value = '${lectureContent}';

        let list = [];

        <c:forEach items="${hierarchyList}" var="hierarchy">
            list.push('${hierarchy}');
        </c:forEach>

        for (let i = 0; i < list.length; i++) {
            let selectData = document.getElementById('select-data');
            let val = list[i];

            let hidden = document.createElement('input');
            hidden.setAttribute('type', 'hidden');
            hidden.setAttribute('name', 'hierarchyArr');
            hidden.setAttribute('value', val);

            let newButton = document.createElement('input');
            newButton.setAttribute('class', 'btn-check');
            newButton.setAttribute('type', 'button');
            newButton.setAttribute('autocomplete', 'off');
            newButton.setAttribute('name', 'hierarchyArr');
            newButton.setAttribute('value', val);
            newButton.setAttribute('id', val);

            let newLabel = document.createElement('label');
            newLabel.setAttribute('class', 'btn btn-outline-secondary select-items');
            newLabel.setAttribute('for', val);
            newLabel.textContent = val;
            newLabel.style.color = '#ffffff';
            newLabel.style.backgroundColor = '#6c757d';
            newLabel.style.borderColor = '#6c757d';

            newLabel.addEventListener('mouseover', function () {
                newLabel.textContent = 'x';
                newLabel.style.color = '';
                newLabel.style.backgroundColor = '';
                newLabel.style.borderColor = '';
            });

            newLabel.addEventListener('mouseout', function () {
                newLabel.textContent = val; // 마우스가 벗어났을 때 다시 원래 텍스트로 변경

                newLabel.style.color = '#ffffff';
                newLabel.style.backgroundColor = '#6c757d';
                newLabel.style.borderColor = '#6c757d';
                newLabel.style.width = newLabel.offsetWidth + 'px';
            });

            newButton.addEventListener('click', function () {
                selectData.removeChild(newButton);
                selectData.removeChild(newLabel);
            });

            selectData.appendChild(hidden);
            selectData.appendChild(newButton);
            selectData.appendChild(newLabel);
        }

        if ('${errorCode}' == '1') {
            alert("errorCode: 1\n강사ID 미입력");

        } else if ('${errorCode}' == '2') {
            alert("errorCode: 2\n존재하지 않는 ID");

        } else if ('${errorCode}' == '3') {
            alert("errorCode: 3\n강사가 아님");

        } else if ('${errorCode}' == '4') {
            alert("errorCode: 4\n강의명 미입력");

        } else if ('${errorCode}' == '5') {
            alert("errorCode: 5\n강의내용 미입력");

        } else if ('${errorCode}' == '6') {
            alert("errorCode: 6\n계층 선택 안함");

        } else if ('${errorCode}' == '7') {
            alert("errorCode: 7\n올바르지 않은 계층 값");
        }
    </script>
</body>
</html>