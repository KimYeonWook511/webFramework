package com.webFramework.persistence;

import com.webFramework.domain.LectureVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.print.attribute.standard.MediaSize;
import java.util.HashMap;
import java.util.Map;

@Repository
public class LectureDAOImpl implements LectureDAO {
    @Inject
    private SqlSession sqlSession;
    private static final String NAMESPACE = "com.webFramework.mappers.lectureMapper";

    @Override
    public LectureVO readLecture(String lectureName) throws Exception {
        return (LectureVO)sqlSession.selectOne(NAMESPACE + ".readLecture", lectureName);
    }

    @Override
    public boolean checkLecture(int lectureNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkLecture", lectureNo);
    }

    @Override
    public boolean checkUserLecture(int userNo, int lectureNo) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("lectureNo", lectureNo);

        return sqlSession.selectOne(NAMESPACE + ".checkUserLecture", map);
    }

    @Override
    public void studentCountUp(int lectureNo) throws Exception {
        sqlSession.update(NAMESPACE + ".studentCountUp", lectureNo);
    }

    @Override
    public void enrollLecture(int userNo, int lectureNo) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("lectureNo", lectureNo);

        sqlSession.insert(NAMESPACE + ".enrollLecture", map);
    }
}
