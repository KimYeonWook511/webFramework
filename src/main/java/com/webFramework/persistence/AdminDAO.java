package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;

import java.util.List;

public interface AdminDAO {
    public void createCourse(String courseName) throws Exception;
}
