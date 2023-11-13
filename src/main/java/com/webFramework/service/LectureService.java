package com.webFramework.service;

import com.webFramework.domain.LectureVO;

public interface LectureService {
    public LectureVO readLecture(String lectureName) throws Exception;
}
