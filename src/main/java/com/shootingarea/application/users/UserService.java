package com.shootingarea.application.users;




import com.shootingarea.application.dto.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class UserService {
    private final UserRepository userRepository;    //wstrzykiwanie repozytorium użytkownika

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Autowired
    PasswordEncoder passwordEncoder;                //wstrzykiwanie enkodera haseł
   


    User addUser(User user){
        return userRepository.save(user);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


    List<User> getUsers(){                  //pobieranie wszystkich użytkowników
        return userRepository.findAll();
    }
    public User getUser(Long id){           //pobieranie użytkownika po jego id
        User user = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("user isn't exist"));
        return user;
    }
    User deleteUser(Long id){               // usuwanie użytkownika po id i sprawdzenie czy istnieje
        User user = userRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("user isn't exist"));
        userRepository.deleteById(id);
        return user;
    }
    User updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {
        //uodate użytkownika i sprawdzenie czy ok istnieje
        return userRepository.findById(id).map(user->{
            user.setName(userToUpdate.getName());
            user.setEmail(userToUpdate.getEmail());
            user.setPassword(userToUpdate.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NoSuchElementException("User isn,t exist"));
    }

}
