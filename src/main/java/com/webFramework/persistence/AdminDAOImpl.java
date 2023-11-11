package com.webFramework.persistence;

import com.webFramework.domain.CategoryVO;
import com.webFramework.domain.CourseVO;
import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.SkillVO;
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
    public void createHierarchy(Map<String, Integer> hierarchyMap) throws Exception {
        sqlSession.insert(NAMESPACE + ".createHierarchy", hierarchyMap);
    }

    @Override
    public void createLectureInfo(LectureDTO lectureDTO) throws Exception {
        sqlSession.insert(NAMESPACE + ".createLectureInfo", lectureDTO);
    }

    @Override
    public void createLectureHierarchy(int lectureNo, int[] hierarchyNoArr) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("lectureNo", lectureNo);

        for (int hierarchyNo : hierarchyNoArr) {
            map.put("hierarchyNo", hierarchyNo);
            sqlSession.insert(NAMESPACE + ".createLectureHierarchy", map);
        }
    }

    @Override
    public List<CourseVO> listCourseMaster() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCourseMaster");
    }

    @Override
    public List<CategoryVO> listCategoryMaster() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCategoryMaster");
    }

    @Override
    public List<SkillVO> listSkillMaster() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listSkillMaster");
    }

    @Override
    public boolean checkCourse(int courseNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkCourse", courseNo);
    }

    @Override
    public boolean checkCategory(int categoryNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkCategory", categoryNo);
    }

    @Override
    public boolean checkSkill(int skillNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkSkill", skillNo);
    }

    @Override
    public boolean checkHierarchy(Map<String, Integer> hierarchyMap) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkHierarchy", hierarchyMap);
    }
}
