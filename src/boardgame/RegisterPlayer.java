/**
 * 
 */
package boardgame;

import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Class allows the user to register players for the game, up to a maximum of 4
 * players. Players are added to an array list of type player.
 * 
 * @author David Farrelly
 *
 */
public class RegisterPlayer {

	/**
	 * Method allows the user to register new players to the game. This method first
	 * calls the private 'logNumberOfPlayers' method, which asks the user to
	 * indicate how many players they would like to register.
	 * 
	 * Each player is given a unique playerNumber and new players can be added while
	 * the current playerNumber is less than or equal to the number of players
	 * indicated in logNumberOfPlayers. Each player is asked to enter their name in
	 * turn. If the name they enter is valid they are added to the array list.
	 * 
	 * Invalid names include: Names with symbols or numbers. An empty field or white
	 * space. Names less than 1 character or more than 15 characters. Names that
	 * have already been taken by another player.
	 * 
	 * Once the player name has been validated they are added to the array list and
	 * their starting position and funds are set.
	 * 
	 * @return - An array list of players
	 */
	public static ArrayList<Player> registerPlayer(int balance) {
		// Using an array list to store the players
		ArrayList<Player> allPlayers = new ArrayList<Player>();

		// Initialising the first players number to 1.
		int playerNumber = 1;
		// Calling the logNumberOfPlayers method
		int numberOfPlayers = logNumberOfPlayers();

		boolean run = true;

		do {
			try {
				System.out.printf("Player %d enter your name : ", playerNumber);
				String name = Main.sc.nextLine();
				
				// Setting the player name and number
				Player p = new Player(playerNumber, name, balance, 0);
				
				// Checking if name has already been taken
				for (Player player : allPlayers) {
					if (player.getPlayerName().equalsIgnoreCase(name)) {
						throw new IllegalArgumentException("That name has been taken! Hit ENTER to try another name. ");
					}
				}
				
				// Adding this player to the array list
				allPlayers.add(p);
				// Incrementing to the next player
				playerNumber++;
				
				// Checking if all players have been entered
				if (playerNumber > numberOfPlayers) {
					run = false;
				} else {
					run = true;
				}
				
			} catch (IllegalArgumentException e) {
				System.out.print(e.getMessage());
				run = true;
				Main.sc.nextLine();
			} catch (Exception e) {
				System.out.println("Sorry had a problem there. Hit ENTER to retry.");
				run = true;
				Main.sc.nextLine();
			}
			
		} while (run);
		
		System.out.println("Players registered successfully. Let's SAVE OUR PLANET!\n");
		
		return allPlayers;
	}

	/**
	 * Method asks the player how many players they want to register. Must be
	 * between 2 and 4 players. If the player enters anything else they are requested
	 * to try again with a valid input.
	 * 
	 * @return - int The number of players
	 */
	private static int logNumberOfPlayers() {
		boolean run = true;
		int numberOfPlayers = 0;

		// calling the printWelcome method
		printWelcome();
		System.out.print("Welcome to the game. ");

		do {
			try {
				// Requesting the user indicate how many players they would like to register
				// Must be between 2 and 4 - request player to try again if anything else
				System.out.print("How many people are playing? [2-4 players] : ");
				numberOfPlayers = Main.sc.nextInt();
				Main.sc.nextLine();

				if (numberOfPlayers >= 2 && numberOfPlayers <= 4) {
					run = false;
				} else if (numberOfPlayers < 2) {
					System.out.println("Must be at least 2 players to play! Let's try that again...\n");
					run = true;
				} else {
					System.out.println("Sorry, can't register more than 4 players! Let's try that again...\n");
					run = true;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("You must enter a NUMBER between 2 and 4! Let's try again...\n");
				Main.sc.nextLine();
				run = true;
			}
			
		} while (run);
		
		return numberOfPlayers;
	}

	/**
	 * Print to screen a welcome message
	 */
	private static void printWelcome() {
		System.out.println("\n \t* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
				+ "  \t*                                                           *\n"
				+ "  \t*                     Save Our Planet                       *\n"
				+ "  \t*                                                           *\n"
				+ "  \t*           A Virtual Board Game For 2-4 Players            *\n"
				+ "  \t*                                                           *\n"
				+ "  \t*       Travel to the worlds most important natural         *\n"
				+ "  \t*         resource sites and invest in the future!          *\n"
				+ "  \t*                                                           *\n"
				+ "  \t*                                                           *\n"
				+ "  \t* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
	}

	/**
	 * Method displays info for all players
	 */
	public static void displayPlayerInfo(ArrayList<Player> allPlayers) {
		System.out.printf("\t[%-10s] [%-10s] [%-10s]\n\n", "   Name", "   Funds", " Position");
		for (Player player : allPlayers) {
			player.display();
		}
	}
}
