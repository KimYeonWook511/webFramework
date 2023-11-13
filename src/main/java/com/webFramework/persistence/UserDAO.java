package com.webFramework.persistence;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;

import java.util.Map;

public interface UserDAO {
    public void signupUser(UserDTO userDTO) throws Exception;
    public UserVO readUser(String userId) throws Exception;
    public boolean signupCheckId(String userId) throws Exception;
    public Map<Integer, UserVO> listTeacher() throws Exception;
    public UserVO readTeacher(int lectureTeacherNo) throws Exception;
}
