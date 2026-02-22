package com.ana.patterns.observer.agent;

import com.ana.patterns.observer.core.StockEvent;
import com.ana.patterns.observer.core.StockObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class StockAgent {

    private final List<StockObserver> observers = new ArrayList<>();
    private double currentValue;

    public void addObserver(StockObserver observer) {
        Objects.requireNonNull(observer, "observer cannot be null");
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void stockMarketUp(double newValue) {
        update(new StockEvent(StockEvent.Direction.UP, newValue));
    }

    public void stockMarketDown(double newValue) {
        update(new StockEvent(StockEvent.Direction.DOWN, newValue));
    }

    private void update(StockEvent event) {
        this.currentValue = event.value();
        notifyObservers(event);
    }

    private void notifyObservers(StockEvent event) {
        for (StockObserver observer : observers) {
            observer.onStockUpdate(event);
        }
    }
}
