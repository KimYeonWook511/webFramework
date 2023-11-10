package com.webFramework.admin.test;

import com.webFramework.domain.SkillVO;
import com.webFramework.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ListSkillMasterTest {
    @Inject
    AdminService adminService;

    @Test
    public void listSkillMasterTest() {
        try {
            List<SkillVO> listSkill = adminService.listSkillMaster();

            System.out.println(listSkill.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listSkillMaster 실패");
        }
    }
}
