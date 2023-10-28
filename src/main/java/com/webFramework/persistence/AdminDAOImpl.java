package com.webFramework.persistence;

import com.webFramework.domain.LectureDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminDAOImpl implements AdminDAO {
    @Inject
    private SqlSession sqlSession;
    private static final String NAMESPACE = "com.webFramework.mappers.adminMapper";

    @Override
    public void createCourse(String courseName) throws Exception {
        sqlSession.insert(NAMESPACE + ".createCourse", courseName);
    }

    @Override
    public void createCategory(String categoryName) throws Exception {
        sqlSession.insert(NAMESPACE + ".createCategory", categoryName);
    }

    @Override
    public void createSkill(String skillName) throws Exception {
        sqlSession.insert(NAMESPACE + ".createSkill", skillName);
    }

    @Override
    public void createHierarchy(List<int[]> hierarchyList) throws Exception {
        Map<String, Integer> map = new HashMap<>();

        for (int[] hierarchy : hierarchyList) {
            map.put("courseNo", hierarchy[0]);
            map.put("categoryNo", hierarchy[1]);
            map.put("skillNo", hierarchy[2]);
            sqlSession.insert(NAMESPACE + ".createHierarchy", map);
        }
    }
}
