package com.webFramework.user.test;

import com.webFramework.domain.UserDTO;
import com.webFramework.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class SignupUserTest {
    @Inject
    UserService userService;

    @Test
    public void signupUserTest() {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId("testId");
            userDTO.setUserPassword("testPassword");
            userDTO.setUserName("테스트이름");
            userDTO.setUserGender("남자");
            userDTO.setUserCallNumber("01012345678");

            if (userService.signupUser(userDTO)) {
                System.out.println("아이디 중복");
            } else {
                System.out.println("회원가입 성공");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}
