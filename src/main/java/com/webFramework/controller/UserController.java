package com.webFramework.controller;

import com.webFramework.domain.UserDTO;
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

        if (userDTO.getUserId().isEmpty()) {
            logger.info("아이디 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userId");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserPassword().isEmpty()) {
            logger.info("비밀번호 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userPassword");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserName().isEmpty()) {
            logger.info("이름 입력란 공백");
            rttr.addFlashAttribute("signupResult", "empty_userName");
            rttr.addFlashAttribute("dto", userDTO);
            return "redirect:/user/signup";

        } else if (userDTO.getUserCallNumber().isEmpty()) {
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
                rttr.addFlashAttribute("joinResult", "fail_id");
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
            rttr.addFlashAttribute("joinResult", "success");

        } catch (Exception e) {
            // 세션 생성 오류
            logger.info("세션 생성중 오류");
            rttr.addFlashAttribute("joinResult", "session_fail");
        }

        return "redirect:/";
    }
}
