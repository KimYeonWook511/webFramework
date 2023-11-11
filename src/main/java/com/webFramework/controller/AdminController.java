package com.webFramework.controller;

import com.webFramework.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    AdminService adminService;

    @RequestMapping(value = "/createHierarchy", method = RequestMethod.GET)
    public String createHierarchyGET(Model model) {
        logger.info("createHierarchyGET 실행");

        try {
            model.addAttribute("courseList", adminService.listCourseMaster());

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            model.addAttribute("categoryList", adminService.listCategoryMaster());

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            model.addAttribute("skillList", adminService.listSkillMaster());

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/admin/createHierarchy";
    }
}
