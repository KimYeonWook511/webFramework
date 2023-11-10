package com.webFramework.admin.test;

import com.webFramework.domain.CourseVO;
import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListCourseTest {
    @Inject
    AdminService adminService;

    @Test
    public void listCourseTest() {
        try {
            List<CourseVO> listCourse = adminService.listMasterCourse();

            System.out.println(listCourse.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listMasterCourse 실패");
        }
    }
}
