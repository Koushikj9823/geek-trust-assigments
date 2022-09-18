package com.geektrust.courseschedule.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
public class AddCourseOutput {
    private String courseOfferingId;

    @Override
    public String toString() {
        return courseOfferingId;
    }
}
