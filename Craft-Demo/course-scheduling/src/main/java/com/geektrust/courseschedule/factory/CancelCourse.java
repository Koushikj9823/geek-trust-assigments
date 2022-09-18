package com.geektrust.courseschedule.factory;

import com.geektrust.courseschedule.enums.AllotmentStatus;
import com.geektrust.courseschedule.enums.CancelStatus;
import com.geektrust.courseschedule.pojo.CancelCourseParameter;
import com.geektrust.courseschedule.pojo.Course;
import com.geektrust.courseschedule.pojo.Data;
import com.geektrust.courseschedule.pojo.Employee;

import java.util.stream.Collectors;

public class CancelCourse{

    public void cancelCourse(CancelCourseParameter parameter) {
        String courseRegistrationId = parameter.getCourseRegistrationId();
        Employee employee = Data.employeeHashMap.getOrDefault(courseRegistrationId,null);
        if(employee==null){
            System.out.println("EMPLOYEE_NOT_FOUND");
//            String message = "Employee with course registration id"+courseRegistrationId+" not found";
//            throw new EmployeeNotFoundException(message);
        }
        else if(employee.getAllotmentStatus().equals(AllotmentStatus.CONFIRMED)){
            System.out.println(courseRegistrationId+" "+CancelStatus.CANCEL_REJECTED);
//            String message = "Employee "+employee.getEmployeeName()+" with course registration id"+courseRegistrationId+" already allotted";
//            throw new InvalidCourseCancelRequestException(message);
        }
        else{
            Course course = Data.courseHashMap.get(employee.getCourseOfferingId());
            course.setEmployees(course.getEmployees().stream().
                    filter(employee1 -> !employee1.getCourseRegistrationId().equals(employee.getCourseRegistrationId())).
                    collect(Collectors.toList()));
            System.out.println(courseRegistrationId+" "+CancelStatus.CANCEL_ACCEPTED);
        }
    }
}
