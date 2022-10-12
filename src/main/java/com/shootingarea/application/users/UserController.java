package com.shootingarea.application.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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
    @DeleteMapping("/{name}")
    User removeUser(@PathVariable String name){
     return  userService.deleteUser(name);
    }
    @PutMapping("/{name}")
    User update(@PathVariable String name, User user){
        return userService.updateUser(name, user);
    }

}
