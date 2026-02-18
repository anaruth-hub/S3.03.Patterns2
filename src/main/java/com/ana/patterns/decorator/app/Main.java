package com.ana.patterns.decorator.app;

import com.ana.patterns.decorator.base.LatteBase;
import com.ana.patterns.decorator.core.BubbleTea;
import com.ana.patterns.decorator.toppings.Flavor;
import com.ana.patterns.decorator.toppings.Sugar;
import com.ana.patterns.decorator.toppings.Tapioca;

public class Main {
    public static void main(String[] args) {
        BubbleTea tea = new LatteBase();
        tea = new Tapioca(tea);
        tea = new Sugar(tea);
        tea = new Flavor(tea, "Strawberry");
        tea = new Flavor(tea, "Mango");

        System.out.println(tea.getDescription());
        System.out.println(tea.getCost());
    }
}
