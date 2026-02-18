package com.ana.patterns.decorator.core;

import java.util.Objects;

public abstract class BubbleTeaDecorator implements BubbleTea {

    protected final BubbleTea inner;

    protected BubbleTeaDecorator(BubbleTea inner) {
        this.inner = Objects.requireNonNull(inner, "inner tea cannot be null");
    }
}
