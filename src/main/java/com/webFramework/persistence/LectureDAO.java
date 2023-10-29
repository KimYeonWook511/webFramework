package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.LectureVO;

import java.util.List;

public interface LectureDAO {
    public List<LectureVO> listLecture(int courseNo, int categoryNo, int skillNo) throws Exception;
}
