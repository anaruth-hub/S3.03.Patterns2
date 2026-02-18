package com.ana.patterns.builder;

import com.ana.patterns.builder.builder.MenuBuilder;
import com.ana.patterns.builder.model.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuBuilderTest {

    @Test
    void shouldCreateExecutiveMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Filet de Vedella")
                .withSupplement("Extra garnish")
                .withDessert("Chocolate mousse")
                .withDrink("Red wine")
                .build();

        assertTrue(menu.toString().contains("Filet de Vedella"));
        assertTrue(menu.toString().contains("Chocolate mousse"));
        assertTrue(menu.toString().contains("Red wine"));
    }

    @Test
    void shouldCreateHalfMenu() {
        Menu menu = new MenuBuilder()
                .withMainCourse("Risotto")
                .isVegan()
                .withCoffee("Espresso")
                .withoutDrink()
                .build();

        assertTrue(menu.toString().contains("Risotto"));
        assertTrue(menu.toString().contains("Espresso"));
    }
}
