package com.test.buttons.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
    @Override
    public String sayHello() {
        return "Hello, I am Mastermind Service";
    }
}
