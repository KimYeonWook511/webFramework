package com.webFramework.service;

import com.webFramework.domain.LectureDTO;

import java.util.List;

public interface AdminService {
    public void createCourse(String courseName) throws Exception;
    public void createCategory(String categoryName) throws Exception;
    public void createSkill(String skillName) throws Exception;
}
