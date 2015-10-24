package me.guligo.gumball.states;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public abstract class State {

	protected GumballMachine gumballMachine;

	public State(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public abstract void insertQuarter();

	public abstract void ejectQuarter();

	public abstract void turnCrank();

	public abstract void dispense();

}
