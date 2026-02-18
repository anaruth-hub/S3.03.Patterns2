package com.ana.patterns.builder.model;

public class Dish {

    private final String name;
    private boolean vegan;
    private boolean glutenFree;
    private String supplement;

    public Dish(String name) {
        this.name = name;
    }

    public Dish markVegan() {
        this.vegan = true;
        return this;
    }

    public Dish markGlutenFree() {
        this.glutenFree = true;
        return this;
    }

    public Dish addSupplement(String supplement) {
        this.supplement = supplement;
        return this;
    }

    public String description() {
        StringBuilder sb = new StringBuilder(name);

        if (vegan) sb.append(" (Vegan)");
        if (glutenFree) sb.append(" (Gluten Free)");
        if (supplement != null) sb.append(", Supplement: ").append(supplement);

        return sb.toString();
    }
}
