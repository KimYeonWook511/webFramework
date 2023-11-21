package com.webFramework.admin.test;

import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CreateMasterTest {
    @Inject
    AdminService adminService;

    @Test
    public void createMasterTest() {
        String master = "course"; // 대분류
//        String master = "category"; // 중분류
//        String master = "skill"; // 소분류

        String courseName = "IT∙프로그래밍";

        try {
            courseName = courseName.strip();

            if (adminService.checkCourseName(courseName)) System.out.println("대분류 중복");
            else adminService.createCourse(courseName);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createMaster 실패");
        }
    }
}
