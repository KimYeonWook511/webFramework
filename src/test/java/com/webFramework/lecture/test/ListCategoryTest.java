package com.webFramework.lecture.test;

import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListCategoryTest {
    @Inject
    LectureService lectureService;

    @Test
    public void listCategoryTest() {
        try {
            List<Map<String, Object>> list = lectureService.listCategory();

            for (Map<String, Object> hierarchy : list) {
                System.out.println("courseNo: " + hierarchy.get("courseNo") + " | courseName: " + hierarchy.get("courseName") + " | categoryNo: " + hierarchy.get("categoryNo") + " | categoryName: " + hierarchy.get("categoryName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listCategory 실패");
        }
    }
}
