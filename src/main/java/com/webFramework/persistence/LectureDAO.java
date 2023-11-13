package com.webFramework.persistence;

import com.webFramework.domain.LectureVO;

public interface LectureDAO {
    public LectureVO readLecture(String lectureName) throws Exception;
}
