package core.design.pattern.creational.factory;

import core.design.pattern.creational.factory.impl.ingredient.*;

import java.util.List;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return null;
    }

    @Override
    public Sauce createSauce() {
        return null;
    }

    @Override
    public Cheese createCheese() {
        return null;
    }

    @Override
    public List<Veggies> createVeggies() {
        return null;
    }

    @Override
    public List<Meat> createMeats() {
        return null;
    }
}
