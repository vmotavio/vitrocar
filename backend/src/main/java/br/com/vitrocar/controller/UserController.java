package br.com.vitrocar.controller;

import br.com.vitrocar.model.Car;
import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.UserRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserController(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        var users = userRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(User::getUsername))
                .collect(Collectors.toList());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Range",
                "posts 0-"+userRepository.findAll().size()+"/"+userRepository.findAll().size());
        return (ResponseEntity<List<User>>) ResponseEntity.ok()
                .headers(responseHeaders)
                .body(users);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        var user = userRepository.getById(id);
        return user;
    }

    @PostMapping("")
    public void save(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
