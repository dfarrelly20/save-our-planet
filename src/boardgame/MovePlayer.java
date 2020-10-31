package boardgame;

/**
 * Class to make the player move.
 * 
 * @author David Farrelly
 *
 */
public class MovePlayer {

	/**
	 * True if player chooses to roll the dice, else set to false
	 */
	private boolean makeMove = true;

	/**
	 * Default constructor
	 */
	public MovePlayer() {

	}

	/**
	 * @return - Whether or not the player has chosen to roll the dice
	 */
	public boolean isMakeMove() {
		return makeMove;
	}

	/**
	 * @param - True is player chooses to roll, else set to false
	 */
	public void setMakeMove(boolean makeMove) {
		this.makeMove = makeMove;
	}

	/**
	 * Method moves a player from one tile to another.
	 * 
	 * The player is asked if they would like to roll the dice. If they answer 'y',
	 * a dice object is invoked and the player is moved the corresponding number of
	 * tiles. If the player types 'n', the game terminates. The player has the
	 * option to type 'info', which will call the displayInfo method from GameSystem.
	 * 
	 * Any other answer is unrecognised and the player will be asked again if they
	 * would like to roll the dice.
	 * 
	 */
	public void movePlayer(Player player, int position, Dice dice) {
		boolean run = true;

		// Informing the player it their turn
		System.out.printf("Player %d [%s][£%.2f][Current Tile: %d][%s], your turn. \n\n", player.getId(),
				player.getPlayerName(), player.getBalance(), player.getPosition()+1,
				Main.gameBoard[player.getPosition()].getName());

		while (run) {
			do {
				
				// Checking if they get to roll again because of a double 
				if (dice.isReroll()) {
					System.out.printf("> %s [£%.2f] you rolled a double, so get to roll again. \n",
							player.getPlayerName(), player.getBalance());
					GameSystem.pause(800);
				}

				// Asking the user if they want to roll
				position = player.getPosition();
				System.out.printf("> Would you like to roll the dice, %s? [y/n] : ", player.getPlayerName());
				String answer = Main.sc.nextLine();

				// If player chooses YES to rolling - move player
				if (answer.equalsIgnoreCase("y")) {
					position += dice.rollDie();

					// Checking if player has passed Go after rolling
					if (position >= 12) {
						player.setPosition(position - 12);
						Main.gameBoard[0].action(player);
					} else {
						player.setPosition(position);
					}

					// Informing player of actions available to them on this tile
					// First checking they aren't on Go tile
					if (player.getPosition() != 0) {
						Main.gameBoard[player.getPosition()].action(player);
					}

					// Checking if the player owns any full tile groups
					BuildDevelopment.checkOwnsAll(player);

					// Running random chance generator
					if(player.getBalance() > 200) {
						GameSystem.chanceGenerator(player);
					}
				
					GameSystem.pause(700);
					run = false;

					// If player chooses NOT to roll - potential to QUIT game
				} else if (answer.equalsIgnoreCase("n")) {
					System.out.print("> Are you sure? This will result in the game ending. [y/n] : ");
					String quit = Main.sc.nextLine();
					if (quit.equals("y")) {
						System.out.println("\nGame over!!!");
						this.makeMove = false;
						run = false;
					} else if (quit.equals("n")) {
						run = true;
					} else {
						System.out.println("> Sorry, didn't recognise that input. Let's try again.");
						run = true;
					}

					// If player chooses to display info
				} else if (answer.equalsIgnoreCase("info")) {
					GameSystem.displayInfo();

					// Player enters an invalid response
				} else {
					System.out.println("> Sorry, didn't recognise that input. Let's try again.");
					run = true;
				}
			} while (dice.isReroll() && this.makeMove);
		}
	}
}
