package com.geektrust.courseschedule.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Data {
    public static final HashMap<String,Course> courseHashMap = new HashMap<>();
    public static final HashMap<String,Employee> employeeHashMap = new HashMap<>();
    private static Data instance = new Data();

    private Data(){

    }
    public static Data getInstance() {
        return instance;
    }

}
