package core.design.pattern.creational.factory.impl.product;

import core.design.pattern.creational.factory.PizzaIngredientFactory;
import core.design.pattern.creational.factory.impl.product.Pizza;

public class PepperoniPizza extends Pizza {

    protected PizzaIngredientFactory pizzaIngredientFactory;

    public PepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        veggies = pizzaIngredientFactory.createVeggies();
        meats = pizzaIngredientFactory.createMeats();
    }
}
