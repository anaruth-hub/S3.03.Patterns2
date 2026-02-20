package com.ana.patterns.builder.steps;

public interface StartStep {
    EntrantOptionsStep withEntrant(String name);
    MainCourseStep withoutEntrant();
}
