package com.geektrust.courseschedule.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class AddCourseParameter implements Parameter{
    private String courseName;
    private String instructor;
    private LocalDate date;
    private int minEmployees;
    private int maxEmployees;

    @Override
    public String toString() {
        return "courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", date=" + date +
                ", minEmployees=" + minEmployees +
                ", maxEmployees=" + maxEmployees;
    }
}
