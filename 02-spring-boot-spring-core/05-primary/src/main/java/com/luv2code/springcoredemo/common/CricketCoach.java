package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 :-)";
    }
}
