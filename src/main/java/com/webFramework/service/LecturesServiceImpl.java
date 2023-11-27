package com.webFramework.service;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LecturesDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class LecturesServiceImpl implements LecturesService {
    @Inject
    private LecturesDAO lecturesDAO;

    @Override
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception {
        return lecturesDAO.listLecture(courseName, categoryName, skillName);
    }

    @Override
    public List<CourseVO> listCourse() throws Exception {
        return lecturesDAO.listCourse();
    }

    @Override
    public List<CategoryVO> listCategory(String courseName) throws Exception {
        return lecturesDAO.listCategory(courseName);
    }

    @Override
    public List<Map<String, Object>> listHierarchy() throws Exception {
        return lecturesDAO.listHierarchy();
    }
}
