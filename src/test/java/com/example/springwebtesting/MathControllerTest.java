package com.example.springwebtesting;


import com.example.springwebtesting.controllers.MathController;
import com.example.springwebtesting.services.GreetingService;
import com.example.springwebtesting.services.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(MathController.class)
public class MathControllerTest {

//    In your spring-playground application, create an endpoint that:
//
//    takes a GET request to /math/pi
//    renders the string 3.141592653589793
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathService service;

    @Test
    public void get_math_pi_returns_pi() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        when(service.getPi()).thenReturn(Double.valueOf("3.141592653589793"));
        try {
            this.mockMvc.perform(request).andExpect(content().string("3.141592653589793"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_calculate_add_returns_sum() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=4&y=6");
        when(service.add(4, 6)).thenReturn(10);
        try {
            this.mockMvc.perform(request).andExpect(content().string("10"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_calculate_subtract_returns_difference() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtract&x=4&y=6");
        when(service.subtract(4, 6)).thenReturn(-2);
        try {
            this.mockMvc.perform(request).andExpect(content().string("-2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_calculate_divide_returns_quotient() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=30&y=5");
        when(service.divide(30, 5)).thenReturn(6);
        try {
            this.mockMvc.perform(request).andExpect(content().string("6"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_calculate_multiple_returns_product() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=4&y=6");
        when(service.multiply(4, 6)).thenReturn(24);
        try {
            this.mockMvc.perform(request).andExpect(content().string("24"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_calculate_no_operation_returns_sum() {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5");
        when(service.add(30, 5)).thenReturn(35);
        try {
            this.mockMvc.perform(request).andExpect(content().string("35"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_sum_returns_sum_string() {
        // #2 - /math/sum
        //Create an endpoint that takes POST requests to /math/sum and passes multiple parameters n:
//        Examples
//                /math/sum?n=4&n=5&n=6 should render the string 4 + 5 + 6 = 15

        MultiValueMap<String, String> mockQueryMap = new LinkedMultiValueMap<String, String>();
        mockQueryMap.add("n", "4");
        mockQueryMap.add("n", "5");
        mockQueryMap.add("n", "6");
        System.out.println("mockmap =" + mockQueryMap);
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");
        when(service.sum(mockQueryMap)).thenReturn("4 + 5 + 6 = 15");
        try {
            this.mockMvc.perform(request).andExpect(content().string("4 + 5 + 6 = 15"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_volume_returns_volume_string() {

//        POST /math/volume/3/4/5 should render the result The volume of a 3x4x5 rectangle is 60x
//        PATCH /math/volume/6/7/8 should render the result The volume of a 6x7x8 rectangle is 336
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");
        when(service.volume(3,4,5)).thenReturn("The volume of a 3x4x5 rectangle is 60");
        try {
            this.mockMvc.perform(request).andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get_math_area_returns_area_string() {

        RequestBuilder request = MockMvcRequestBuilders.post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "4");

        when(service.areaCir(4)).thenReturn("The volume of a 3x4x5 rectangle is 60");
        try {
            this.mockMvc.perform(request).andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
