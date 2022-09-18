package com.geektrust.courseschedule.factory;

import com.geektrust.courseschedule.pojo.AddCourseOutput;
import com.geektrust.courseschedule.pojo.AddCourseParameter;
import com.geektrust.courseschedule.pojo.Course;
import com.geektrust.courseschedule.pojo.Data;

import java.util.ArrayList;

public class AddCourse{
    public void addCourse(AddCourseParameter parameter) {
        String courseOfferingId = "OFFERING-"+parameter.getCourseName()+"-"+parameter.getInstructor();
        Course course = Course.builder().courseName(parameter.getCourseName()).instructor(parameter.getInstructor())
                        .date(parameter.getDate()).minEmployees(parameter.getMinEmployees()).maxEmployees(parameter.getMaxEmployees())
                        .employees(new ArrayList<>())
                        .courseOfferingId(courseOfferingId).build();
        Data.courseHashMap.putIfAbsent(courseOfferingId,course);
        AddCourseOutput addCourseOutput = AddCourseOutput.builder().courseOfferingId(courseOfferingId).build();
        System.out.println(addCourseOutput.toString());
    }
}
