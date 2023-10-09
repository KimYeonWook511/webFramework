package com.webFramework.lecture.test;

import com.webFramework.domain.LectureDTO;
import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CreateLectureTest {
    @Inject
    LectureService lectureService;

    @Test
    public void createLectureTest() {
        try {
            LectureDTO lectureDTO = new LectureDTO();
            lectureDTO.setLectureTeacherNo(0); // 강사 회원 번호
            lectureDTO.setLectureName("강의제목테스트"); // 강의 제목
            lectureDTO.setLectureContent("강의내용테스트"); // 강의 내용

            lectureService.createLecture(lectureDTO);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}
