package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.AssignmentService;
import web.service.CarService;
import web.service.UserService;

@Controller
public class SelectionController {

    private final UserService userService;
    private final CarService carService;
    private final AssignmentService assignmentService;

    public SelectionController(UserService userService, CarService carService, AssignmentService assignmentService) {
        this.userService = userService;
        this.carService = carService;
        this.assignmentService = assignmentService;
    }

    @GetMapping("/selection")
    public String showSelectionPage(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("assignments", assignmentService.getAllAssignments());
        return "selection";
    }
}
