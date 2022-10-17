package com.shootingarea.application.results;

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

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

     Result addResult(@RequestBody Result result){
        return resultRepository.save(result);
    }

    public List<Result> getResultsByUserId(Long id) {

        return (List<Result>) resultRepository.findResultByUserId(id).orElseThrow(()->new NoSuchElementException("element dont exist"));
         }

    List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
