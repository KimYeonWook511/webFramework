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

    @Override
    public void createHierarchy(List<int[]> hierarchyList) throws Exception {
        adminDAO.createHierarchy(hierarchyList);
    }

    @Override
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception {
        adminDAO.createLectureInfo(lectureDTO);
    }

    @Override
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception {
        adminDAO.createLectureHierarchy(lectureNo, hierarchyNoArr);
    }
}
