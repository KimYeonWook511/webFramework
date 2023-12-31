package com.webFramework.service;

import com.webFramework.domain.*;

import java.util.List;
import java.util.Map;

public interface AdminService {
    public void createCourse(String courseName) throws Exception;
    public void createCategory(String categoryName) throws Exception;
    public void createSkill(String skillName) throws Exception;
    public void createHierarchy(int courseNo, int categoryNo, int skillNo) throws Exception;
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception;
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception;
    public List<CourseVO> listCourseMaster() throws Exception;
    public List<CategoryVO> listCategoryMaster() throws Exception;
    public List<SkillVO> listSkillMaster() throws Exception;
    public boolean checkCourse(int courseNo) throws Exception;
    public boolean checkCategory(int categoryNo) throws Exception;
    public boolean checkSkill(int skillNo) throws Exception;
    public boolean checkHierarchy(int courseNo, int categoryNo, int skillNo) throws Exception;
    public boolean checkCourseName(String courseName) throws Exception;
    public boolean checkCategoryName(String categoryName) throws Exception;
    public boolean checkSkillName(String skillName) throws Exception;
    public List<CourseVO> listCourse() throws Exception;
    public List<CategoryVO> listCategory(String courseName) throws Exception;
    public List<SkillVO> listSkill(String courseName, String categoryName) throws Exception;
    public UserVO checkTeacher(String teacherId) throws Exception;
    public Integer readHierarchyNo(String courseName, String categoryName, String skillName) throws Exception;
}
