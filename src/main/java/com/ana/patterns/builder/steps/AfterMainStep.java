package com.ana.patterns.builder.steps;

public interface AfterMainStep extends EntrantOptionsStep, DessertOrCoffeeStep, DrinkOrBuildStep {

    AfterMainStep withSupplement(String supplement);

}
