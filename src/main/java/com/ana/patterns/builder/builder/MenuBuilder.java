package com.ana.patterns.builder.builder;

import com.ana.patterns.builder.model.Dish;
import com.ana.patterns.builder.model.Menu;
import com.ana.patterns.builder.steps.*;

public class MenuBuilder implements MainCourseStep, AfterMainStep, BuildStep {

    private final Menu menu = new Menu();
    private Dish currentMain;

    @Override
    public AfterMainStep withMainCourse(String name) {
        currentMain = new Dish(name);
        menu.setMainCourse(currentMain);
        return this;
    }

    @Override
    public AfterMainStep isVegan() {
        currentMain.markVegan();
        return this;
    }

    @Override
    public AfterMainStep isGlutenFree() {
        currentMain.markGlutenFree();
        return this;
    }

    @Override
    public AfterMainStep withSupplement(String supplement) {
        currentMain.addSupplement(supplement);
        return this;
    }

    @Override
    public DrinkStep withDessert(String dessert) {
        menu.setDessert(dessert);
        return this;
    }

    @Override
    public DrinkStep withCoffee(String coffee) {
        menu.setCoffee(coffee);
        return this;
    }

    @Override
    public BuildStep withDrink(String drink) {
        menu.setDrink(drink);
        return this;
    }

    @Override
    public BuildStep withoutDrink() {
        return this;
    }

    @Override
    public Menu build() {
        return menu;
    }
}
