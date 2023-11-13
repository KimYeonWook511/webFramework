package com.webFramework.persistence;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    @Inject
    private SqlSession sqlSession;
    private static final String NAMESPACE = "com.webFramework.mappers.userMapper";

    @Override
    public void signupUser(UserDTO userDTO) throws Exception {
        sqlSession.insert(NAMESPACE + ".signupUser", userDTO);
    }

    @Override
    public UserVO readUser(String userId) throws Exception {
        return (UserVO)sqlSession.selectOne(NAMESPACE + ".readUser", userId);
    }

    @Override
    public boolean signupCheckId(String userId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".signupCheckId", userId);
    }

    @Override
    public Map<Integer, UserVO> listTeacher() throws Exception {
        List<UserVO> listTeacher = sqlSession.selectList(NAMESPACE + ".listTeacher");

        Map<Integer, UserVO> mapTeacher = new HashMap<>();

        for (UserVO teacher : listTeacher) {
            mapTeacher.put(teacher.getUserNo(), teacher); // 중복 존재할 확률이 없어서 containsKey 하지 않음
        }

        return mapTeacher;
    }

    @Override
    public UserVO readTeacher(int lectureTeacherNo) throws Exception {
        return (UserVO)sqlSession.selectOne(NAMESPACE + ".readTeacher", lectureTeacherNo);
    }
}
