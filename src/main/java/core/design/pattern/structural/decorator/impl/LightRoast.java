package core.design.pattern.structural.decorator.impl;

import core.design.pattern.structural.decorator.service.Beverage;

public class LightRoast extends Beverage {

    public LightRoast() {
        description = "Light Roast";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
