package com.webFramework.controller;

import com.webFramework.domain.UserDTO;
import com.webFramework.domain.UserVO;
import com.webFramework.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void signupGET() {
        logger.info("signupGET 실행");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(@RequestParam String confirmUserPassword, @ModelAttribute UserDTO userDTO,
                             RedirectAttributes rttr, HttpServletRequest request, HttpServletResponse response) {
        logger.info("signupPOST 실행");

        if (userDTO.getUserId().isBlank()) {
            logger.info("아이디 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userId");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserPassword().isBlank()) {
            logger.info("비밀번호 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userPassword");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserName().isBlank()) {
            logger.info("이름 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userName");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserCallNumber().isBlank()) {
            logger.info("전화번호 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userCallNumber");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (!confirmUserPassword.equals(userDTO.getUserPassword())) {
            logger.info("비밀번호 불일치");
            rttr.addFlashAttribute("signupResult", "fail_password");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";
        }

        try {
            // 회원가입 시도
            boolean chk = userService.signupUser(userDTO);

            if (chk) {
                // 아이디 중복
                rttr.addFlashAttribute("signupResult", "fail_id");
                rttr.addFlashAttribute("dto", userDTO);
                return "redirect:/user/signup";
            }

        } catch (Exception e) {
            logger.info("userService중 오류");
        }

        try {
            // 세션생성
            HttpSession session = request.getSession();
            session.setAttribute("loginVO", userService.readUser(userDTO.getUserId()));
            rttr.addFlashAttribute("signupResult", "success");

        } catch (Exception e) {
            // 세션 생성 오류
            logger.info("세션 생성중 오류");
            rttr.addFlashAttribute("signupResult", "session_fail");
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public void loginGET() {
        logger.info("loginGET 실행");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute UserDTO userDTO, RedirectAttributes rttr, HttpSession session) {
        logger.info("loginPOST 실행");

        try {
            UserVO userVO = userService.readUser(userDTO.getUserId());

            if (userVO == null) {
                // 회원 정보 없음
                rttr.addFlashAttribute("loginResult", -2);

                return "redirect:/user/login";

            } else if (!userDTO.getUserPassword().equals(userVO.getUserPassword())) {
                // 비밀번호 불일치
                rttr.addFlashAttribute("loginResult", -1);
                rttr.addFlashAttribute("userId", userDTO.getUserId());

                return "redirect:/user/login";

            } else {
                // 로그인 성공
                session.setAttribute("loginVO", userVO);

                rttr.addFlashAttribute("loginResult", 1);

                return "redirect:/";
            }

        } catch (Exception e) {
            logger.info(e.toString());

            return "오류페이지";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logoutGET(HttpServletRequest request, HttpServletResponse response) {
        logger.info("logoutGET 실행");

        UserVO vo = (UserVO)request.getSession().getAttribute("loginVO");

        response.setContentType("text/html; charset=utf-8");
        
        try {
            PrintWriter out = response.getWriter();

            if (vo == null) {
                // 현재 로그인 상태가 아님
                out.println("<script>alert('현재 로그인 상태가 아닙니다.');location.href='/'</script>");

            } else {
                // 로그아웃
                request.getSession().invalidate();
                out.println("<script>alert('로그아웃 완료');location.href='/'</script>");
            }

            out.flush();

        } catch (Exception e) {
            // 스크립트 오류
            logger.info(e.toString());
        }
    }
}
