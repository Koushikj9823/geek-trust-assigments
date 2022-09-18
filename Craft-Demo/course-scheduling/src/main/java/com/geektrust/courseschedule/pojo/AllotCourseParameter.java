package com.geektrust.courseschedule.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AllotCourseParameter implements Parameter{
    private String courseOfferingId;
}
