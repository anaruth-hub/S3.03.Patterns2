package com.ana.patterns.observer;

import com.ana.patterns.observer.agent.StockAgent;
import com.ana.patterns.observer.observers.StockBrokerAgency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockAgentTest {

    @Test
    void shouldNotifyAllObserversOnUpAndDown() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency alpha = new StockBrokerAgency("Alpha Brokers");
        StockBrokerAgency zenith = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alpha);
        agent.addObserver(zenith);

        agent.stockMarketUp(150.75);
        agent.stockMarketDown(145.50);

        assertEquals(145.50, agent.getCurrentValue());

        assertEquals(2, alpha.history().size());
        assertEquals(2, zenith.history().size());

        assertEquals("Alpha Brokers received notification: Stock market went UP to 150.75", alpha.history().get(0));
        assertEquals("Alpha Brokers received notification: Stock market went DOWN to 145.50", alpha.history().get(1));

        assertEquals("Zenith Investments received notification: Stock market went UP to 150.75", zenith.history().get(0));
        assertEquals("Zenith Investments received notification: Stock market went DOWN to 145.50", zenith.history().get(1));
    }

    @Test
    void shouldAllowRemovingObservers() {
        StockAgent agent = new StockAgent();

        StockBrokerAgency alpha = new StockBrokerAgency("Alpha Brokers");
        StockBrokerAgency zenith = new StockBrokerAgency("Zenith Investments");

        agent.addObserver(alpha);
        agent.addObserver(zenith);

        agent.removeObserver(zenith);

        agent.stockMarketUp(200.0);

        assertEquals(200.0, agent.getCurrentValue());

        assertEquals(1, alpha.history().size());
        assertEquals("Alpha Brokers received notification: Stock market went UP to 200.00", alpha.history().get(0));

        assertEquals(0, zenith.history().size());
    }
}