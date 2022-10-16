package com.shootingarea.application.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping
public class ResultController {
    @Autowired
    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @PostMapping("/score")
    public Result addResult(@RequestBody Result result){
        return resultService.addResult(result);
    }
    @GetMapping("/result")
    public List<Result> showResults(){
       return resultService.getAllResults();

    }


}
