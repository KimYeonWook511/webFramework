package com.webFramework.service;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import com.webFramework.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDAO userDAO;

    @Override
    public boolean signupUser(UserDTO userDTO) throws Exception {
        if (userDAO.signupCheckId(userDTO.getUserId())) {
            // 아이디 중복
            return true;
        }

        // 회원가입 진행
        userDAO.signupUser(userDTO);
        return false;
    }

    @Override
    public UserVO readUser(String userId) throws Exception {
        return (UserVO)userDAO.readUser(userId);
    }

    @Override
    public Map<Integer, UserVO> mapTeacher() throws Exception {
        return userDAO.listTeacher();
    }
}
