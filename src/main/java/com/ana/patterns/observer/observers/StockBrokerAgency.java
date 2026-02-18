package com.ana.patterns.observer.observers;

import com.ana.patterns.observer.core.StockObserver;

import java.util.Objects;

public final class StockBrokerAgency implements StockObserver {

    private final String name;

    public StockBrokerAgency(String name) {
        this.name = Objects.requireNonNull(name, "name cannot be null").trim();
        if (this.name.isEmpty()) throw new IllegalArgumentException("name cannot be blank");
    }

    @Override
    public void onStockUpdate(String message) {
        System.out.println(name + " received notification: " + message);
    }

    public String getName() {
        return name;
    }
}
