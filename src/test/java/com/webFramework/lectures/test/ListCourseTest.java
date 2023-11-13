package com.webFramework.lectures.test;

import com.webFramework.service.LecturesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListCourseTest {
    @Inject
    LecturesService lecturesService;

    @Test
    public void listCourseTest() {
        try {
            List<Map<String, Object>> list = lecturesService.listCourse();

            for (Map<String, Object> hierarchy : list) {
                System.out.println("courseNo: " + hierarchy.get("courseNo") + " | courseName: " + hierarchy.get("courseName"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listCourse 실패");
        }
    }
}
