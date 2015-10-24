package me.guligo.gumball;

/**
 * Demonstrates the state pattern in action. The "state pattern" allows an
 * object to alter its behavior when its internal state changes. The object will
 * appear to change its class.
 * 
 * @see "Head First Design Patterns" by Eric Freeman and Elisabeth Robson
 */
public class TestGumballMachine {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(10);
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.dispense();
	}

}
