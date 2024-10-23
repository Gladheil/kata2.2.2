package web.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import web.models.Car;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<Car>();
    {
        cars.add(new Car("Ford Fucus", 2004, "Black"));
        cars.add(new Car("BMW M5", 2005, "White"));
        cars.add(new Car("Audi A4", 2006, "Yellow"));
        cars.add(new Car("Mercedes Benz GLE", 2007, "Green"));
        cars.add(new Car("Ferrari F1", 2008, "Red"));
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getAllCars(int value) {
        return (value >= cars.size()) ? cars : cars.subList(0, value);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }
}
