package com.metlife;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {


    @GetMapping("/grade")
    public Double getAllGread(){
        return 0.2;
    }

}
