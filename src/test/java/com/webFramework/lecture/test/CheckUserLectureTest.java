package com.webFramework.lecture.test;

import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CheckUserLectureTest {
    @Inject
    LectureService lectureService;

    @Test
    public void checkUserLectureTest() {
        try {
            int userNo = 1;
            int lectureNo = 1;

            if (lectureService.checkUserLecture(userNo, lectureNo)) System.out.println("현재 수강 중");
            else System.out.println("수강 신청 가능");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("checkUserLecture 실패");
        }
    }
}
