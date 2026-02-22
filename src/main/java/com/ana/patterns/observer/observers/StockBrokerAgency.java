package com.ana.patterns.observer.observers;

import com.ana.patterns.observer.core.StockEvent;
import com.ana.patterns.observer.core.StockObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class StockBrokerAgency implements StockObserver {

    private final String name;
    private final List<String> receivedMessages = new ArrayList<>();

    public StockBrokerAgency(String name) {
        this.name = Objects.requireNonNull(name, "name cannot be null").trim();
        if (this.name.isEmpty()) throw new IllegalArgumentException("name cannot be blank");
    }

    @Override
    public void onStockUpdate(StockEvent event) {
        Objects.requireNonNull(event, "event cannot be null");

        String msg = String.format(
                Locale.US,
                "%s received notification: Stock market went %s to %.2f",
                name,
                event.direction(),
                event.value()
        );

        receivedMessages.add(msg);

    }

    public List<String> history() {
        return List.copyOf(receivedMessages);
    }

    public String getName() {
        return name;
    }
}