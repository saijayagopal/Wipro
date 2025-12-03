package com.wipro.WiproSpringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("message", "Welcome to Wipro Spring Boot");
        return "home";   // home.jsp
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("message", "Please Login");
        return "login";  // login.jsp
    }
}
