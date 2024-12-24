package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Отображение списка пользователей
    @GetMapping
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", service.findAll());
        return "index"; // index.html
    }

    // Форма добавления
    @GetMapping("/new")
    public String newUserForm() {
        return "form"; // form.html
    }

    // Обработка POST (добавление)
    @PostMapping
    public String createUser(@RequestParam String name, @RequestParam int age) {
        User user = new User(name, age);
        service.save(user);
        return "redirect:/users";
    }

    // Форма для редактирования
    @GetMapping("/edit")
    public String editUserForm(@RequestParam Long id, ModelMap model) {
        User user = service.findById(id);
        model.addAttribute("user", user);
        return "edit"; // edit.html
    }

    // Обработка POST (обновление)
    @PostMapping("/update")
    public String updateUser(@RequestParam Long id,
                             @RequestParam String name,
                             @RequestParam int age) {
        User user = new User(name, age);
        user.setId(id);
        service.update(user);
        return "redirect:/users";
    }

    // Удаление
    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
