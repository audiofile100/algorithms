package core.design.pattern.creational.factory.impl.product;

import core.design.pattern.creational.factory.impl.ingredient.*;
import lombok.Setter;

import java.util.List;

public abstract class Pizza {

    @Setter protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected List<Veggies> veggies;
    protected List<Meat> meats;

    protected abstract void prepare();

    protected void bake() {
        System.out.println("Baking for 15 minutes");
    }

    protected void cut() {
        System.out.println("Cutting into slices");
    }

    protected void box() {
        System.out.println("Placing pizza in pizza box");
    }
}
