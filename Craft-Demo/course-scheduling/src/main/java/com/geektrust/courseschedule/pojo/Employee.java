package com.geektrust.courseschedule.pojo;

import com.geektrust.courseschedule.enums.AllotmentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String courseOfferingId;
    private String courseRegistrationId;
    private String email;
    private String employeeName;
    private AllotmentStatus allotmentStatus;
}
