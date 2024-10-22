package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.models.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carsInList(
            @RequestParam(value = "count", required = false, defaultValue = "100") int count,
            Model model) {
        carService.addCar(new Car("Ford Fucus", 2004, "Black"));
        carService.addCar(new Car("BMW M5", 2005, "White"));
        carService.addCar(new Car("Audi A4", 2006, "Yellow"));
        carService.addCar(new Car("Mercedes Benz GLE", 2007, "Green"));
        carService.addCar(new Car("Ferrari F1", 2008, "Red"));
        List<Car> cars = carService.getAllCars();
        List<Car> subList = cars.subList(0, Math.min(count, cars.size()));
        model.addAttribute("cars", subList);
        return "carsList";
    }

}
