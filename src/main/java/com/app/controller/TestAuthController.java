package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
//@PreAuthorize("denyAll()") // Por defecto no va pasar nadie
public class TestAuthController {

    @GetMapping("/get")
//    @PreAuthorize("hasAuthority('READ')")
    public String helloGet(){
        return "Hello world - GET";
    }

    @PostMapping("/post")
//    @PreAuthorize("hasAuthority('CREATE')or hasAuthority('READ')")
    public String helloPost(){
        return "Hello world- POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello world -  PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello world - DELETE";
    }

    @PatchMapping("/patch")
//    @PreAuthorize("hasAuthority('REFACTOR')")
    public String helloPatch(){
        return "Hello world - PATCH";
    }

}
