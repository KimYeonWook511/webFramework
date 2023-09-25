package com.webFramework.user.test;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class LoginUserTest {
    @Inject
    UserService userService;

    @Test
    public void loginUserTest() {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId("testId");
            userDTO.setUserPassword("testPassword");

            UserVO userVO = userService.readUser(userDTO.getUserId());

            if (userVO == null) System.out.println("회원 정보 없음");
            else if (!userDTO.getUserPassword().equals(userVO.getUserPassword())) System.out.println("로그인 실패");
            else System.out.println("로그인 성공");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}
