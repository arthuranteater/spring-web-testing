package com.example.springwebtesting.controllers;
import com.example.springwebtesting.services.MathService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Map;

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
        return String.valueOf(service.getPi());
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

    @PostMapping("/volume/{length}/{width}/{height}")
    public @ResponseBody
    String volume(@PathVariable Integer length, @PathVariable Integer width, @PathVariable Integer height) {
        return service.volume(length, width, height);
    }

    @PatchMapping("/volume/{length}/{width}/{height}")
    public @ResponseBody
    String patchVolume(@PathVariable Integer length, @PathVariable Integer width, @PathVariable Integer height) {
        return service.volume(length, width, height);
    }


    @PostMapping("/area")
    public @ResponseBody
    String volume(@RequestParam Map<String, String> formData) {
        String type = formData.get("type");
        if (type.equals("circle") && formData.get("radius") != null) {
            return service.areaCir(Integer.parseInt(formData.get("radius")));
        } else if (type.equals("rectangle") && formData.get("width") != null && formData.get("width") != null) {
            return service.areaRec(Integer.parseInt(formData.get("width")), Integer.parseInt(formData.get("height")));
        } else {
            return "Invalid";
        }
    }


}
