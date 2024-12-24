package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cars"; // cars.html
    }

    @PostMapping("/add")
    public String addCar(@RequestParam String modelCar,
                         @RequestParam String brand,
                         @RequestParam int year) {
        carService.addCar(new Car(modelCar, brand, year));
        return "redirect:/cars";
    }
}
