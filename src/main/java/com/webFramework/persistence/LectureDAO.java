package com.webFramework.persistence;

import com.webFramework.domain.LectureVO;

public interface LectureDAO {
    public LectureVO readLecture(String lectureName) throws Exception;
    public boolean checkLecture(int lectureNo) throws Exception;
    public boolean checkUserLecture(int userNo, int lectureNo) throws Exception;
    public void studentCountUp(int lectureNo) throws Exception;
    public void enrollLecture(int userNo, int lectureNo) throws Exception;
}
