package com.djw.edu.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author djw
 * @Description //TODO
 * @Date 2020/4/28 13:58
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> map : parameterMap.entrySet()) {
            System.out.println("参数信息：" + map.getKey() + ":" + StringUtils.join(map.getValue()));
        }
        return true;
    }
}
