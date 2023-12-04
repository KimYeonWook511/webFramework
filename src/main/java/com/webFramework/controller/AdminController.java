package com.webFramework.controller;

import com.webFramework.domain.LectureDTO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.AdminService;
import com.webFramework.service.LecturesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Inject
    AdminService adminService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // String[] 한개만 왔을때 ,를 기준으로 알아서 split되어 RequestParam되는 것을 방지
        binder.registerCustomEditor(
                String[].class,
                new StringArrayPropertyEditor(null));
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainGET() {
        logger.info("mainGET 실행");

        return "/admin/main";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminRootGET() {
        logger.info("adminRootGET 실행");

        return "/admin/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminEmptyGET() {
        logger.info("adminEmptyGET 실행");

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

    @RequestMapping(value = "checkTeacherAjax.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkTeacherAjaxPOST(String teacherId) {
        logger.info("checkTeacherAjaxPOST 실행");

        Map<String, Object> map = new HashMap<>();

        try {
            teacherId = teacherId.strip();

            if (teacherId.isBlank()) {
                map.put("resCode", 1);
                return map;
            }

            UserVO searchVO = (UserVO)adminService.checkTeacher(teacherId);

            if (searchVO == null) {
                map.put("resCode", 2);
                return map;
            }

            String auth = "";

            switch (searchVO.getUserAuthority()) {
                case "member":
                    auth = "회원";
                    break;
                case "teacher":
                    auth = "강사";
                    break;
                case "admin":
                    auth = "관리자";
                    break;
            }

            map.put("resCode", 0);
            map.put("id", searchVO.getUserId());
            map.put("name", searchVO.getUserName());
            map.put("auth", auth);

        } catch (Exception e) {
            logger.info(e.toString());
            map.put("resCode", -1);
        }

        return map;
    }

    @RequestMapping(value = "/getCategoryAjax.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getCategoryAjaxPOST(String courseName) {
        logger.info("getCategoryAjaxPOST 실행");

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("categoryList", adminService.listCategory(courseName));
            map.put("resCode", 1);

        } catch (Exception e) {
            logger.info(e.toString());
            map.put("resCode", -1);
        }

        return map;
    }

    @RequestMapping(value = "/getSkillAjax.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSkillAjaxPOST(String courseName, String categoryName) {
        logger.info("getSkillAjaxPOST 실행");

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("skillList", adminService.listSkill(courseName, categoryName));
            map.put("resCode", 1);

        } catch (Exception e) {
            logger.info(e.toString());
            map.put("resCode", -1);
        }

        return map;
    }

    @RequestMapping(value = "/createLecture", method = RequestMethod.GET)
    public String createLectureGET(Model model) {
        logger.info("createLectureGET 실행");

        try {
            model.addAttribute("courseList", adminService.listCourse());

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/admin/createLecture";
    }

    @RequestMapping(value = "/createLecture", method = RequestMethod.POST)
    public String createLecturePOST(String lectureTeacher, String lectureName, String lectureContent,
                                    String[] hierarchyArr, RedirectAttributes rttr, HttpServletResponse response) {
        logger.info("createLecturePOST 실행");

        lectureTeacher = lectureTeacher.strip();
        lectureName = lectureName.strip();

        if (lectureTeacher.isBlank()) {
            rttr.addFlashAttribute("errorCode", 1);
            rttr.addFlashAttribute("lectureName", lectureName);
            rttr.addFlashAttribute("lectureContent", lectureContent);
            rttr.addFlashAttribute("hierarchyArr", hierarchyArr);
            rttr.addFlashAttribute("hierarchyList", Arrays.asList(hierarchyArr));

            return "redirect:/admin/createLecture";
        }

        try {
            UserVO searchVO = adminService.checkTeacher(lectureTeacher);

            if (searchVO == null) {
                rttr.addFlashAttribute("errorCode", 2);
                rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                rttr.addFlashAttribute("lectureName", lectureName);
                rttr.addFlashAttribute("lectureContent", lectureContent);
                rttr.addFlashAttribute("hierarchyArr", hierarchyArr);
                rttr.addFlashAttribute("hierarchyList", Arrays.asList(hierarchyArr));

                return "redirect:/admin/createLecture";
            }

            if (!searchVO.getUserAuthority().equals("teacher")) {
                rttr.addFlashAttribute("errorCode", 3);
                rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                rttr.addFlashAttribute("lectureName", lectureName);
                rttr.addFlashAttribute("lectureContent", lectureContent);
                rttr.addFlashAttribute("hierarchyArr", hierarchyArr);
                rttr.addFlashAttribute("hierarchyList", Arrays.asList(hierarchyArr));

                return "redirect:/admin/createLecture";
            }

            if (lectureName.isBlank()) {
                rttr.addFlashAttribute("errorCode", 4);
                rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                rttr.addFlashAttribute("lectureName", lectureName);
                rttr.addFlashAttribute("lectureContent", lectureContent);
                rttr.addFlashAttribute("hierarchyArr", hierarchyArr);
                rttr.addFlashAttribute("hierarchyList", Arrays.asList(hierarchyArr));

                return "redirect:/admin/createLecture";
            }

            if (lectureContent.isBlank()) {
                rttr.addFlashAttribute("errorCode", 5);
                rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                rttr.addFlashAttribute("lectureName", lectureName);
                rttr.addFlashAttribute("lectureContent", lectureContent);
                rttr.addFlashAttribute("hierarchyArr", hierarchyArr);


                return "redirect:/admin/createLecture";
            }

            if (hierarchyArr.length == 0) {
                rttr.addFlashAttribute("errorCode", 6);
                rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                rttr.addFlashAttribute("lectureName", lectureName);
                rttr.addFlashAttribute("lectureContent", lectureContent);

                return "redirect:/admin/createLecture";
            }

            int hierarchyNoArr[] = new int[hierarchyArr.length];
            Integer hierarchyNo = 0; // null 처리를 위한 Integer
            String hierarchyName[];

            for (int i = 0; i < hierarchyArr.length; i++) {
                hierarchyName = hierarchyArr[i].split(",");
                hierarchyNo = adminService.readHierarchyNo(hierarchyName[0], hierarchyName[1], hierarchyName[2]);

                if (hierarchyNo == null) {
                    rttr.addFlashAttribute("errorCode", 7);
                    rttr.addFlashAttribute("lectureTeacher", lectureTeacher);
                    rttr.addFlashAttribute("lectureName", lectureName);
                    rttr.addFlashAttribute("lectureContent", lectureContent);

                    return "redirect:/admin/createLecture";
                }

                hierarchyNoArr[i] = hierarchyNo;
            }

            LectureDTO lectureDTO = new LectureDTO();
            lectureDTO.setLectureTeacherNo(searchVO.getUserNo());
            lectureDTO.setLectureName(lectureName);
            lectureDTO.setLectureContent(lectureContent);

            adminService.createLectureInfo(lectureDTO);
            adminService.createLectureHierarchy(lectureDTO.getLectureNo(), hierarchyNoArr);

            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('강의가 등록되었습니다.');location.href='/lecture/info/" + lectureName + "'</script>");
            out.flush();
            out.close();

            return ""; // out.flush() 처리 되어서 작동 안함

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }
    }
}
