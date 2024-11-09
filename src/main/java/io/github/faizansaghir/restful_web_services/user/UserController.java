package io.github.faizansaghir.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id){
        return service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        service.save(user);
        return ResponseEntity.created(null).build();
    }
}
