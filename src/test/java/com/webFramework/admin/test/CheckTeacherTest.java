package com.webFramework.admin.test;

import com.webFramework.domain.UserVO;
import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CheckTeacherTest {
    @Inject
    AdminService adminService;

    @Test
    public void checkTeacherTest() {
        String teacherId = "testTeacher";

        try {
            UserVO userVO = adminService.checkTeacher(teacherId);
            System.out.println(userVO.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("checkTeacher 실패");
        }
    }
}
