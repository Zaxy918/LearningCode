package com.zaxyliu.interceptor;

import com.zaxyliu.utils.CurrentHolder;
import com.zaxyliu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        // Get URI
//        String uri = request.getRequestURI();
//        // Allow login to pass through
//        if (uri.contains("/login")) {
//            log.info("Login request received");
//            return true;
//        }
        // Get token from header
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("No token provided");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // Check if token is valid
        try {
            Claims claims = JwtUtils.parseToken(token);
            CurrentHolder.setCurrentId(Integer.valueOf(claims.get("id").toString()));
        } catch (Exception e) {
            log.info("Invalid token");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // Token is valid, proceed with the request
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentHolder.remove();
    }
}
