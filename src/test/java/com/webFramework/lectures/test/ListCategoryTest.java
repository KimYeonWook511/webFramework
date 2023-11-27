package com.webFramework.lectures.test;

import com.webFramework.domain.CategoryVO;
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

public class ListCategoryTest {
    @Inject
    LecturesService lecturesService;

    @Test
    public void listCategoryTest() {
        try {
            String courseName = "IT∙프로그래밍";
            List<CategoryVO> list = lecturesService.listCategory(courseName);

            for (CategoryVO vo : list) {
                System.out.println("categoryNo: " + vo.getCategoryNo() + " | categoryName: " + vo.getCategoryName());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listCategory 실패");
        }
    }
}
