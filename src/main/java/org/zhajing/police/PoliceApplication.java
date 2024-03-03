package org.zhajing.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableWebSecurity
@RestController
public class PoliceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoliceApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }




}
