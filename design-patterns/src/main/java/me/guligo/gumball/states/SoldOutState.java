package me.guligo.gumball.states;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class SoldOutState extends State {

	public SoldOutState(GumballMachine gumballMachine) {
		super(gumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("Nope!");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Nope!");
	}

	@Override
	public void turnCrank() {
		System.out.println("Nope!");
	}

	@Override
	public void dispense() {
		System.out.println("Nope!");
	}

}
