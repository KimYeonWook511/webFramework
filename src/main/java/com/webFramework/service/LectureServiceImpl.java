package com.webFramework.service;

import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LectureDAO;
import com.webFramework.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Service
public class LectureServiceImpl implements LectureService {
    @Inject
    private LectureDAO lectureDAO;

    @Inject
    private UserDAO userDAO;

    @Override
    public Map<String, Object> readLecture(String lectureName) throws Exception {
        Map<String, Object> mapLecture = new HashMap<>();
        LectureVO lectureVO = lectureDAO.readLecture(lectureName);
        mapLecture.put("lectureVO", lectureVO);

        if (lectureVO != null) mapLecture.put("teacherVO", userDAO.readTeacher(lectureVO.getLectureTeacherNo()));

        return mapLecture;
    }
}
