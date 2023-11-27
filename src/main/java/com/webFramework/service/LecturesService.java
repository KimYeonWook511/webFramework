package com.webFramework.service;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureVO;

import java.util.List;
import java.util.Map;

public interface LecturesService {
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception;
    public List<Map<String, Object>> listHierarchy() throws Exception;
}
