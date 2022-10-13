package com.shootingarea.application.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    User getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("usst dosn't exist"));
        return user;
    }
    User deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("user dosn't exist"));
        userRepository.deleteById(id);
        return user;
    }
    User updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {

        return userRepository.findById(id).map(user->{
            user.setName(userToUpdate.getName());
            user.setEmail(userToUpdate.getEmail());
            user.setPassword(userToUpdate.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NoSuchElementException("User isn,t exist"));
    }

}
