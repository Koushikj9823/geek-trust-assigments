package com.geektrust.courseschedule.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CancelCourseParameter implements Parameter{
    private String courseRegistrationId;
}
