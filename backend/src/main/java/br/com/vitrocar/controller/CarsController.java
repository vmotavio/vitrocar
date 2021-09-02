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
@RequestMapping("/api/v1/allcars")
@CrossOrigin
public class CarsController {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    public CarsController (CarRepository carRepository, UserRepository userRepository){
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

}
