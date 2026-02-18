package com.ana.patterns.decorator.toppings;

import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.core.BubbleTeaDecorator;

public final class Tapioca extends BubbleTeaDecorator {

    public Tapioca(BubbleTea inner) {
        super(inner);
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + " + Tapioca";
    }

    @Override
    public double getCost() {
        return inner.getCost() + 0.50;
    }
}
