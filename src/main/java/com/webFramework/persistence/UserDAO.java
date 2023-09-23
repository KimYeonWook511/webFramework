package com.webFramework.persistence;

import com.webFramework.domain.UserDTO;

public interface UserDAO {
    public void signupUser(UserDTO userDTO) throws Exception;

}
