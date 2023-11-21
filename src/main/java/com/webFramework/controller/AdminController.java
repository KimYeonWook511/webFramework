package com.webFramework.controller;

import com.webFramework.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Inject
    AdminService adminService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainGET() {
        logger.info("mainGET 실행");

        return "/admin/main";
    }

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

    @RequestMapping(value = "/createMaster", method = RequestMethod.GET)
    public String createMasterGET(String master, Model model) {
        logger.info("createMasterGET 실행");

        if (master == null) {
            return "redirect:/admin/main";

        } else if (master.equals("course")) {
            try {
                model.addAttribute("courseList", adminService.listCourseMaster());
                model.addAttribute("master", "course");

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else if (master.equals("category")) {
            try {
                model.addAttribute("categoryList", adminService.listCategoryMaster());
                model.addAttribute("master", "category");

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else if (master.equals("skill")) {
            try {
                model.addAttribute("skillList", adminService.listSkillMaster());
                model.addAttribute("master", "skill");

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else {
            // 잘못된 master 파라미터 값
            return "redirect:/admin/main";
        }

        return "/admin/createMaster";
    }

    @RequestMapping(value = "/createMaster", method = RequestMethod.POST)
    public String createMasterPOST(String courseName, String categoryName, String skillName, RedirectAttributes rttr,
                                   HttpServletRequest request) {
        logger.info("createMasterPOST 실행");

        if (courseName != null && !courseName.isBlank()) {
            courseName = courseName.strip(); // 앞뒤 공백 제거

            try {
                if (adminService.checkCourseName(courseName)) {
                    // 대분류 이름 존재
                    rttr.addFlashAttribute("errorCode", 2);

                } else {
                    adminService.createCourse(courseName);

                    // 정상적으로 추가됨
                    rttr.addFlashAttribute("errorCode", 0);
                }

                rttr.addFlashAttribute("msg", "courseName: " + courseName);

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else if (categoryName != null && !categoryName.isBlank()) {
            categoryName = categoryName.strip(); // 앞뒤 공백 제거

            try {
                if (adminService.checkCategoryName(categoryName)) {
                    // 중분류 이름 존재
                    rttr.addFlashAttribute("errorCode", 2);

                } else {
                    adminService.createCategory(categoryName);

                    // 정상적으로 추가됨
                    rttr.addFlashAttribute("errorCode", 0);
                }

                rttr.addFlashAttribute("msg", "categoryName: " + categoryName);

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else if (skillName != null && !skillName.isBlank()) {
            skillName = skillName.strip(); // 앞뒤 공백 제거

            try {
                if (adminService.checkSkillName(skillName)) {
                    // 소분류 이름 존재
                    rttr.addFlashAttribute("errorCode", 2);

                } else {
                    adminService.createSkill(skillName);

                    // 정상적으로 추가됨
                    rttr.addFlashAttribute("errorCode", 0);
                }

                rttr.addFlashAttribute("msg", "skillName: " + skillName);

            } catch (Exception e) {
                logger.info(e.toString());
                return "exception 처리";
            }

        } else {
            // 잘못된 입력
            rttr.addFlashAttribute("errorCode", 1);
        }

        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/createLecture", method = RequestMethod.GET)
    public void createLectureGET() {
        logger.info("createLectureGET 실행");
    }

    @RequestMapping(value = "/createLecture", method = RequestMethod.POST)
    public String createLecturePOST(int[] courses, int[] categories, int[] skills) {
        logger.info("createLecturePOST 실행");

        System.out.println("courses : ");
        for (int courseNo : courses) {
            System.out.println(courseNo + " ");
        }

        System.out.println("categories : ");
        for (int categoryNo : categories) {
            System.out.println(categoryNo + " ");
        }

        System.out.println("skills : ");
        for (int skillNo : skills) {
            System.out.println(skillNo + " ");
        }

        return "/lecture/main";
    }
}
