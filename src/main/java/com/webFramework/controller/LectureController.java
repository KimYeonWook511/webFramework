package com.webFramework.controller;

import com.webFramework.domain.LectureVO;
import com.webFramework.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    LectureService lectureService;

    @RequestMapping(value = "/{lectureName}")
    public String mainLectureGET(@PathVariable String lectureName, Model model) {
        logger.info("mainLectureGET 실행");

        try {
            Map<String, Object> mapLecture = lectureService.readLecture(lectureName);

            if (mapLecture.get("lectureVO") == null) {
                logger.info("페이지 찾을 수 없음"); // lectureName에 해당되는 강의 존재하지 않음
                return "exception 처리";
            }

            model.addAttribute("lectureVO", mapLecture.get("lectureVO"));
            model.addAttribute("teacherVO", mapLecture.get("teacherVO"));

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/lecture/main";
    }
}
