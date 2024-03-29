package core.design.pattern.behavioral.state;

import core.design.pattern.behavioral.state.SodaMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StatePatternTest {

    private SodaMachine sodaMachine;

    @BeforeEach
    public void setUp() {
        sodaMachine = new SodaMachine(3);
    }

    // TODO: make soda machine return boolean for testing
    @Test
    public void sodaMachineTest() {

        sodaMachine.ejectMoney();
    }
}
