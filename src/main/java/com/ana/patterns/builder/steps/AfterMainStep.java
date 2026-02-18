package com.ana.patterns.builder.steps;

public interface AfterMainStep extends DessertOrCoffeeStep, DrinkStep {
    AfterMainStep isVegan();
    AfterMainStep isGlutenFree();
    AfterMainStep withSupplement(String supplement);
}
