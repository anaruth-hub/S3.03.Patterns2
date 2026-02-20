package com.ana.patterns.builder.steps;

public interface EntrantOptionsStep {
    AfterMainStep isVegan();
    AfterMainStep isGlutenFree();
    MainCourseStep doneEntrant();
}
