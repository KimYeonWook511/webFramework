package com.webFramework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    //

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void signupGET() {
        logger.info("signupGET 실행");
    }


}
