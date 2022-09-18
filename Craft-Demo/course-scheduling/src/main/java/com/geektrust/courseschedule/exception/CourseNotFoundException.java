package com.geektrust.courseschedule.exception;

public class CourseNotFoundException extends RuntimeException{
    private final String message;

    public CourseNotFoundException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
