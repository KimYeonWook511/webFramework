package com.webFramework.service;

import com.webFramework.domain.LectureVO;

import java.util.Map;

public interface LectureService {
    public Map<String, Object> readLecture(String lectureName) throws Exception;
    public boolean checkLecture(int lectureNo) throws Exception;
    public boolean checkUserLecture(int userNo, int lectureNo) throws Exception;
    public void studentCountUp(int lectureNo) throws Exception;
    public void enrollLecture(int userNo, int lectureNo) throws Exception;
}
