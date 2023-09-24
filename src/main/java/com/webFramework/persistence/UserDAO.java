package com.webFramework.persistence;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;

public interface UserDAO {
    public void signupUser(UserDTO userDTO) throws Exception;
    public UserVO readUser(String userId) throws Exception;
}
