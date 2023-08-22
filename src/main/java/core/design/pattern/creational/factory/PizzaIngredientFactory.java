package core.design.pattern.creational.factory;

import core.design.pattern.creational.factory.impl.ingredient.*;

import java.util.List;

public interface PizzaIngredientFactory {

    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    List<Veggies> createVeggies();
    List<Meat> createMeats();
}
