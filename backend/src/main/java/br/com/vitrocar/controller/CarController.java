package br.com.vitrocar.controller;

import br.com.vitrocar.model.Car;
import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarRepository carRepository;

    public CarController (CarRepository carRepository){this.carRepository = carRepository;}

    @GetMapping("/")
    public List<Car> findAllCars(){
        var cars = carRepository.findAll();
        return cars;
    }

    @GetMapping
    public List<Car> findAllByUser(@RequestBody User user){
        var cars = carRepository.findByUser(user);
        return cars;
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") Long id){
        var car = carRepository.getById(id);
        return car;
    }

    @PostMapping("/")
    public void save(@RequestBody Car car){
        carRepository.save(car);
    }

    @PutMapping
    public String update(@RequestBody Car car) {
        return "";
    }


    public String delete(@PathVariable long id) {
        return "";
    }


}
