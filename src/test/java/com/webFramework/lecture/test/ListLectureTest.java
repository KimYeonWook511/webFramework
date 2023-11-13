package com.webFramework.lecture.test;

import com.webFramework.domain.LectureVO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.LectureService;
import com.webFramework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListLectureTest {
    @Inject
    LectureService lectureService;

    @Inject
    UserService userService;

    @Test
    public void listLectureTest() {
        String courseName = "IT∙프로그래밍";
        String categoryName = "풀스택";
        String skillName = "Java,JavaScript";

        try {
            List<LectureVO> list = lectureService.listLecture(courseName, categoryName, skillName);
            Map<Integer, UserVO> mapTeacher = userService.mapTeacher();

            for (LectureVO lectureVO : list) {
                System.out.println(mapTeacher.get(lectureVO.getLectureTeacherNo()).getUserName() + ": " + lectureVO.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listLecture 실패");
        }
    }
}
