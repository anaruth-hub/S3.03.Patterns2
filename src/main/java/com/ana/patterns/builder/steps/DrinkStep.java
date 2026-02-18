package com.ana.patterns.builder.steps;

public interface DrinkStep {
    BuildStep withDrink(String drink);
    BuildStep withoutDrink();
}
