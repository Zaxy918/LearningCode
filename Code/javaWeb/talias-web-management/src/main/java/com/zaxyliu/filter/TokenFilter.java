package com.zaxyliu.filter;

import com.zaxyliu.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        // Get URI
        String uri = httpServletRequest.getRequestURI();
        // Allow login to pass through
        if (uri.contains("/login")) {
            log.info("Login request received");
            chain.doFilter(request, response);
            return;
        }
        // Get token from header
        String token = httpServletRequest.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("No token provided");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        // Check if token is valid
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("Invalid token");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        // Token is valid, proceed with the request
        chain.doFilter(request, response);
    }
}
