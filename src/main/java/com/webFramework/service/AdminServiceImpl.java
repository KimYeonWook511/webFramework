package com.webFramework.service;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.SkillVO;
import com.webFramework.persistence.AdminDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void createHierarchy(int courseNo, int categoryNo, int skillNo) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("courseNo", courseNo);
        map.put("categoryNo", categoryNo);
        map.put("skillNo", skillNo);

        adminDAO.createHierarchy(map);
    }

    @Override
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception {
        adminDAO.createLectureInfo(lectureDTO);
    }

    @Override
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception {
        adminDAO.createLectureHierarchy(lectureNo, hierarchyNoArr);
    }

    @Override
    public List<CourseVO> listCourseMaster() throws Exception {
        return adminDAO.listCourseMaster();
    }

    @Override
    public List<CategoryVO> listCategoryMaster() throws Exception {
        return adminDAO.listCategoryMaster();
    }

    @Override
    public List<SkillVO> listSkillMaster() throws Exception {
        return adminDAO.listSkillMaster();
    }

    @Override
    public boolean checkCourse(int courseNo) throws Exception {
        return adminDAO.checkCourse(courseNo);
    }

    @Override
    public boolean checkCategory(int categoryNo) throws Exception {
        return adminDAO.checkCategory(categoryNo);
    }

    @Override
    public boolean checkSkill(int skillNo) throws Exception {
        return adminDAO.checkSkill(skillNo);
    }

    @Override
    public boolean checkHierarchy(int courseNo, int categoryNo, int skillNo) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("courseNo", courseNo);
        map.put("categoryNo", categoryNo);
        map.put("skillNo", skillNo);

        return adminDAO.checkHierarchy(map);
    }

    @Override
    public boolean checkCourseName(String courseName) throws Exception {
        return adminDAO.checkCourseName(courseName);
    }

    @Override
    public boolean checkCategoryName(String categoryName) throws Exception {
        return adminDAO.checkCategoryName(categoryName);
    }

    @Override
    public boolean checkSkillName(String skillName) throws Exception {
        return adminDAO.checkSkillName(skillName);
    }

    @Override
    public List<CourseVO> listCourse() throws Exception {
        return adminDAO.listCourse();
    }

    @Override
    public List<CategoryVO> listCategory(String courseName) throws Exception {
        return adminDAO.listCategory(courseName);
    }

    @Override
    public List<SkillVO> listSkill(String courseName, String categoryName) throws Exception {
        return adminDAO.listSkill(courseName, categoryName);
    }
}
