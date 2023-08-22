package core.design.pattern.structural.decorator;

import core.design.pattern.structural.decorator.impl.DarkRoast;
import core.design.pattern.structural.decorator.impl.LightRoast;
import core.design.pattern.structural.decorator.impl.VanillaSyrup;
import core.design.pattern.structural.decorator.impl.WhippedCream;
import core.design.pattern.structural.decorator.service.Beverage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorPatternTest {

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void darkRoastBeverageTest() {

        Beverage beverage = new DarkRoast();
        beverage = new VanillaSyrup(beverage);      // wrap
        beverage = new WhippedCream(beverage);

        double cost = beverage.cost();
        String description = beverage.getDescription();

        assertEquals(1.74, cost, 0.001);
        assertEquals("Dark Roast, vanilla syrup, whipped cream", description);
    }

    @Test
    public void lightRoastBeverageTest() {

        Beverage beverage = new LightRoast();
        beverage = new VanillaSyrup(beverage);
        beverage = new WhippedCream(beverage);

        double cost = beverage.cost();
        String description = beverage.getDescription();

        assertEquals(1.64, cost, 0.001);
        assertEquals("Light Roast, vanilla syrup, whipped cream", description);
    }
}
