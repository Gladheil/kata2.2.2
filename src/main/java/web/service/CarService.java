package web.service;

import java.util.List;
import web.models.Car;

public interface CarService {
    List<Car> getAllCars();
    List<Car> getAllCars(int value);
    void addCar(Car car);
}
