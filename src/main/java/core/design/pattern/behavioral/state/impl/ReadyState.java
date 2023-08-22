package core.design.pattern.behavioral.state.impl;

import core.design.pattern.behavioral.state.SodaMachine;
import core.design.pattern.behavioral.state.service.State;

public class ReadyState implements State {

    private final SodaMachine sodaMachine;

    public ReadyState(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("You can't insert anymore");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Money returned.");
    }

    @Override
    public void selectSoda() {
        System.out.println("You selected a soda.");
        sodaMachine.setState(sodaMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Nothing dispensed yet.");
    }
}
