package com.example.springwebtesting.controllers;
import com.example.springwebtesting.services.MathService;
import org.springframework.web.bind.annotation.*;

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


}
