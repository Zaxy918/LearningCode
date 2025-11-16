package com.zaxyliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TaliasWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaliasWebManagementApplication.class, args);
    }

}
