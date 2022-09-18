package com.geektrust.courseschedule.factory;

import com.geektrust.courseschedule.enums.AllotmentStatus;
import com.geektrust.courseschedule.exception.CourseNotFoundException;
import com.geektrust.courseschedule.pojo.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AllotCourse {
    public void allotCourse(AllotCourseParameter parameter) {
        Course course = Data.courseHashMap.getOrDefault(parameter.getCourseOfferingId(),null);
        if(course==null){
            String message = "Course Not found for course id: " + parameter.getCourseOfferingId();
            throw new CourseNotFoundException(message);
        }
        List<Employee> employees = course.getEmployees();
        employees = employees.stream().sorted(Comparator.comparing(Employee::getCourseRegistrationId)).collect(Collectors.toList());
        employees.forEach(employee -> {
            if(employee.getAllotmentStatus().equals(AllotmentStatus.NOT_CONFIRMED)){
                employee.setAllotmentStatus(AllotmentStatus.CONFIRMED);
            }
            AllotCourseOutput allotCourseOutput = AllotCourseOutput.builder().courseName(course.getCourseName())
                                                    .email(employee.getEmail()).courseRegistrationId(employee.getCourseRegistrationId())
                                                    .date(course.getDate()).instructor(course.getInstructor())
                                                    .courseOfferingId(employee.getCourseOfferingId())
                                                    .allotmentStatus(employee.getAllotmentStatus()).build();
            System.out.println(allotCourseOutput.toString());
        });
    }
}
