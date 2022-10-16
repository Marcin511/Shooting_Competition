package com.shootingarea.application.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


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
        List<Result> results = new ArrayList<>();
        resultRepository.findByUserId(id).forEach(results::add);
        return results;
         }

    List<Result> getAllResults() {
        return resultRepository.findAll();
    }
}
