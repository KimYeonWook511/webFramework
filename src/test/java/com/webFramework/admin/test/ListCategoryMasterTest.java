package com.webFramework.admin.test;

import com.webFramework.domain.CategoryVO;
import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListCategoryMasterTest {
    @Inject
    AdminService adminService;

    @Test
    public void listCategoryMasterTest() {
        try {
            List<CategoryVO> listCategory = adminService.listCategoryMaster();

            System.out.println(listCategory.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listCategoryMaster 실패");
        }
    }
}
