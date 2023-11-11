package com.webFramework.admin.test;

import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CreateHierarchyTest {
    @Inject
    AdminService adminService;

    @Test
    public void createHierarchy() {
        int courseNo = 1;
        int categoryNo = 1;
        int skillNo = 1;

        try {
            if (!adminService.checkCourse(courseNo)) {
                System.out.println("대분류 없음");

            } else if (!adminService.checkCategory(categoryNo)) {
                System.out.println("중분류 없음");

            } else if (!adminService.checkSkill(skillNo)) {
                System.out.println("소분류 없음");

            } else if (adminService.checkHierarchy(courseNo, categoryNo, skillNo)) {
                System.out.println("분류 계층 존재");

            } else {
                adminService.createHierarchy(courseNo, categoryNo, skillNo);
                System.out.println("분류 계층 생성 완료");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createHierarchy 실패");
        }
    }
}
