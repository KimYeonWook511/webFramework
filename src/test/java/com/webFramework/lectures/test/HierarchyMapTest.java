package com.webFramework.lectures.test;

import com.webFramework.service.LecturesService;
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
    LecturesService lecturesService;

    @Test
    public void hierarchyMapTest() {
        try {
            List<Map<String, Object>> list = lecturesService.listHierarchy();

            Map<String, Map<String, List<String>>> hierarchyMap = new HashMap<>();
            Map<String, List<String>> innerMap;
            String courseName;
            String categoryName;
            String skillName;

            for (Map<String,Object> m : list) {
                courseName = (String)m.get("courseName");
                categoryName = (String)m.get("categoryName");
                skillName = (String)m.get("skillName");

                System.out.println(courseName+"|"+categoryName+"|"+skillName);

                if (!hierarchyMap.containsKey(courseName)) hierarchyMap.put(courseName, new HashMap<String, List<String>>());
                innerMap = hierarchyMap.get(courseName);

                if (!innerMap.containsKey(categoryName)) innerMap.put(categoryName, new ArrayList<String>());
                innerMap.get(categoryName).add(skillName);
            }

            System.out.println(hierarchyMap);
//            System.out.println(hierarchyMap.get("IT∙프로그래밍"));
//            System.out.println(hierarchyMap.get("IT∙프로그래밍").get("풀스택"));
//            System.out.println(hierarchyMap.get("IT∙프로그래밍").get("백엔드"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listSkill 실패");
        }
    }
}
