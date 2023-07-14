package com.shootingarea.application.results;

import com.shootingarea.application.users.User;
import com.shootingarea.application.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class ResultService {
    @Autowired
    private final ResultRepository resultRepository;
    private final UserRepository userRepository;

    public ResultService(ResultRepository resultRepository,UserRepository userRepository) {
        this.resultRepository = resultRepository;
        this.userRepository= userRepository;
    }

     Result addResult(Result result){
        User userFromRepo = userRepository.findUserById(result.getUser().getId()).orElseThrow(()-> new NoSuchElementException("User not exist"));
        return resultRepository.save(result);
    }

    public List<Result> getResultsByUserId(Long id) {

        return (List<Result>) resultRepository.findResultByUserId(id);
         }

    List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
