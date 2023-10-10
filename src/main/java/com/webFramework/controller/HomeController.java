package com.webFramework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainGET() {
        logger.info("mainGET 실행");
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexGET() {
        logger.info("indexGET 실행");
        return "index";
    }
}
