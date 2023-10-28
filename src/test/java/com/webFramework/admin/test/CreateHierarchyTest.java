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
        List<int[]> list = new ArrayList<>();

        // [0] => courseNo / [1] => categoryNo / [2] => skillNo
        list.add(new int[]{1, 1, 1});

        try {
            adminService.createHierarchy(list);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("createHierarchy 실패");
        }
    }
}
