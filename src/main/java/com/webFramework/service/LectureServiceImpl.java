package com.webFramework.service;

import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LectureDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class LectureServiceImpl implements LectureService {
    @Inject
    private LectureDAO lectureDAO;

    @Override
    public void createLecture(LectureDTO lectureDTO) throws Exception {
        lectureDAO.createLecture(lectureDTO);
    }
}
