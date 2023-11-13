package com.webFramework.service;

import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LectureDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LectureServiceImpl implements LectureService {
    @Inject
    private LectureDAO lectureDAO;

    @Override
    public LectureVO readLecture(String lectureName) throws Exception {
        return lectureDAO.readLecture(lectureName);
    }
}
