package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String carsInList(
            @RequestParam(value = "count", required = false, defaultValue = "100") int count,
            Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford Fucus", 2004, "Black"));
        cars.add(new Car("BMW M5", 2005, "White"));
        cars.add(new Car("Audi A4", 2006, "Yellow"));
        cars.add(new Car("Mercedes Benz GLE", 2007, "Green"));
        cars.add(new Car("Ferrari F1", 2008, "Red"));
        List<Car> subList = cars.subList(0, Math.min(count, cars.size()));
        model.addAttribute("cars", subList);
        return "carsList";
    }

}
