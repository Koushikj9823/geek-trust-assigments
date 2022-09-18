package com.geektrust.courseschedule.factory;

import com.geektrust.courseschedule.pojo.Parameter;

public interface Command {
    public void execute(Parameter parameter);
}
