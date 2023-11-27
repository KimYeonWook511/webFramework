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

public class ListSkillTest {
    @Inject
    AdminService adminService;

    @Test
    public void listSkillTest() {
        try {
            String courseName = "IT∙프로그래밍";
            String categoryName = "백엔드";
            List<SkillVO> list = adminService.listSkill(courseName, categoryName);

            for (SkillVO vo : list) {
                System.out.println("skillNo: " + vo.getSkillNo() + " | skillName: " + vo.getSkillName());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("listSkill 실패");
        }
    }
}
