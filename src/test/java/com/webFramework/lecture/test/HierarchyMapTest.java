package com.webFramework.lecture.test;

import com.webFramework.service.LectureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class HierarchyMapTest {
    @Inject
    LectureService lectureService;

    @Test
    public void hierarchyMapTest() {
        try {
            List<Map<String, Object>> list = lectureService.listSkill();

            for (Map<String, Object> hierarchy : list) {
                System.out.println("courseNo: " + hierarchy.get("courseNo") + " | courseName: " + hierarchy.get("courseName")
                        + " | categoryNo: " + hierarchy.get("categoryNo") + " | categoryName: " + hierarchy.get("categoryName")
                        + " | skillNo: " + hierarchy.get("skillNo") + " | skillName: " + hierarchy.get("skillName"));
            }

            Map<String, Map<String, List<String>>> hierarchyMap = new HashMap<>();

            for (Map<String,Object> m : list) {
                String courseName = (String)m.get("courseName");
                String categoryName = (String)m.get("categoryName");
                String skillName = (String)m.get("skillName");
                System.out.println(courseName+"|"+categoryName+"|"+skillName);

                Map<String, List<String>> innerMap = new HashMap<>();

                if (hierarchyMap.containsKey(courseName)) innerMap = hierarchyMap.get(courseName);
                else hierarchyMap.put(courseName, innerMap);

                if (!innerMap.containsKey(categoryName)) innerMap.put(categoryName, new ArrayList<>());

                innerMap.get(categoryName).add(skillName);
            }

            System.out.println(hierarchyMap);
            System.out.println(hierarchyMap.get("IT∙프로그래밍"));
            System.out.println(hierarchyMap.get("IT∙프로그래밍").get("풀스택"));
            System.out.println(hierarchyMap.get("IT∙프로그래밍").get("백엔드"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listSkill 실패");
        }
    }
}
