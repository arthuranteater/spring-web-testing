package com.example.springwebtesting.services;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
public class MathService {

    private double pi = 3.141592653589793;

    public double getPi() {
        return pi;
    }

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

    public String sum(MultiValueMap<String, String> queryMap) {
        List<String> nums = queryMap.get("n");
        Integer sum = 0;
        StringBuilder str = new StringBuilder();
        for (String num : nums) {
            sum += Integer.parseInt(num);
            str.append(num).append(" + ");
        }
        System.out.println(str.deleteCharAt(str.length() - 1).toString() + "=" + sum.toString());
        return str.deleteCharAt(str.length() - 1).toString() + "= " + sum.toString();
    }

    public String volume(Integer l, Integer w, Integer h) {
        Integer product = l * w * h;
        return String.format("The volume of a %dx%dx%d rectangle is %d", l, w, h, product);
    }

    public String areaCir(Integer radius) {
        double area = radius * radius * getPi();
        return String.format("Area of a circle with a radius of %d is %s", radius, String.valueOf(area));
    }

    public String areaRec(Integer width, Integer height) {
        double area = width * height;
        return String.format("Area of a %dx%d rectangle is %d", width, height, area);

    }
}
