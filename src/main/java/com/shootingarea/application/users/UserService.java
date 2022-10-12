package com.shootingarea.application.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    User addUser(User user){
        return userRepository.save(user);
    }
    List<User> getUsers(){
        return userRepository.findAll();
    }
    User deleteUser(String name){
        User user = userRepository.findByName(name)
                .orElseThrow(()->new NoSuchElementException("user dosen't exist"));
        userRepository.deleteByName(name);
        return user;
    }
    User updateUser(String name, User user) {
        User userToUpdate = userRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("user dosen't exist"));
        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if (user.getEmail() != null && !user.getEmail().equals(user.getEmail())) {
            userRepository.findByName(user.getEmail()).ifPresent(u -> {
                throw new IllegalArgumentException("Email alredy exist");
            });
        }
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        return userRepository.save(userToUpdate);
    }

}
