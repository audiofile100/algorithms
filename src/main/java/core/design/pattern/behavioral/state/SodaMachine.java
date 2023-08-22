package core.design.pattern.behavioral.state;

import core.design.pattern.behavioral.state.impl.ReadyState;
import core.design.pattern.behavioral.state.impl.SoldOutState;
import core.design.pattern.behavioral.state.impl.SoldState;
import core.design.pattern.behavioral.state.impl.WaitingState;
import core.design.pattern.behavioral.state.service.State;
import lombok.Getter;

public class SodaMachine {

    @Getter private State soldOutState;
    @Getter private State waitingState;
    @Getter private State readyState;
    @Getter private State soldState;

    @Getter private int inventory = 0;

    private State state;

    public SodaMachine(int inventory) {
        soldOutState = new SoldOutState(this);
        waitingState = new WaitingState(this);
        readyState = new ReadyState(this);
        soldState = new SoldState(this);

        this.inventory = inventory;
        state = (inventory > 0) ? waitingState : soldOutState;
    }

    public void insertMoney() {
        state.insertMoney();
    }

    public void ejectMoney() {
        state.ejectMoney();
    }

    public void selectSoda() {
        state.selectSoda();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseSoda() {
        System.out.println("Soda rolls out.");
        --inventory;
    }
}
