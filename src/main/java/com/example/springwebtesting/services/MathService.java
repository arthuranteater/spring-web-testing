package com.example.springwebtesting.services;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

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
}
