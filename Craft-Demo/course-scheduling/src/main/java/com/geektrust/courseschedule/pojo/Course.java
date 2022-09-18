package com.geektrust.courseschedule.pojo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Course {
    private String courseOfferingId;
    private String courseName;
    private String instructor;
    private LocalDate date;
    private int minEmployees;
    private int maxEmployees;
    private List<Employee> employees = new ArrayList<>();
}
