package com.ana.patterns.decorator.base;

import com.ana.patterns.decorator.core.BubbleTea;

public final class MatchaBase implements BubbleTea {

    @Override
    public String getDescription() {
        return "Matcha Bubble Tea";
    }

    @Override
    public double getCost() {
        return 3.20;
    }
}
