package com.webFramework.admin.test;

import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class CreateCategoryTest {
    @Inject
    AdminService adminService;

    @Test
    public void createCategoryTest() {
        String categoryName = "풀스택";

        try {
            adminService.createCategory(categoryName);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createCategory 실패");
        }
    }
}
