package com.webFramework.interceptor;

import com.webFramework.service.LecturesService;
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
    LecturesService lecturesService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        logger.info("hierarchyInterceptor preHandle 실행");

        HttpSession session = request.getSession();

        if (session.getAttribute("hierarchyMap") == null) {
            List<Map<String, Object>> hierarchyList = lecturesService.listHierarchy();

            Map<String, Map<String, List<String>>> hierarchyMap = new HashMap<>();
            Map<String, List<String>> innerMap;
            String courseName;
            String categoryName;
            String skillName;

            for (Map<String,Object> hierarchy : hierarchyList) {
                courseName = (String)hierarchy.get("courseName");
                categoryName = (String)hierarchy.get("categoryName");
                skillName = (String)hierarchy.get("skillName");

                // innerMap(Map<String, List<String>>)
                if (!hierarchyMap.containsKey(courseName)) hierarchyMap.put(courseName, new HashMap<String, List<String>>());
                innerMap = hierarchyMap.get(courseName);

                // skillName(List<String>)
                if (!innerMap.containsKey(categoryName)) innerMap.put(categoryName, new ArrayList<String>());
                innerMap.get(categoryName).add(skillName);
            }

            session.setAttribute("hierarchyMap", hierarchyMap);
        }

        return true;
    }
}
