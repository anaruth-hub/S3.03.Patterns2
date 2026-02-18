package com.ana.patterns.decorator.toppings;

import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.core.BubbleTeaDecorator;

public final class Sugar extends BubbleTeaDecorator {

    public Sugar(BubbleTea inner) {
        super(inner);
    }

    @Override
    public String getDescription() {
        return inner.getDescription() + " + Sugar";
    }

    @Override
    public double getCost() {
        return inner.getCost() + 0.30;
    }
}
