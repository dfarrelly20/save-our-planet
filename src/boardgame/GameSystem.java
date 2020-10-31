/**
 * 
 */
package boardgame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * The GameSystem class houses a number of methods that are called as the player
 * takes their turn.
 * 
 * @author David Farrelly
 *
 */
public class GameSystem {

	/**
	 * Method creates an array that stores the information for the game board.
	 * 
	 * @return - an array of type Tile representing the game board
	 */
	public static Tile[] gameBoard() {
		Tile[] gameBoard = new Tile[12];

		gameBoard[0] = new GoTile("Go");
		gameBoard[1] = new PropertyTile("The Andean Mountains", 100, TerrainTypes.MOUNTAINS, 50, DevelopmentTypes.windfarm);
		gameBoard[2] = new PropertyTile("The Himalayan Mountains", 100, TerrainTypes.MOUNTAINS, 50, DevelopmentTypes.windfarm);
		gameBoard[3] = new PropertyTile("The Gobi Desert", 200, TerrainTypes.DESERT, 100, DevelopmentTypes.solarfarm);
		gameBoard[4] = new PropertyTile("The Mojave Desert", 200, TerrainTypes.DESERT, 100, DevelopmentTypes.solarfarm);
		gameBoard[5] = new PropertyTile("The Sahara Desert", 200, TerrainTypes.DESERT, 100, DevelopmentTypes.solarfarm);
		gameBoard[6] = new FreeTile("Free Tile");
		gameBoard[7] = new PropertyTile("The Congo Rainforest", 300, TerrainTypes.FOREST, 150, DevelopmentTypes.reforestation);
		gameBoard[8] = new PropertyTile("The Redwood National Forest", 300, TerrainTypes.FOREST, 150, DevelopmentTypes.reforestation);
		gameBoard[9] = new PropertyTile("The Amazon Rainforest", 300, TerrainTypes.FOREST, 150, DevelopmentTypes.reforestation);
		gameBoard[10] = new PropertyTile("The Shannon River", 400, TerrainTypes.RIVERS, 200, DevelopmentTypes.hyrdoelectric);
		gameBoard[11] = new PropertyTile("The Colorado River", 400, TerrainTypes.RIVERS, 200, DevelopmentTypes.hyrdoelectric);

		return gameBoard;
	}

	/**
	 * A static method that can be used to generate a pause in the game flow.
	 * 
	 * @param - the length in MILLISECONDS to pause
	 */
	public static void pause(int length) {
		try {
			TimeUnit.MILLISECONDS.sleep(length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Simulates a random event that can occur during the player's turn. This works
	 * by attempting to match the player's ID to a randomly generated number. This
	 * random number (called playerIdMatch) is scaled to the number of players in
	 * the array list. If the playerID and playerIdMatch are the same, a random
	 * event is chosen from an array of strings and the player is informed of the
	 * outcome.
	 * 
	 * @param p - the player who is currently playing
	 */
	public static void chanceGenerator(Player p) {
		Random random = new Random();
		int playerIDMatch = random.nextInt(Main.allPlayers.size());
		playerIDMatch++;
		int arrayChooser = random.nextInt(5);
		String[] chanceArray = new String[5];

		chanceArray[0] = "You took a private jet to a climate protest! Lose £50. \n";
		chanceArray[1] = "A generous sponser has donated to your cause. Gain £50. \n";
		chanceArray[2] = "Disaster! You lost a law suit against a major oil company. Lose £100. \n";
		chanceArray[3] = "You have persuaded a small firm to invest in your company. Gain £100. \n";
		chanceArray[4] = "One of your labs has made a major breakthrough in renewable technology! Gain £125. \n";

		if (playerIDMatch == p.getId()) {
			switch (arrayChooser) {
			case 0:
				p.withdrawFunds(50);
				break;
			case 1:
				p.depositFunds(50);
				break;
			case 2:
				p.withdrawFunds(100);
				break;
			case 3:
				p.depositFunds(100);
				break;
			case 4:
				p.depositFunds(125);
			default:
				break;
			}

			System.out.print("> Random event happening."); GameSystem.pause(700);
			System.out.print("."); GameSystem.pause(700);
			System.out.print("."); GameSystem.pause(700);
			System.out.print(chanceArray[arrayChooser]); GameSystem.pause(500);
		}
	}

	/**
	 * Method that is called when the player types 'info' during their turn.
	 * Provides, in the form of a table, a print out of each player's current funds,
	 * which tiles they have invested in, the developments on those tiles and the
	 * donation other players must make if they land on the tile.
	 * 
	 * The score for each player is displayed below the table, along with who is
	 * currently in the lead.
	 */
	public static void displayInfo() {

		// Table heading here
		System.out.printf("\n\n\t[%-12s] [%-12s] [%-28s] [%-18s] [%-12s]\n\n", "   Player", "    Funds",
				"         Investments", "   Developments", "   Contribution  ");

		for (Player player : Main.allPlayers) {

			// Row contains player info
			System.out.printf("\t %-14s\n\t %-14s £%-14.2f",
					"---------------------------------------------------------------------------------------------------",
					player.getPlayerName(), player.getBalance());

			// Checking which tiles each player has invested in
			for (int i = 0; i < Main.gameBoard.length; i++) {
				if (!Main.gameBoard[i].getName().equals("Go") && (!Main.gameBoard[i].getName().equals("Free Tile"))) {

					PropertyTile propType = ((PropertyTile) Main.gameBoard[i]);

					if (propType.isBought()) {

						if (propType.getOwnerName().equals(player.getPlayerName()))
							System.out.printf("%-31s%d small, %d large     £%-14d\n\t  %-14s %-14s", propType.getName(),
									propType.getSmallDevelopments(), propType.getLargeDevelopment(), propType.getRent(),
									"", "");

					}
				}
			}
			System.out.println();
		}

		// The score is displayed here

		System.out.printf("\n\tScore:");

		int highScore = 1;

		// Checking who has the current high score
		for (Player playerScore : Main.allPlayers) {

			if (playerScore.getScore() > highScore) {

				highScore = playerScore.getScore();

			}

		}

		// Displaying who has the current high score
		for (Player playerScore : Main.allPlayers) {

			if (playerScore.getScore() == highScore) {

				System.out.printf("\t%s is leading with %d points.", playerScore.getPlayerName(),
						playerScore.getScore());

			}

		}

		// Displaying the other player scores
		for (Player playerScore : Main.allPlayers) {

			if (playerScore.getScore() != highScore) {

				System.out.printf(" [%s : %d points] ", playerScore.getPlayerName(), playerScore.getScore());

			}

		}

		System.out.print("\n\n");
	}

}
