package com.ana.patterns.decorator.base;

import com.ana.patterns.decorator.core.BubbleTea;

public final class LatteBase implements BubbleTea {

    @Override
    public String getDescription() {
        return "Latte Bubble Tea";
    }

    @Override
    public double getCost() {
        return 3.50;
    }
}
