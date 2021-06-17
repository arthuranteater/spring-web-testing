package com.example.springwebtesting.controllers;
import com.example.springwebtesting.services.MathService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService service;

    public MathController(MathService service) {
        this.service = service;
    }

    @GetMapping("/pi")
    public @ResponseBody
    String pi() {
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public @ResponseBody
    String calculate(@RequestParam(required = false) String operation, @RequestParam String x, @RequestParam String y ) {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        if (operation != null) {
            switch(operation) {
                case "subtract":
                    return service.subtract(a,b).toString();
                case "multiply":
                    return service.multiply(a,b).toString();
                case "divide":
                    return service.divide(a,b).toString();
                default:
                    return service.add(a,b).toString();
            }
        }
        return service.add(a,b).toString();
    }

    @PostMapping("/sum")
    public @ResponseBody
    String sum(@RequestParam MultiValueMap<String, String> queryMap) {
        return service.sum(queryMap);
    }


}
