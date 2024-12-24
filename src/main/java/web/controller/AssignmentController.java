package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.model.User;
import web.service.AssignmentService;
import web.service.CarService;
import web.service.UserService;

@Controller
public class AssignmentController {

    private final UserService userService;
    private final CarService carService;
    private final AssignmentService assignmentService;

    public AssignmentController(UserService userService, CarService carService, AssignmentService assignmentService) {
        this.userService = userService;
        this.carService = carService;
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assign")
    public String assignDriverToCar(@RequestParam("userId") Long userId,
                                    @RequestParam("carModel") String carModel) {
        User user = userService.findById(userId);
        Car car = null;
        for (Car c : carService.getAllCars()) {
            if (c.getModel().equals(carModel)) {
                car = c;
                break;
            }
        }

        if (user != null && car != null) {
            assignmentService.addAssignment(user.getName(), car.getBrand() + " " + car.getModel());
            System.out.println("Назначаем пользователя: " + user.getName() + " на машину: " + car.getBrand() + " " + car.getModel());
        }

        return "redirect:/selection";
    }
}
