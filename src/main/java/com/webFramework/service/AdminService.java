package com.webFramework.service;

import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureDTO;

import java.util.List;
import java.util.Map;

public interface AdminService {
    public void createCourse(String courseName) throws Exception;
    public void createCategory(String categoryName) throws Exception;
    public void createSkill(String skillName) throws Exception;
    public void createHierarchy(List<int[]> hierarchyList) throws Exception;
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception;
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception;
    public List<CourseVO> listMasterCourse() throws Exception;
}
