package com.example.springwebtesting.data;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {

    private String departs;

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

    private List<Ticket> tickets;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTicketList(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Flight(List<Ticket> tickets) {
        this(null, tickets);
    }

    public Flight(String departs, List<Ticket> tickets) {
        this.setDeparts(departs);
        this.setTicketList(tickets);
    }

    static public class Ticket {

        private Passenger passenger;

        private Integer price;

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Ticket(Integer price, Passenger passenger) {
            this.setPrice(price);
            this.setPassenger(passenger);
        }

        static public class Passenger {

            private String firstName;
            private String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public Passenger(String firstName) {
                this(firstName, null);
            }

            public Passenger(String firstName, String lastName) {
                this.setFirstName(firstName);
                this.setLastName(lastName);
            }



        }

    }

}
