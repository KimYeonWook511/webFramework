package com.webFramework.controller;

import com.webFramework.domain.LectureVO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping("/lecture")
public class LectureController {

    private static final Logger logger = LoggerFactory.getLogger(LectureController.class);

    @Inject
    LectureService lectureService;

    @RequestMapping(value = "/info/{lectureName}", method = RequestMethod.GET)
    public String mainLectureGET(@PathVariable String lectureName, Model model, HttpSession session) {
        logger.info("mainLectureGET 실행");

        try {
            Map<String, Object> mapLecture = lectureService.readLecture(lectureName);

            LectureVO lectureVO = (LectureVO)mapLecture.get("lectureVO");

            if (lectureVO == null) {
                logger.info("페이지 찾을 수 없음"); // lectureName에 해당되는 강의 존재하지 않음
//                return "exception 처리";
                return "redirect:/lectures";
            }

            model.addAttribute("lectureVO", lectureVO);
            model.addAttribute("teacherVO", mapLecture.get("teacherVO"));

            UserVO loginVO = (UserVO)session.getAttribute("loginVO");

            if (loginVO != null) model.addAttribute("userLecture", lectureService.checkUserLecture(loginVO.getUserNo(), lectureVO.getLectureNo()));

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }

        return "/lecture/info";
    }

    @RequestMapping(value = "/enrollLecture", method = RequestMethod.POST)
    public String enrollLecturePOST(int lectureNo, String lectureName, HttpServletResponse response, HttpSession session) {
        logger.info("enrollLecturePOST 실행");

        response.setContentType("text/html; charset=utf-8");

        try {
            PrintWriter out = response.getWriter();

            if (!lectureService.checkLecture(lectureNo)) {
                // 올바르지 않은 처리
                out.println("<script>alert('존재하지 않는 강의입니다.');location.href='/lectures'</script>");
                out.flush();
                out.close();
            }

            UserVO loginVO = (UserVO)session.getAttribute("loginVO");

            if (loginVO == null) {
                // 현재 로그인 상태가 아님
                out.println("<script>alert('현재 로그인 상태가 아닙니다.');location.href='/user/login'</script>");
                out.flush();
                out.close();

            } else if (lectureService.checkUserLecture(loginVO.getUserNo(), lectureNo)) {
                // 현재 수강중인 강의
                out.println("<script>alert('이미 수강 중인 강의입니다.');history.go(-1);</script>");
                out.flush();
                out.close();

            } else {
                lectureService.enrollLecture(loginVO.getUserNo(), lectureNo);
                lectureService.studentCountUp(lectureNo); // 수강생 수 추가

                out.println("<script>alert('수강 신청이 완료되었습니다.');location.href='/lecture/info/" + lectureName + "';</script>");
                out.flush();
                out.close();
            }

            return "out.flush() 됨";

        } catch (Exception e) {
            logger.info(e.toString());
            return "exception 처리";
        }
    }
}
