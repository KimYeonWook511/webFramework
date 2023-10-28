package com.webFramework.admin.test;

import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CreateSkillTest {
    @Inject
    AdminService adminService;

    @Test
    public void createSkillTest() {
        String skillName = "Java";

        try {
            adminService.createSkill(skillName);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createSkill 실패");
        }
    }
}
