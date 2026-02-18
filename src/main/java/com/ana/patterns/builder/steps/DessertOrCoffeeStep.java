package com.ana.patterns.builder.steps;

public interface DessertOrCoffeeStep {
    DrinkStep withDessert(String dessert);
    DrinkStep withCoffee(String coffee);
}
