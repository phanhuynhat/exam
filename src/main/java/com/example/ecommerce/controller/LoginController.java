package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @GetMapping("/403")
  public String accessDenied() {
    return "403";
  }

}

