package core.design.pattern.creational.factory;

import core.design.pattern.creational.factory.impl.ingredient.*;

import java.util.List;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public List<Veggies> createVeggies() {
        return List.of(new RedPepper(), new Mushroom());
    }

    @Override
    public List<Meat> createMeats() {
        return List.of(new Pepperoni());
    }
}
