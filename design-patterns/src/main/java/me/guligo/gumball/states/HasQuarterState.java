package me.guligo.gumball.states;

import java.util.Random;

import me.guligo.gumball.GumballMachine;

/**
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class HasQuarterState extends State {

	private final Random rand = new Random(System.currentTimeMillis());

	public HasQuarterState(GumballMachine gumballMachine) {
		super(gumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("Quarter already inserted");
	}

	@Override
	public void ejectQuarter() {
		gumballMachine.setCurrentState(gumballMachine.getNoQuarterState());
		System.out.println("Quarter ejected");
	}

	@Override
	public void turnCrank() {
		if (rand.nextInt(10) == 0 && gumballMachine.getGumballCount() > 1) {
			gumballMachine.setCurrentState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setCurrentState(gumballMachine.getSoldState());
		}
		System.out.println("Crank turned");
	}

	@Override
	public void dispense() {
		System.out.println("Need to turn crank first");
	}

}
