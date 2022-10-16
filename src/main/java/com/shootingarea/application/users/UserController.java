package com.shootingarea.application.users;


import com.shootingarea.application.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping
public class UserController {
    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest registerRequest){
        userService.addUser(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    List<User> getAll(){
        return userService.getUsers();
    }
    @GetMapping("/view/{id}")
    User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @DeleteMapping("/user/{id}")
    User removeUser(@PathVariable Long id){
     return  userService.deleteUser(id);
    }
    @PutMapping("/user/{id}")
    User update(@PathVariable Long id,@RequestBody User user){
        return userService.updateUser(id, user);
    }
    @PostMapping("/login")
    User login (@RequestBody User user){
       return user;
    }

    }


