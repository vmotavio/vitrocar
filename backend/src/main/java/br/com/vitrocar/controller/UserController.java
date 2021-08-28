package br.com.vitrocar.controller;

import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> findAll(){
        var users = userRepository.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        var user = userRepository.getById(id);
        return user;
    }

    @PostMapping("/")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

}
