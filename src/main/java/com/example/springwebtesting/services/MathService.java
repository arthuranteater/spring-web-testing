package com.example.springwebtesting.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public MathService() {
    }

    public Integer add(Integer x, Integer y) {
        return x + y;
    }

    public Integer subtract(Integer x, Integer y) {
        return x - y;
    }

    public Integer divide(Integer x, Integer y) {
        return x / y;
    }

    public Integer multiply(Integer x, Integer y) {
        return x * y;
    }
}
