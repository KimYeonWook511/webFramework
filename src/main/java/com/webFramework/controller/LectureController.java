package com.webFramework.controller;

import com.webFramework.domain.LectureVO;
import com.webFramework.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    LectureService lectureService;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allLectureGET(Model model) {
        logger.info("allLectureGET 실행");

        try {
            List<LectureVO> lectureList = lectureService.listLecture(null, null, null);

            model.addAttribute("lectureList", lectureList);

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/lecture/main";
    }

    @RequestMapping(value = "/{courseName}", method = RequestMethod.GET)
    public String courseLectureGET(@PathVariable String courseName, Model model) {
        logger.info("courseLectureGET 실행");

        try {
            List<LectureVO> lectureList = lectureService.listLecture(courseName, null, null);

            if (lectureList.isEmpty()) return "redirect:/lecture";

            model.addAttribute("lectureList", lectureList);

        } catch (Exception e) {
            logger.info(e.toString());
            return "redirect:/lecture";
        }

        return "/lecture/main";
    }

    @RequestMapping(value = "/{courseName}/{categoryName}", method = RequestMethod.GET)
    public String categoryLectureGET(@PathVariable String courseName, @PathVariable String categoryName,
                                     String skill, Model model) {
        logger.info("categoryLectureGET 실행");

        try {
            List<LectureVO> lectureList = new ArrayList<>();

            if (skill == null) lectureList = lectureService.listLecture(courseName, categoryName, null);
            else lectureList = lectureService.listLecture(courseName, categoryName, skill);

//            System.out.println(new String("\u2219"));
//            System.out.println(new String(courseName.getBytes(StandardCharsets.UTF_16)));
//            System.out.println(courseName.getBytes(StandardCharsets.UTF_16).toString());
//            System.out.println(courseName.getBytes("UTF-16"));
//            System.out.println(courseName.getBytes("UTF-16").toString());
//            System.out.println(new String(courseName.getBytes("UTF-16")));
//            if (lectureList.isEmpty()) return "redirect:/lecture/" + new String(courseName.getBytes(StandardCharsets.UTF_8));
            if (lectureList.isEmpty()) return "redirect:/lecture/" + URLEncoder.encode(courseName, StandardCharsets.UTF_8);

            model.addAttribute("lectureList", lectureList);

        } catch (Exception e) {
            logger.info(e.toString());
            return "redirect:/lecture/" + courseName;
        }

        return "/lecture/main";
    }
}
