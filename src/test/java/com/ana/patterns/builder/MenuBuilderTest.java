package com.ana.patterns.builder;

import com.ana.patterns.builder.builder.MenuBuilder;
import com.ana.patterns.builder.model.Menu;
import com.ana.patterns.builder.steps.StartStep;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuBuilderTest {

    @Test
    void shouldCreateExecutiveMenu_withEntrantDessertAndDrink() {
        StartStep builder = new MenuBuilder();

        Menu menu = builder
                .withEntrant("Amanida Mediterrània")
                .isVegan()
                .isGlutenFree()
                .doneEntrant()
                .withMainCourse("Filet de Vedella")
                .withSupplement("Guarnició extra")
                .withDessert("Mousse de xocolata")
                .withDrink("Vi Negre")
                .build();

        String s = menu.toString();
        assertTrue(s.contains("Amanida Mediterrània"));
        assertTrue(s.contains("Filet de Vedella"));
        assertTrue(s.contains("Mousse de xocolata"));
        assertTrue(s.contains("Vi Negre"));
    }

    @Test
    void shouldCreateHalfMenu_withoutEntrant_coffee_noDrink() {
        StartStep builder = new MenuBuilder();

        Menu menu = builder
                .withoutEntrant()
                .withMainCourse("Risotto de bolets")
                .isVegan()
                .withCoffee("Espresso")
                .build();

        String s = menu.toString();
        assertTrue(s.contains("Risotto de bolets"));
        assertTrue(s.contains("Espresso"));
        assertTrue(s.contains("Drink: None"));
    }
}
