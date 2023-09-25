package com.webFramework.service;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;

public interface UserService {
    public boolean signupUser(UserDTO userDTO) throws Exception;
    public UserVO readUser(String userId) throws Exception;
}
