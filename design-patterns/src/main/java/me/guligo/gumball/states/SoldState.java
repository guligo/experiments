package me.guligo.gumball.states;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class SoldState extends State {

	public SoldState(GumballMachine gumballMachine) {
		super(gumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("You already inserted a quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Too late");
	}

	@Override
	public void turnCrank() {
		System.out.println("Crank already turned");
	}

	@Override
	public void dispense() {
		if (gumballMachine.getGumballCount() > 0) {
			gumballMachine.setGumballCount(gumballMachine.getGumballCount() - 1);
			if (gumballMachine.getGumballCount() == 0) {
				gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
			} else {
				gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
			}
			System.out.println("Here's your gumball!");
		} else {
			gumballMachine.setSoldOutState(gumballMachine.getSoldOutState());
			System.out.println("Sorry, we're out of gumballs!");
			System.out.println("Here's your quarter");
		}
	}

}
