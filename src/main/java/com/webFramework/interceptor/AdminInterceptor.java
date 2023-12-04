package com.webFramework.interceptor;

import com.webFramework.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AdminInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("AdminInterceptor preHandle 실행");

        String prerender = request.getHeader("Sec-Purpose");
        System.out.println("prerender: " + prerender);

        if (prerender != null && prerender.equals("prefetch;prerender")) {
            System.out.println("사전 렌더링 감지 -> (404 오류 코드 반환)");
            response.setStatus(404);
            return false;
        }

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
