package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("welcomeMessage", "Добро пожаловать на тестовое задание выполненное Syrex!");
        return "home";
    }
}
