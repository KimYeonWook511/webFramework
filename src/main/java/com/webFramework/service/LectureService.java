package com.webFramework.service;

import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.LectureVO;

public interface LectureService {
    public void createLecture(LectureDTO lectureDTO) throws Exception;
}
