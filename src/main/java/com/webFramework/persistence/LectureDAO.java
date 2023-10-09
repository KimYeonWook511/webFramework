package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;

public interface LectureDAO {
    public void createLecture(LectureDTO lectureDTO) throws Exception;
}
