package com.example.springwebtesting.controllers;

import com.example.springwebtesting.data.Flight;
import com.example.springwebtesting.services.FlightsService;
import com.example.springwebtesting.services.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightsController {


   // Takes a GET request to /flights/flight
   private final FlightsService service;

    public FlightsController(FlightsService service) {
        this.service = service;
    }

//    @GetMapping("/")
//    public @ResponseBody
//        // returns all flights in JSON automatically using Jackson
//    String getAll() {
//        return service.getflights();
//    }

    @GetMapping("/flight")
    public @ResponseBody
    // returns single flight in JSON automatically using Jackson
    Flight getOne() {
        return service.getFlight();
    }





}
