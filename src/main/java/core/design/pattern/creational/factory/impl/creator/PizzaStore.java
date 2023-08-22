package core.design.pattern.creational.factory.impl.creator;

import core.design.pattern.creational.factory.impl.product.Pizza;

public abstract class PizzaStore {

    protected abstract Pizza createPizza(String name);      // factory method
}
