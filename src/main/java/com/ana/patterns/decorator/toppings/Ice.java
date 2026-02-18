package com.ana.patterns.decorator.toppings;

import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.core.BubbleTeaDecorator;

public final class Ice extends BubbleTeaDecorator {

    public Ice(BubbleTea inner) {
        super(inner);
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + " + Ice";
    }

    @Override
    public double getCost() {
        return inner.getCost() + 0.25;
    }
}
