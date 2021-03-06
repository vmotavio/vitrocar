package br.com.vitrocar.controller;

import br.com.vitrocar.model.Car;
import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.CarRepository;
import br.com.vitrocar.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/car")
@CrossOrigin
public class CarController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    public CarController (CarRepository carRepository, UserRepository userRepository){
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Car>> getAll(){
        var cars = carRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Car::getName))
                .collect(Collectors.toList());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Range",
                "posts 0-"+carRepository.findAll().size()+"/"+carRepository.findAll().size());
        return (ResponseEntity<List<Car>>) ResponseEntity.ok()
                .headers(responseHeaders)
                .body(cars);
    }

    public List<Car> findAllByUser(@RequestBody User user){
        var cars = carRepository.findByUser(user)
                .stream()
                .sorted(Comparator.comparing(Car::getName))
                .collect(Collectors.toList());;
        return cars;
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable("id") Long id){
        var car = carRepository.getById(id);
        return car;
    }

    @PostMapping("")
    public void save(@RequestBody Car car, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).orElse(null);
        car.setUser(user);
        carRepository.save(car);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id , @RequestBody Car car, Authentication authentication) {
        var oldCar= carRepository.getById(id);
        var user = userRepository.findByUsername(authentication.getName()).orElse(null);
        oldCar.setBrand(car.getBrand());
        oldCar.setModel(car.getModel());
        oldCar.setName(car.getName());
        oldCar.setUser(user);
        carRepository.save(car);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        carRepository.delete(carRepository.getById(id));
    }
}
