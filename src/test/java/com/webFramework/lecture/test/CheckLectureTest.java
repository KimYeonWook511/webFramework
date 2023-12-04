package com.webFramework.lecture.test;

import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CheckLectureTest {
    @Inject
    LectureService lectureService;

    @Test
    public void checkLectureTest() {
        try {
            int lectureNo = 1;

            if (lectureService.checkLecture(lectureNo)) System.out.println("강의 존재함");
            else System.out.println("강의 존재하지 않음");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("checkLecture 실패");
        }
    }
}
