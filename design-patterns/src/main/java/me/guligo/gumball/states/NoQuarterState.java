package me.guligo.gumball.states;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class NoQuarterState extends State {

	public NoQuarterState(GumballMachine gumballMachine) {
		super(gumballMachine);
	}

	@Override
	public void insertQuarter() {
		gumballMachine.setCurrentState(gumballMachine.getHasQuarterState());
		System.out.println("You inserted a quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You haven't inserted a quarter");
	}

}
