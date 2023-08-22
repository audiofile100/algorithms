package core.design.pattern.behavioral.state.impl;

import core.design.pattern.behavioral.state.SodaMachine;
import core.design.pattern.behavioral.state.service.State;

public class SoldState implements State {

    private final SodaMachine sodaMachine;

    public SoldState(SodaMachine sodaMachine) {
        this.sodaMachine = sodaMachine;
    }

    @Override
    public void insertMoney() {
        System.out.println("Please wait. We are dispensing a soda.");
    }

    @Override
    public void ejectMoney() {
        System.out.println("No refunds.");
    }

    @Override
    public void selectSoda() {
        System.out.println("You can't select another soda yet.");
    }

    @Override
    public void dispense() {
        sodaMachine.releaseSoda();
        if (sodaMachine.getInventory() > 0) {
            sodaMachine.setState(sodaMachine.getWaitingState());
        } else {
            sodaMachine.setState(sodaMachine.getSoldState());
        }
    }
}
