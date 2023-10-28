package com.webFramework.service;

import com.webFramework.domain.LectureDTO;
import com.webFramework.persistence.AdminDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Inject
    private AdminDAO adminDAO;

    @Override
    public void createCourse(String courseName) throws Exception {
        adminDAO.createCourse(courseName);
    }

    @Override
    public void createCategory(String categoryName) throws Exception {
        adminDAO.createCategory(categoryName);
    }

    @Override
    public void createSkill(String skillName) throws Exception {
        adminDAO.createSkill(skillName);
    }
}
