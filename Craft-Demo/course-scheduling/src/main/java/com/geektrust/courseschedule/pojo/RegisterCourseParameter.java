package com.geektrust.courseschedule.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterCourseParameter implements Parameter{
    private String email;
    private String courseOfferingId;
}
