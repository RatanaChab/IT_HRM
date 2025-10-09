package com.example.IT_HRM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login"; // Refers to src/main/resources/templates/login.html
    }
}
