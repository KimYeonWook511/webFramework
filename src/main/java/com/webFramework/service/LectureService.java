package com.webFramework.service;

import com.webFramework.domain.LectureVO;

import java.util.Map;

public interface LectureService {
    public Map<String, Object> readLecture(String lectureName) throws Exception;
}
