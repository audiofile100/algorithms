package core.design.pattern.behavioral.state.impl;

import core.design.pattern.behavioral.state.SodaMachine;
import core.design.pattern.behavioral.state.service.State;

public class WaitingState implements State {

    private final SodaMachine sodaMachine;

    public WaitingState(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("You inserted money.");
    }

    @Override
    public void ejectMoney() {
        System.out.println("Nothing to eject.");
    }

    @Override
    public void selectSoda() {
        System.out.println("Displays price.");
    }

    @Override
    public void dispense() {
        System.out.println("You have to insert money first.");
    }
}
