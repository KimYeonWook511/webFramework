package com.webFramework.controller;

import com.webFramework.domain.LectureVO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.LecturesService;
import com.webFramework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lectures")
public class LecturesController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    LecturesService lecturesService;

    @Inject
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allLecturesGET(Model model) {
        logger.info("allLecturesGET 실행");

        try {
            List<LectureVO> lectureList = lecturesService.listLecture(null, null, null);
            Map<Integer, UserVO> mapTeacher = userService.mapTeacher();

            model.addAttribute("lectureList", lectureList);
            model.addAttribute("mapTeacher", mapTeacher);

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/lectures/main";
    }

    @RequestMapping(value = "/{courseName}", method = RequestMethod.GET)
    public String courseLecturesGET(@PathVariable String courseName, Model model) {
        logger.info("courseLecturesGET 실행");

        try {
            List<LectureVO> lectureList = lecturesService.listLecture(courseName, null, null);

            if (lectureList.isEmpty()) return "redirect:/lectures";

            Map<Integer, UserVO> mapTeacher = userService.mapTeacher();

            model.addAttribute("lectureList", lectureList);
            model.addAttribute("mapTeacher", mapTeacher);

        } catch (Exception e) {
            logger.info(e.toString());
            return "redirect:/lectures";
        }

        return "/lectures/main";
    }

    @RequestMapping(value = "/{courseName}/{categoryName}", method = RequestMethod.GET)
    public String categoryLecturesGET(@PathVariable String courseName, @PathVariable String categoryName,
                                     String skill, Model model) {
        logger.info("categoryLecturesGET 실행");

        try {
            List<LectureVO> lectureList;

            if (skill == null) lectureList = lecturesService.listLecture(courseName, categoryName, null);
            else lectureList = lecturesService.listLecture(courseName, categoryName, skill);

            if (lectureList.isEmpty()) return "redirect:/lectures/" + URLEncoder.encode(courseName, StandardCharsets.UTF_8);

            Map<Integer, UserVO> mapTeacher = userService.mapTeacher();

            model.addAttribute("lectureList", lectureList);
            model.addAttribute("mapTeacher", mapTeacher);

        } catch (Exception e) {
            logger.info(e.toString());
            return "redirect:/lectures/" + courseName;
        }

        return "/lectures/main";
    }
}
