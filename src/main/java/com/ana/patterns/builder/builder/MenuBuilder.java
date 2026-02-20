package com.ana.patterns.builder.builder;

import com.ana.patterns.builder.model.Dish;
import com.ana.patterns.builder.model.Menu;
import com.ana.patterns.builder.steps.*;

import java.util.Objects;

public class MenuBuilder implements
        StartStep, EntrantOptionsStep, MainCourseStep, AfterMainStep, DrinkOrBuildStep, BuildStep {

    private final Menu menu = new Menu();

    private Dish currentEntrant;
    private Dish currentMain;
    private Dish currentEditableDish;


    @Override
    public EntrantOptionsStep withEntrant(String name) {
        currentEntrant = new Dish(requireName(name, "entrant"));
        menu.setEntrant(currentEntrant);
        currentEditableDish = currentEntrant;
        return this;
    }

    @Override
    public MainCourseStep withoutEntrant() {
        currentEntrant = null;
        currentEditableDish = null;
        return this;
    }

    @Override
    public MainCourseStep doneEntrant() {
        return this;
    }


    @Override
    public AfterMainStep withMainCourse(String name) {
        currentMain = new Dish(requireName(name, "main course"));
        menu.setMainCourse(currentMain);
        currentEditableDish = currentMain;
        return this;
    }


    @Override
    public AfterMainStep isVegan() {
        ensureEditableDish();
        currentEditableDish.markVegan();
        return this;
    }

    @Override
    public AfterMainStep isGlutenFree() {
        ensureEditableDish();
        currentEditableDish.markGlutenFree();
        return this;
    }

    @Override
    public AfterMainStep withSupplement(String supplement) {
        if (currentMain == null) throw new IllegalStateException("Main course must be set before supplement");
        currentMain.addSupplement(requireName(supplement, "supplement"));
        return this;
    }


    @Override
    public DrinkOrBuildStep withDessert(String dessert) {
        menu.setDessert(requireName(dessert, "dessert"));
        menu.setCoffee(null);
        return this;
    }

    @Override
    public DrinkOrBuildStep withCoffee(String coffee) {
        menu.setCoffee(requireName(coffee, "coffee"));
        menu.setDessert(null);
        return this;
    }


    @Override
    public BuildStep withDrink(String drink) {
        menu.setDrink(requireName(drink, "drink"));
        return this;
    }


    @Override
    public Menu build() {
        if (menu.getMainCourse() == null) {
            throw new IllegalStateException("A menu must have a main course.");
        }
        return menu;
    }


    private void ensureEditableDish() {
        if (currentEditableDish == null) {
            throw new IllegalStateException("No dish selected to configure (choose entrant or main course first).");
        }
    }

    private static String requireName(String value, String field) {
        String v = Objects.requireNonNull(value, field + " cannot be null").trim();
        if (v.isEmpty()) throw new IllegalArgumentException(field + " cannot be blank");
        return v;
    }
}
