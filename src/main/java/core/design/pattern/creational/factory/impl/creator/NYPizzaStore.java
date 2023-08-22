package core.design.pattern.creational.factory.impl.creator;

import core.design.pattern.creational.factory.NYPizzaIngredientFactory;
import core.design.pattern.creational.factory.PizzaIngredientFactory;
import core.design.pattern.creational.factory.impl.product.PepperoniPizza;
import core.design.pattern.creational.factory.impl.product.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String name) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (name.equals("Pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Pepperoni");
        }

        return pizza;
    }
}
