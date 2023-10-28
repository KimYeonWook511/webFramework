package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;

import java.util.List;

public interface AdminDAO {
    public void createCourse(String courseName) throws Exception;
    public void createCategory(String categoryName) throws Exception;
    public void createSkill(String skillName) throws Exception;
    public void createHierarchy(List<int[]> hierarchyList) throws Exception;
}
