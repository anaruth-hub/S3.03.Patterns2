package com.ana.patterns.decorator;

import com.ana.patterns.decorator.base.LatteBase;
import com.ana.patterns.decorator.base.MatchaBase;
import com.ana.patterns.decorator.base.TeaBase;
import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.toppings.Flavor;
import com.ana.patterns.decorator.toppings.Ice;
import com.ana.patterns.decorator.toppings.Sugar;
import com.ana.patterns.decorator.toppings.Tapioca;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTeaDecoratorTest {

    @Test
    void latteWithTapiocaSugarAndTwoFlavors_shouldComposeDescriptionAndCost() {
        BubbleTea tea = new LatteBase();         // 3.50
        tea = new Tapioca(tea);                  // +0.50
        tea = new Sugar(tea);                    // +0.30
        tea = new Flavor(tea, "Strawberry");     // +0.60
        tea = new Flavor(tea, "Mango");          // +0.60

        assertEquals(
                "Latte Bubble Tea + Tapioca + Sugar + Flavor: Strawberry + Flavor: Mango",
                tea.getDescription()
        );

        assertEquals(5.50, tea.getCost(), 0.0001); // 3.50 +0.50 +0.30 +0.60 +0.60
    }

    @Test
    void matchaWithIce_shouldIncreaseCost() {
        BubbleTea tea = new MatchaBase(); // 3.20
        tea = new Ice(tea);               // +0.25

        assertEquals("Matcha Bubble Tea + Ice", tea.getDescription());
        assertEquals(3.45, tea.getCost(), 0.0001);
    }

    @Test
    void teaWithoutToppings_shouldKeepBaseValues() {
        BubbleTea tea = new TeaBase();

        assertEquals("Tea Bubble Tea", tea.getDescription());
        assertEquals(3.00, tea.getCost(), 0.0001);
    }

    @Test
    void flavor_shouldRejectBlankFlavorName() {
        BubbleTea tea = new LatteBase();
        assertThrows(IllegalArgumentException.class, () -> new Flavor(tea, "   "));
    }
}
