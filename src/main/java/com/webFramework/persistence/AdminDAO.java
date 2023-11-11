package com.webFramework.persistence;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.SkillVO;

import java.util.List;
import java.util.Map;

public interface AdminDAO {
    public void createCourse(String courseName) throws Exception;
    public void createCategory(String categoryName) throws Exception;
    public void createSkill(String skillName) throws Exception;
    public void createHierarchy(Map<String, Integer> hierarchyMap) throws Exception;
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception;
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception;
    public List<CourseVO> listCourseMaster() throws Exception;
    public List<CategoryVO> listCategoryMaster() throws Exception;
    public List<SkillVO> listSkillMaster() throws Exception;
    public boolean checkCourse(int courseNo) throws Exception;
    public boolean checkCategory(int categoryNo) throws Exception;
    public boolean checkSkill(int skillNo) throws Exception;
    public boolean checkHierarchy(Map<String, Integer> hierarchyMap) throws Exception;
}
