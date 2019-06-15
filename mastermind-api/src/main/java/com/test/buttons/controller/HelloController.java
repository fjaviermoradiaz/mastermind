package com.test.buttons.controller;

import com.test.buttons.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/mastermind")
public class HelloController {


    @Autowired
    private HelloService helloService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(helloService.sayHello(), HttpStatus.OK);
    }
}
