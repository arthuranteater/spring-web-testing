package com.example.springwebtesting.services;

import com.example.springwebtesting.data.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightsService {
    public Flight getFlight() {
        Flight.Ticket.Passenger passenger = new Flight.Ticket.Passenger("Some name", "Some other name");
        Flight.Ticket ticket = new Flight.Ticket(200, passenger);
        List<Flight.Ticket> ticketList = new ArrayList<Flight.Ticket>(List.of(ticket));
        Flight flight = new Flight("2017-04-21 14:34", ticketList);
        return flight;
    }

    //    {
//        "departs": "2017-04-21 14:34",
//            "tickets": [
//        {
//            "passenger": {
//            "firstName": "Some name",
//                    "lastName": "Some other name"
//        },
//            "price": 200
//        }
//  ]
//    }


}
