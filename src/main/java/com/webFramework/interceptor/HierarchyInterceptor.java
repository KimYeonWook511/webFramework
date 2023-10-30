package com.webFramework.interceptor;

import com.webFramework.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HierarchyInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(HierarchyInterceptor.class);

    @Inject
    LectureService lectureService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("hierarchySession preHandle 실행");

        HttpSession session = request.getSession();

        if (session.getAttribute("hierarchyList") == null) {
            session.setAttribute("hierarchyList", lectureService.listSkill());
        }

        return true;
    }
}
