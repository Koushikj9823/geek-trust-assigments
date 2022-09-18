package com.geektrust.courseschedule.exception;

public class EmployeeNotFoundException extends RuntimeException{
    private final String message;

    public EmployeeNotFoundException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
