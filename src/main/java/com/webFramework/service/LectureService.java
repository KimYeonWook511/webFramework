package com.webFramework.service;

import com.webFramework.domain.LectureVO;

import java.util.List;
import java.util.Map;

public interface LectureService {
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception;
    public List<Map<String, Object>> listCourse() throws Exception;
    public List<Map<String, Object>> listCategory() throws Exception;
    public List<Map<String, Object>> listHierarchy() throws Exception;
}
