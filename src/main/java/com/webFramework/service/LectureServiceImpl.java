package com.webFramework.service;

import com.webFramework.domain.LectureVO;
import com.webFramework.persistence.LectureDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    @Inject
    private LectureDAO lectureDAO;

    @Override
    public List<LectureVO> listLecture(int courseNo, int categoryNo, int skillNo) throws Exception {
        return lectureDAO.listLecture(courseNo, categoryNo, skillNo);
    }
}
