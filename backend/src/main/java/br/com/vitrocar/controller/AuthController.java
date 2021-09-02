package br.com.vitrocar.controller;

import br.com.vitrocar.model.User;
import br.com.vitrocar.repository.UserRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository userRepository, PasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @RequestMapping( value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public ResponseEntity<Boolean> login(@RequestParam String username,
                                         @RequestParam String password) {

        Optional<User> optUser = userRepository.findByUsername(username);
        if (optUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optUser.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }
}
