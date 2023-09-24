package com.webFramework.persistence;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

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
}
