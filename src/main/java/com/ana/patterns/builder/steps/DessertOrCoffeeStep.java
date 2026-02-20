package com.ana.patterns.builder.steps;

public interface DessertOrCoffeeStep {
    DrinkOrBuildStep withDessert(String dessert);
    DrinkOrBuildStep withCoffee(String coffee);

}
