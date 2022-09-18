package com.geektrust.courseschedule.factory;

import com.geektrust.courseschedule.enums.AllotmentStatus;
import com.geektrust.courseschedule.enums.RegistrationStatus;
import com.geektrust.courseschedule.pojo.*;

import java.time.LocalDate;
import java.util.Objects;

public class RegisterCourse {
    public void registerCourse(RegisterCourseParameter parameter) {
        Course course = Data.courseHashMap.getOrDefault(parameter.getCourseOfferingId(), null);
        if (Objects.isNull(course)) {
            String message = "Course Not found for course id: " + parameter.getCourseOfferingId();
            System.out.println(message);
            return;
//            throw new CourseNotFoundException(message);
        }
        if (course.getEmployees()!=null && course.getEmployees().size() == course.getMaxEmployees()) {
            String message = "COURSE_FULL_ERROR";
            System.out.println(message);
            return;
//            throw new CourseFullException(message);
        }
        if (course.getDate().compareTo(LocalDate.now()) > 0) {
            String message = "COURSE_CANCELED";
            System.out.println(message);
            return;
//            throw new CourseCancelledException(message);
        }
        String employeeName = parameter.getEmail().replaceAll("@.*", "").replaceAll("[^a-zA-Z]+", " ").trim();
        String courseRegistrationId = "REG-COURSE-" + employeeName + "-" + course.getCourseName();
        Employee employee = new Employee();
        employee.setEmail(parameter.getEmail());
        employee.setEmployeeName(employeeName);
        employee.setAllotmentStatus(AllotmentStatus.NOT_CONFIRMED);
        employee.setCourseRegistrationId(courseRegistrationId);
        employee.setCourseOfferingId(parameter.getCourseOfferingId());
        course.getEmployees().add(employee);

        Data.employeeHashMap.putIfAbsent(courseRegistrationId, employee);
        RegisterCourseOutput registerCourseOutput = RegisterCourseOutput.builder().courseRegistrationId(courseRegistrationId).registrationStatus(RegistrationStatus.ACCEPTED).build();
        System.out.println(registerCourseOutput.toString());
    }
}
