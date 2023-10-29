package com.webFramework.persistence;

import com.webFramework.domain.LectureVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LectureDAOImpl implements LectureDAO{
    @Inject
    private SqlSession sqlSession;
    private static final String NAMESPACE = "com.webFramework.mappers.lectureMapper";

    @Override
    public List<LectureVO> listLecture(int courseNo, int categoryNo, int skillNo) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("courseNo", courseNo);
        map.put("categoryNo", categoryNo);
        map.put("skillNo", skillNo);

        return sqlSession.selectList(NAMESPACE + ".listLecture", map);
    }
}
