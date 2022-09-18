package com.geektrust.courseschedule.pojo;

import com.geektrust.courseschedule.enums.AllotmentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class AllotCourseOutput {
    private String courseRegistrationId;
    private String email;
    private String courseOfferingId;
    private String courseName;
    private String instructor;
    private LocalDate date;
    private AllotmentStatus allotmentStatus;

    @Override
    public String toString() {
        return courseRegistrationId +" "+email+" "+courseOfferingId+" "+courseName+" "+instructor+" "+date+" "+allotmentStatus;
    }
}
