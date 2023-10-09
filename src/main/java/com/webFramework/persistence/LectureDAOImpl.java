package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class LectureDAOImpl implements LectureDAO{
    @Inject
    private SqlSession sqlSession;
    private static final String NAMESPACE = "com.webFramework.mappers.lectureMapper";

    @Override
    public void createLecture(LectureDTO lectureDTO) throws Exception {
        sqlSession.insert(NAMESPACE + ".createLecture", lectureDTO);
    }
}
