package com.ana.patterns.observer;

import com.ana.patterns.observer.agent.StockAgent;
import com.ana.patterns.observer.observers.StockBrokerAgency;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StockAgentTest {

    @Test
    void shouldNotifyAllObserversOnUpAndDown() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency alpha = new StockBrokerAgency("Alpha Brokers");
        StockBrokerAgency zenith = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alpha);
        agent.addObserver(zenith);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;

        try {
            System.setOut(new PrintStream(out));

            agent.stockMarketUp(150.75);
            agent.stockMarketDown(145.50);

        } finally {
            System.setOut(original);
        }

        String printed = out.toString();

        assertTrue(printed.contains("Alpha Brokers received notification: Stock market went UP to 150.75"));
        assertTrue(printed.contains("Zenith Investments received notification: Stock market went UP to 150.75"));
        assertTrue(printed.contains("Alpha Brokers received notification: Stock market went DOWN to 145.5"));
        assertTrue(printed.contains("Zenith Investments received notification: Stock market went DOWN to 145.5"));

        assertEquals(145.50, agent.getCurrentValue());
    }

    @Test
    void shouldAllowRemovingObservers() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency alpha = new StockBrokerAgency("Alpha Brokers");
        StockBrokerAgency zenith = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alpha);
        agent.addObserver(zenith);
        agent.removeObserver(zenith);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;

        try {
            System.setOut(new PrintStream(out));
            agent.stockMarketUp(200.0);
        } finally {
            System.setOut(original);
        }

        String printed = out.toString();

        assertTrue(printed.contains("Alpha Brokers received notification: Stock market went UP to 200.0"));
        assertFalse(printed.contains("Zenith Investments received notification"));
    }
}
