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
    public List<LectureVO> listLecture(String courseName, String categoryName, String skillName) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", courseName);
        map.put("categoryName", categoryName);
        map.put("skillName", skillName == null ? null : skillName.split(","));

        return sqlSession.selectList(NAMESPACE + ".listLecture", map);
    }

    @Override
    public List<Map<String, Object>> listCourse() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCourse");
    }

    @Override
    public List<Map<String, Object>> listCategory() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCategory");
    }

    @Override
    public List<Map<String, Object>> listHierarchy() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listHierarchy");
    }
}
