package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> carList = new ArrayList<>();

    public CarService() {
        carList.add(new Car("Ford", "Focus", 2021));
        carList.add(new Car("Toyota", "Corolla", 2020));
        carList.add(new Car("Honda", "Civic", 2022));
    }

    public List<Car> getAllCars() {
        return carList;
    }

    public Car getCarById(Long id) {
        return null;
    }

    public void addCar(Car car) {
        carList.add(car);
    }
}
