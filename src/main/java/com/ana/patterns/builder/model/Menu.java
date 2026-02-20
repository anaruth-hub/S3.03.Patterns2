package com.ana.patterns.builder.model;

public class Menu {

    private Dish entrant;
    private Dish mainCourse;
    private String dessert;
    private String coffee;
    private String drink;

    public void setEntrant(Dish entrant) { this.entrant = entrant; }
    public void setMainCourse(Dish mainCourse) { this.mainCourse = mainCourse; }
    public void setDessert(String dessert) { this.dessert = dessert; }
    public void setCoffee(String coffee) { this.coffee = coffee; }
    public void setDrink(String drink) { this.drink = drink; }

    public Dish getMainCourse() { return mainCourse; } // <- para validar build()

    @Override
    public String toString() {
        return """
               Menu:
               - Entrant: %s
               - Main Course: %s
               - Dessert: %s
               - Coffee: %s
               - Drink: %s
               """.formatted(
                entrant != null ? entrant.description() : "None",
                mainCourse != null ? mainCourse.description() : "None",
                dessert != null ? dessert : "None",
                coffee != null ? coffee : "None",
                drink != null ? drink : "None"
        );
    }
}
