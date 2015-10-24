package me.guligo.gumball;

import me.guligo.gumball.states.HasQuarterState;
import me.guligo.gumball.states.NoQuarterState;
import me.guligo.gumball.states.SoldOutState;
import me.guligo.gumball.states.SoldState;
import me.guligo.gumball.states.WinnerState;
import me.guligo.gumball.states.State;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class GumballMachine {

	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State winnerState;

	private State currentState;
	private long gumballCount;

	public GumballMachine(long gumballCount) {
		this.soldOutState = new SoldOutState(this);
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.soldState = new SoldState(this);
		this.winnerState = new WinnerState(this);

		this.gumballCount = gumballCount;
		if (this.gumballCount > 0) {
			currentState = noQuarterState;
		} else {
			currentState = soldOutState;
		}
	}

	public void insertQuarter() {
		currentState.insertQuarter();
	}

	public void turnCrank() {
		currentState.turnCrank();
	}

	public void dispense() {
		currentState.dispense();
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(State noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(State hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public void setWinnerState(State winnerState) {
		this.winnerState = winnerState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public long getGumballCount() {
		return gumballCount;
	}

	public void setGumballCount(long gumballCount) {
		this.gumballCount = gumballCount;
	}

}
