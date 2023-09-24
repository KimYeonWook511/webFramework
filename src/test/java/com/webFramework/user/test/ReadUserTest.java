package com.webFramework.user.test;

import com.webFramework.persistence.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-context.xml"})

public class ReadUserTest {
    @Inject
    UserDAO userDAO;

    @Test
    public void readUserTest() {
        try {
            System.out.println(userDAO.readUser("testId"));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}
