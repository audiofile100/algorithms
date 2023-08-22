package core.design.pattern.structural.decorator.impl;

import core.design.pattern.structural.decorator.service.Beverage;
import core.design.pattern.structural.decorator.service.CondimentDecorator;

public class VanillaSyrup extends CondimentDecorator {

    private final Beverage beverage;

    public VanillaSyrup(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", vanilla syrup";
    }
}
