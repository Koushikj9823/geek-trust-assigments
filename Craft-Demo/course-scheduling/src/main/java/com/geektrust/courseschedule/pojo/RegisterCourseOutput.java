package com.geektrust.courseschedule.pojo;

import com.geektrust.courseschedule.enums.RegistrationStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterCourseOutput {
    private String courseRegistrationId;
    private RegistrationStatus registrationStatus;

    @Override
    public String toString() {
        return courseRegistrationId +" "+registrationStatus;
    }
}
