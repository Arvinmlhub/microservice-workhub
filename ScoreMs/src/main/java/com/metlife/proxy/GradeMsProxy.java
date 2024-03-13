package com.metlife.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GradeMs", url = "http://localhost:8080")
public interface GradeMsProxy {
    @GetMapping("/grade")
    Double getAllGread();
}
