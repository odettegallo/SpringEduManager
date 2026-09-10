package com.alkemy.edumanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/")
    public String index() {
        return "index"; // Busca la plantilla index.html en src/main/resources/templates/
    }
	
	@GetMapping("/login")
    public String login() {
        return "login"; // Esto buscará tu archivo login.html
    }
}
