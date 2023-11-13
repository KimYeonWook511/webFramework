package com.webFramework.interceptor;

import com.webFramework.domain.UserVO;
import com.webFramework.service.LecturesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("AdminInterceptor preHandle 실행");

        UserVO loginVO = (UserVO)request.getSession().getAttribute("loginVO");

        if (loginVO != null && loginVO.getUserAuthority().equals("admin")) {
            // 관리자 로그인
            return true;
        }

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('허용되지 않은 접근입니다.'); location.href='/';</script>");
        out.flush();
        out.close();

        return false;
    }
}
