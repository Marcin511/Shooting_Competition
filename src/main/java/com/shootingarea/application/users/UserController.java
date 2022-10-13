package com.shootingarea.application.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.addUser(user);
    }
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return user;
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

}
