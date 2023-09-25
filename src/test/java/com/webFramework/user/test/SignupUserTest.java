package com.webFramework.user.test;

import com.webFramework.domain.UserDTO;
import com.webFramework.persistence.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class SignupUserTest {
    @Inject
    UserDAO userDAO;

    @Test
    public void signupUserTest() {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId("testId");
            userDTO.setUserPassword("testPassword");
            userDTO.setUserName("테스트이름");
            userDTO.setUserGender("남자");
            userDTO.setUserCallNumber("01012345678");

            if (userDAO.signupCheckId(userDTO.getUserId())) {
                System.out.println("아이디 중복");
            } else {
                userDAO.signupUser(userDTO);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}
