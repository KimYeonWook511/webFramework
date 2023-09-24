package com.webFramework.service;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import com.webFramework.persistence.UserDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDAO userDAO;

    @Override
    public void signupUser(UserDTO userDTO) throws Exception {
        userDAO.signupUser(userDTO);
    }

    @Override
    public UserVO readUser(String userId) throws Exception {
        return (UserVO)userDAO.readUser(userId);
    }
}
