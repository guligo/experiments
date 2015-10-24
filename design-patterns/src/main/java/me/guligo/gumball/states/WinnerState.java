package me.guligo.gumball.states;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class WinnerState extends State {

	public WinnerState(GumballMachine gumballMachine) {
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
		gumballMachine.setGumballCount(gumballMachine.getGumballCount() - 2);
		if (gumballMachine.getGumballCount() == 0) {
			gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
		}
		System.out.println("Here's your gumball and one for free. Congrats!");
	}

}
