package com.webFramework.controller;

import com.webFramework.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

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

    @RequestMapping(value = "/createHierarchy", method = RequestMethod.POST)
    public String createHierarchyPOST(Integer courseNo, Integer categoryNo, Integer skillNo, RedirectAttributes rttr) {
        logger.info("createHierarchyPOST 실행");

        try {
            if (courseNo == null || !adminService.checkCourse(courseNo)) {
                rttr.addFlashAttribute("errorCode", 1);
                rttr.addFlashAttribute("courseNo", courseNo);
                rttr.addFlashAttribute("categoryNo", categoryNo);
                rttr.addFlashAttribute("skillNo", skillNo);

                return "redirect:/admin/createHierarchy";
            }

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            if (categoryNo == null || !adminService.checkCategory(categoryNo)) {
                rttr.addFlashAttribute("errorCode", 2);
                rttr.addFlashAttribute("courseNo", courseNo);
                rttr.addFlashAttribute("categoryNo", categoryNo);
                rttr.addFlashAttribute("skillNo", skillNo);

                return "redirect:/admin/createHierarchy";
            }

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            if (skillNo == null || !adminService.checkSkill(skillNo)) {
                rttr.addFlashAttribute("errorCode", 3);
                rttr.addFlashAttribute("courseNo", courseNo);
                rttr.addFlashAttribute("categoryNo", categoryNo);
                rttr.addFlashAttribute("skillNo", skillNo);

                return "redirect:/admin/createHierarchy";
            }

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            if (adminService.checkHierarchy(courseNo, categoryNo, skillNo)) {
                rttr.addFlashAttribute("errorCode", 4);
                rttr.addFlashAttribute("courseNo", courseNo);
                rttr.addFlashAttribute("categoryNo", categoryNo);
                rttr.addFlashAttribute("skillNo", skillNo);

                return "redirect:/admin/createHierarchy";
            }

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        try {
            adminService.createHierarchy(courseNo, categoryNo, skillNo);

            rttr.addFlashAttribute("errorCode", 0);

            return "redirect:/admin/createHierarchy";

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }
    }
}
