package core.design.pattern.structural.decorator.service;

import lombok.Getter;

@Getter
public abstract class Beverage {

    protected String description;

    public abstract double cost();
}
