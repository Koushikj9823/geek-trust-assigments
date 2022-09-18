package com.geektrust.courseschedule;

import com.geektrust.courseschedule.enums.CommandType;
import com.geektrust.courseschedule.exception.InputDataErrorException;
import com.geektrust.courseschedule.factory.AddCourse;
import com.geektrust.courseschedule.factory.AllotCourse;
import com.geektrust.courseschedule.factory.CancelCourse;
import com.geektrust.courseschedule.factory.RegisterCourse;
import com.geektrust.courseschedule.pojo.AddCourseParameter;
import com.geektrust.courseschedule.pojo.AllotCourseParameter;
import com.geektrust.courseschedule.pojo.CancelCourseParameter;
import com.geektrust.courseschedule.pojo.RegisterCourseParameter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CourseSchedule {
    public static void main(String[] args) throws FileNotFoundException, InputDataErrorException {
        File myObj = new File(args[0]);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] inputCommandWithParams = data.split(" ");
            String command = inputCommandWithParams[0];
            if (command.equals(CommandType.ADD_COURSE_OFFERING.getValue())) {
                try {
                    AddCourse addCourse = new AddCourse();
                    DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("ddMMyyyy");
                    DateTime dateTime = FORMATTER.parseDateTime(inputCommandWithParams[3]);
                    LocalDate localDate = LocalDate.parse(dateTime.toLocalDate().toString());
                    AddCourseParameter addCourseParameter = AddCourseParameter.builder().courseName(inputCommandWithParams[1]).instructor(inputCommandWithParams[2])
                            .date(localDate).minEmployees(Integer.parseInt(inputCommandWithParams[4])).
                                    maxEmployees(Integer.parseInt(inputCommandWithParams[5])).build();
                    addCourse.addCourse(addCourseParameter);
                } catch (Exception inputDataErrorException) {
                    System.out.println("INPUT_DATA_ERROR");
//                    throw new InputDataErrorException("Invalid Data \n"+inputDataErrorException,inputDataErrorException);
                }
            } else if (command.equals(CommandType.ALLOT_COURSE.getValue())) {
                try {
                    AllotCourse allotCourse = new AllotCourse();
                    AllotCourseParameter allotCourseParameter = AllotCourseParameter.builder().courseOfferingId(inputCommandWithParams[1]).build();
                    allotCourse.allotCourse(allotCourseParameter);
                } catch (Exception inputDataErrorException) {
                    System.out.println("INPUT_DATA_ERROR");
//                    throw new InputDataErrorException("Invalid Data \n"+inputDataErrorException,inputDataErrorException);
                }
            } else if (command.equals(CommandType.REGISTER.getValue())) {
                try {
                    RegisterCourse registerCourse = new RegisterCourse();
                    RegisterCourseParameter registerCourseParameter = RegisterCourseParameter.builder().email(inputCommandWithParams[1]).courseOfferingId(inputCommandWithParams[2]).build();
                    registerCourse.registerCourse(registerCourseParameter);
                } catch (Exception inputDataErrorException) {
                    System.out.println("INPUT_DATA_ERROR");
//                    throw new InputDataErrorException("Invalid Data \n"+inputDataErrorException,inputDataErrorException);
                }
            } else if (command.equals(CommandType.CANCEL.getValue())) {
                try {
                    CancelCourse cancelCourse = new CancelCourse();
                    CancelCourseParameter cancelCourseParameter = CancelCourseParameter.builder().courseRegistrationId(inputCommandWithParams[1]).build();
                    cancelCourse.cancelCourse(cancelCourseParameter);
                } catch (Exception inputDataErrorException) {
                    System.out.println("INPUT_DATA_ERROR");
//                    throw new InputDataErrorException("Invalid Data \n"+inputDataErrorException,inputDataErrorException);
                }
            }
        }
    }
}
