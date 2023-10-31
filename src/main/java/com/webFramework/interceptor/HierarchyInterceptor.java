package com.webFramework.interceptor;

import com.webFramework.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchyInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(HierarchyInterceptor.class);

    @Inject
    LectureService lectureService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("hierarchyInterceptor preHandle 실행");

        HttpSession session = request.getSession();

        if (session.getAttribute("hierarchyMap") == null) {
            List<Map<String, Object>> hierarchyList = lectureService.listSkill();

            Map<String, Map<String, List<String>>> hierarchyMap = new HashMap<>();

            for (Map<String,Object> hierarchy : hierarchyList) {
                String courseName = (String)hierarchy.get("courseName");
                String categoryName = (String)hierarchy.get("categoryName");
                String skillName = (String)hierarchy.get("skillName");

                Map<String, List<String>> innerMap = new HashMap<>();

                // innerMap(Map<String, List<String>>)
                if (hierarchyMap.containsKey(courseName)) innerMap = hierarchyMap.get(courseName);
                else hierarchyMap.put(courseName, innerMap);

                // skillName(List<String>)
                if (!innerMap.containsKey(categoryName)) innerMap.put(categoryName, new ArrayList<>());
                innerMap.get(categoryName).add(skillName);
            }

            session.setAttribute("hierarchyMap", hierarchyMap);
        }

        return true;
    }
}
