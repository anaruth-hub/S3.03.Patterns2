package com.ana.patterns.builder.steps;

import com.ana.patterns.builder.model.Menu;

public interface DrinkOrBuildStep extends BuildStep {
    BuildStep withDrink(String drink);
    Menu build();
}
