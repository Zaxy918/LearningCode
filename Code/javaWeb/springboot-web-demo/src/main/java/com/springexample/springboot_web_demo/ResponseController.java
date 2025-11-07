package com.springexample.springboot_web_demo;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ResponseController {

    @RequestMapping("/response")
    public void responseController(HttpServletResponse response) throws IOException {
        // Set status
        // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // Set header
        response.setHeader("name", "zaxy");
        // Set bodies
        response.getWriter().write("<h1>hello response</h1>");
    }

    @RequestMapping("/response2")
    public ResponseEntity<String> responseEntityController() {
        return ResponseEntity.status(200).header("name", "java").body("<h1>FUCK U</h1>");
    }
}
