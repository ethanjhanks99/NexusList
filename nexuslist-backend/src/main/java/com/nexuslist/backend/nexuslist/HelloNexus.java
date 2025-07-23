package com.nexuslist.backend.nexuslist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloNexus {

    @GetMapping("/")
    public String index() {
        return "Hello Nexus";
    }
}
