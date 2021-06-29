package com.example.springwebtesting.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    private Integer start_year;
    private boolean has_clearance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStart_year() {
        return start_year;
    }

    public void setStart_year(Integer start_year) {
        this.start_year = start_year;
    }

    public boolean isHas_clearance() {
        return has_clearance;
    }

    public void setHas_clearance(boolean has_clearance) {
        this.has_clearance = has_clearance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    ////    @Column(columnDefinition = "date")
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date deliveredOn;

//    public Date getDeliveredOn() {
//        return deliveredOn;
//    }
//
//    public void setDeliveredOn(Date deliveredOn) {
//        this.deliveredOn = deliveredOn;
//    }
}


