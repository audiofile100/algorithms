package core.design.pattern.behavioral.state.impl;

import core.design.pattern.behavioral.state.SodaMachine;
import core.design.pattern.behavioral.state.service.State;

public class SoldOutState implements State {

    private final SodaMachine sodaMachine;

    public SoldOutState(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Not accepting money. We are sold out.");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Nothing to eject. We are sold out.");
    }

    @Override
    public void selectSoda() {
        System.out.println("Select does nothing. We are sold out.");
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense. We are sold out.");
    }
}
