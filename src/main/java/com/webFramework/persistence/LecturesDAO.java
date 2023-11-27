package com.webFramework.persistence;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureVO;

import java.util.List;
import java.util.Map;

public interface LecturesDAO {
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception;
    public List<CourseVO> listCourse() throws Exception;
    public List<CategoryVO> listCategory(String courseName) throws Exception;
    public List<Map<String, Object>> listHierarchy() throws Exception;
}
