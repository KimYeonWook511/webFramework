package com.webFramework.service;

import com.webFramework.domain.LectureVO;

import java.util.List;

public interface LectureService {
    public List<LectureVO> listLecture(int courseNo, int categoryNo, int skillNo) throws Exception;
}
