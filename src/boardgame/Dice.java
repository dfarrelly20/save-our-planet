/**
 * 
 */
package boardgame;

import java.util.Random;

/**
 * The dice class. When called will generate two random numbers, each between 1
 * and 6 to represent a set of virtual dice. If the two numbers generated are
 * equivalent, a boolean value is set to true and the class generates successive
 * sets of numbers.
 * 
 * @author David Farrelly
 *
 */
public class Dice {

	/**
	 * Determines whether the player gets to roll the dice again.
	 */
	private boolean reroll;

	/**
	 * Default constructor
	 */
	public Dice() {

	}

	/**
	 * @return - Whether or not the dice will be rolled again
	 */
	public boolean isReroll() {
		return reroll;
	}

	/**
	 * @param - True if two die are equivalent, else set to false.
	 */
	public void setReroll(boolean reroll) {
		this.reroll = reroll;
	}

	/**
	 * Method rolls two die and prints to screen the outcome of each roll. The
	 * numeric sum of the dice is returned as an int.
	 * 
	 * @return - int the total value of the dice
	 */
	public int rollDie() {
		Random r = new Random();
		int die1, die2;
		int total = 0;
		
		// Generating value for first die
		die1 = r.nextInt(6);
		die1++;
		// Generating value for second die
		die2 = r.nextInt(6);
		die2++;	
		
		// Printing result of rolls to player
		System.out.print("> Rolling dice."); GameSystem.pause(700);
		System.out.print("."); GameSystem.pause(700);
		System.out.print("."); GameSystem.pause(700);
		System.out.printf("you rolled a %d and a %d. ", die1, die2);
		
		// if both die are equivalent, set re-roll to true
		if (die1 == die2) {
			System.out.printf("That's a double! ");
			setReroll(true);
		} else {
			setReroll(false);
		}	
		
		// Calculating the total value to return
		total = die1 + die2;
		System.out.printf("Moving %d tiles.\n", total); GameSystem.pause(700);
		
		return total;
	}
	
}
