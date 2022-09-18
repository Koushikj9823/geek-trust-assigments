package com.geektrust.courseschedule.enums;

public enum CommandType {
    ADD_COURSE_OFFERING("ADD-COURSE-OFFERING"),
    REGISTER("REGISTER"),
    CANCEL("CANCEL"),
    ALLOT_COURSE("ALLOT");

    private String value;

    public String getValue(){
        return value;
    }
    CommandType(String value) {
        this.value = value;
    }
}
