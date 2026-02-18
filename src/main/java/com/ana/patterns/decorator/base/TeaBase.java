package com.ana.patterns.decorator.base;

import com.ana.patterns.decorator.core.BubbleTea;

public final class TeaBase implements BubbleTea {

    @Override
    public String getDescription() {
        return "Tea Bubble Tea";
    }

    @Override
    public double getCost() {
        return 3.00;
    }
}
