package web.models;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();
    void addCar(Car car);
}
