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

public class ReadHierarchyNoTest {
    @Inject
    AdminService adminService;

    @Test
    public void readHierarchyNoTest() {
        String hierarchyName[] = "IT∙프로그래밍,백엔드,JavaScript".split(",");
//        String hierarchyName[] = "IT∙프로그래밍,백엔드,JavaScript1".split(",");
        Integer hierarchyNo;

        try {
            hierarchyNo = adminService.readHierarchyNo(hierarchyName[0], hierarchyName[1], hierarchyName[2]);

            System.out.println(hierarchyNo);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("readHierarchyNo 실패");
        }
    }
}
