package com.webFramework.lecture.test;

import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class EnrollLectureTest {
    @Inject
    LectureService lectureService;

    @Test
    public void enrollLectureTest() {
        try {
            int userNo = 1;
            int lectureNo = 1;

            lectureService.enrollLecture(userNo, lectureNo);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("enrollLecture 실패");
        }
    }
}
