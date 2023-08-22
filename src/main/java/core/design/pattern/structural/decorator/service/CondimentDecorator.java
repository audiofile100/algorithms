package core.design.pattern.structural.decorator.service;

public abstract class CondimentDecorator extends Beverage {

    private Beverage beverage;

    public abstract String getDescription();
}
