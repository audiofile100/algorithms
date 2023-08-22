package core.design.pattern.structural.decorator.impl;

import core.design.pattern.structural.decorator.service.Beverage;
import core.design.pattern.structural.decorator.service.CondimentDecorator;

public class WhippedCream extends CondimentDecorator {

    private final Beverage beverage;

    public WhippedCream(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.25;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", whipped cream";
    }
}
