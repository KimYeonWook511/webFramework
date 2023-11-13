package com.webFramework.lecture.test;

import com.webFramework.domain.LectureVO;
import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ReadLectureTest {
    @Inject
    LectureService lectureService;

    @Test
    public void readLectureTest() {
        try {
            String lectureName = "강의제목테스트1";
            LectureVO lectureVO = lectureService.readLecture(lectureName);

            if (lectureVO == null) System.out.println("해당 강의 존재하지 않음");
            else System.out.println(lectureVO.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("readLecture 실패");
        }
    }
}
