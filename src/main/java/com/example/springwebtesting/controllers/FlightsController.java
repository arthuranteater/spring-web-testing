package com.example.springwebtesting.controllers;

import com.example.springwebtesting.data.Flight;
import com.example.springwebtesting.services.FlightsService;
import com.example.springwebtesting.services.GreetingService;
import com.example.springwebtesting.services.MathService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightsController {

   private final FlightsService flightsService;

   private final MathService mathService;

    public FlightsController(FlightsService flightsService, MathService mathService) {
        this.mathService = mathService;
        this.flightsService = flightsService;
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
    Flight getFlight() {
        return flightsService.getFlight();
    }

    @PostMapping("/tickets/total")
    public @ResponseBody
    HashMap totalPrice(@RequestBody Flight flight) {
        Integer count = 0;
        for(Flight.Ticket ticket : flight.getTickets()) {
            count = mathService.add(count, ticket.getPrice());
        }
        Integer total = count;
        HashMap<String, Object> jsonRes = new HashMap<String, Object>(){
            {
                put("result", total);
            }
        };
        System.out.println(jsonRes);
        return jsonRes;
    }






}
