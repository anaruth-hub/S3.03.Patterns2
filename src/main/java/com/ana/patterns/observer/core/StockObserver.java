package com.ana.patterns.observer.core;

public interface StockObserver {
    void onStockUpdate(StockEvent event);
}
