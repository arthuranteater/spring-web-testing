package com.example.springwebtesting;

import com.example.springwebtesting.controllers.FlightsController;
import com.example.springwebtesting.controllers.MathController;
import com.example.springwebtesting.data.Flight;
import com.example.springwebtesting.services.FlightsService;
import com.example.springwebtesting.services.MathService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightsController.class)
public class FlightsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightsService mockedFlightsService;

    //helper, not working google it
    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

    @Test
    public void get_flight_returns_flight_json() throws Exception {

//        ------ Manually create JSON string ------

//        HashMap<String, Object> data = new HashMap<String, Object>(){
//            {
//                put("name", "Hercules");
//                put("age", 57);
//            }
//        };
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = objectMapper.writeValueAsString(data);

//        String json = getJSON("/data/flight-data.json");

        RequestBuilder request = MockMvcRequestBuilders.get("/flights/flight")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"departs\":\"2017-04-21 14:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Some name\",\"lastName\":\"Some other name\"},\"price\":200}]}");

        //create return value for getFlight
        Flight.Ticket.Passenger passenger = new Flight.Ticket.Passenger("Some name", "Some other name");
        Flight.Ticket ticket = new Flight.Ticket(200, passenger);
        List<Flight.Ticket> ticketList = new ArrayList<Flight.Ticket>(List.of(ticket));
        Flight flight = new Flight("2017-04-21 14:34", ticketList);

        when(mockedFlightsService.getFlight()).thenReturn(flight);
        this.mockMvc.perform(request).andExpect(status().isOk())
                    .andExpect(content().string("{\"departs\":\"2017-04-21 14:34\",\"tickets\":[{\"passenger\":{\"firstName\":\"Some name\",\"lastName\":\"Some other name\"},\"price\":200}]}"));
    }

}
