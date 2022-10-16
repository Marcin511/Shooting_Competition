package com.shootingarea.application.results;

import com.shootingarea.application.users.User;
import com.shootingarea.application.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping
public class ResultController {
    @Autowired
    private final ResultService resultService;
    private final UserService userService;


    public ResultController(ResultService resultService,UserService userService) {
        this.resultService = resultService;
        this.userService = userService;
    }

    @PostMapping("/score")
    public Result addResult(@RequestBody Result result){
        return resultService.addResult(result);
    }
    @GetMapping("/result/{id}/results")
    public List<Result> showResults(@PathVariable Long id){
       return resultService.getResultsByUserId(id);
    }
    @GetMapping("/showall")
    public List<Result> showAllResults(){
        return resultService.getAllResults();
    }


}
