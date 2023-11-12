package com.webFramework.service;

import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LectureDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class LectureServiceImpl implements LectureService {
    @Inject
    private LectureDAO lectureDAO;

    @Override
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception {
        return lectureDAO.listLecture(courseName, categoryName, skillName);
    }

    @Override
    public List<Map<String, Object>> listCourse() throws Exception {
        return lectureDAO.listCourse();
    }

    @Override
    public List<Map<String, Object>> listCategory() throws Exception {
        return lectureDAO.listCategory();
    }

    @Override
    public List<Map<String, Object>> listHierarchy() throws Exception {
        return lectureDAO.listHierarchy();
    }
}
