package com.webFramework.lecture.test;

import com.webFramework.domain.LectureVO;
import com.webFramework.service.LectureService;
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

    @Test
    public void listLectureTest() {
        int courseNo = 0;
        int categoryNo = 0;
        int skillNo = 0;

        try {
            List<LectureVO> list = lectureService.listLecture(courseNo, categoryNo, skillNo);

            for (LectureVO lectureVO : list) {
                System.out.println(lectureVO.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createCourse 실패");
        }
    }
}
