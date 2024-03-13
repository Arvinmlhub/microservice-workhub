package com.metlife.controller;

import com.metlife.ScoreMsApplication;
import com.metlife.proxy.GradeMsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final GradeMsProxy gradeMsProxy;

    @Autowired
    public ScoreController(GradeMsProxy gradeMsProxy1) {
        this.gradeMsProxy = gradeMsProxy1;
    }




    @GetMapping
    public String getGrad(){
        return "Your Grade is "+ gradeMsProxy.getAllGread();
    }
}
