package com.ana.patterns.decorator.toppings;

import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.core.BubbleTeaDecorator;

import java.util.Objects;

public final class Flavor extends BubbleTeaDecorator {

    private final String flavor;

    public Flavor(BubbleTea inner, String flavor) {
        super(inner);
        this.flavor = Objects.requireNonNull(flavor, "flavor cannot be null").trim();
        if (this.flavor.isEmpty()) throw new IllegalArgumentException("flavor cannot be blank");
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + " + Flavor: " + flavor;
    }

    @Override
    public double getCost() {
        return inner.getCost() + 0.60;
    }
}
