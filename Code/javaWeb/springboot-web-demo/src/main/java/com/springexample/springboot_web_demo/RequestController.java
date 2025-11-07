package com.springexample.springboot_web_demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String requestMethodName(HttpServletRequest request) {
        // Get the method
        String method = request.getMethod();
        System.out.println("Request Method: " + method);
        // Get the request URL
        String requestURL = request.getRequestURL().toString();
        System.out.println("Request URL: " + requestURL);
        // Get the request URI
        String requestURI = request.getRequestURI();
        System.out.println("Request URI: " + requestURI);
        //Get the header
        String headerValue = request.getHeader("Host");
        System.out.println("Host Header: " + headerValue);
        //Get the parameters
        String param1 = request.getParameter("name");
        String param2 = request.getParameter("age");
        System.out.println("Param1: " + param1);
        System.out.println("Param2: " + param2);
        return "Done";
    }

}
