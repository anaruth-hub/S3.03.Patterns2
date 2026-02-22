package com.ana.patterns.observer.core;

public record StockEvent(Direction direction, double value) {

    public enum Direction { UP, DOWN }

}
