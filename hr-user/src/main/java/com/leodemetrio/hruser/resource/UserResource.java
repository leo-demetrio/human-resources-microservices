package com.leodemetrio.hruser.resource;

import com.leodemetrio.hruser.entities.User;
import com.leodemetrio.hruser.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        User obj = userRepository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}
