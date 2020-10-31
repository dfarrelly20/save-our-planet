/**
 * 
 */
package boardgame;

import java.util.InputMismatchException;

/**
 * @author David Farrelly
 *
 */
public class BuildDevelopment {

	/**
	 * 
	 * @param p
	 * @return
	 */
	private static boolean ownsAllMountains(Player p) {

		boolean ownsAll = false;

		for (int loop = 0; loop < Main.gameBoard.length; loop++) {

			if (!Main.gameBoard[loop].getName().equals("Go") && (!Main.gameBoard[loop].getName().equals("Free Tile"))) {

				PropertyTile checkTile = ((PropertyTile) Main.gameBoard[loop]);

				switch (checkTile.getTerrain()) {

				case MOUNTAINS:

					if (checkTile.getOwnerName() != null && checkTile.getOwnerName().equals(p.getPlayerName())) {
						ownsAll = true;
					} else {
						ownsAll = false;
						return false;
					}
					break;
				default:
					break;

				}

			}
		}
		return ownsAll;

	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	private static boolean ownsAllDeserts(Player p) {

		boolean ownsAll = false;

		for (int loop = 0; loop < Main.gameBoard.length; loop++) {

			if (!Main.gameBoard[loop].getName().equals("Go") && (!Main.gameBoard[loop].getName().equals("Free Tile"))) {

				PropertyTile checkTile = ((PropertyTile) Main.gameBoard[loop]);

				switch (checkTile.getTerrain()) {

				case DESERT:

					if (checkTile.getOwnerName() != null && checkTile.getOwnerName().equals(p.getPlayerName())) {
						ownsAll = true;
					} else {
						ownsAll = false;
						return false;
					}
					break;
				default:
					break;

				}

			}
		}
		return ownsAll;

	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	private static boolean ownsAllForests(Player p) {

		boolean ownsAll = false;

		for (int loop = 0; loop < Main.gameBoard.length; loop++) {

			if (!Main.gameBoard[loop].getName().equals("Go") && (!Main.gameBoard[loop].getName().equals("Free Tile"))) {

				PropertyTile checkTile = ((PropertyTile) Main.gameBoard[loop]);

				switch (checkTile.getTerrain()) {

				case FOREST:

					if (checkTile.getOwnerName() != null && checkTile.getOwnerName().equals(p.getPlayerName())) {
						ownsAll = true;
					} else {
						ownsAll = false;
						return false;
					}
					break;
				default:
					break;

				}

			}
		}
		return ownsAll;

	}

	/**
	 * 
	 * @param p
	 * @return
	 */
	private static boolean ownsAllRivers(Player p) {

		boolean ownsAll = false;

		for (int loop = 0; loop < Main.gameBoard.length; loop++) {

			if (!Main.gameBoard[loop].getName().equals("Go") && (!Main.gameBoard[loop].getName().equals("Free Tile"))) {

				PropertyTile checkTile = ((PropertyTile) Main.gameBoard[loop]);

				switch (checkTile.getTerrain()) {

				case RIVERS:

					if (checkTile.getOwnerName() != null && checkTile.getOwnerName().equals(p.getPlayerName())) {
						ownsAll = true;
					} else {
						ownsAll = false;
						return false;
					}
					break;

				default:
					break;

				}

			}
		}
		return ownsAll;

	}

	/**
	 * 
	 * @param p
	 */
	public static void checkOwnsAll(Player p) {

		boolean run = false;

		do {

			try {

				if (ownsAllMountains(p)) {
					run = true;
					System.out.print(
							"> You own all Mountain tiles. Would you like to invest in some small wind farm developments? [y/n] : ");
					String answer = Main.sc.nextLine();
					if (answer.equalsIgnoreCase("y")) {
						while (run) {

							System.out.print(
									"> Which tile would you like to develop? [2. The Andean Mountains/ 3. The Himalayan Mountains] : ");
							int tile = Main.sc.nextInt();
							if (tile == 2 || tile == 3) {
								buildDevelopments(tile, p);
								run = false;
							} else {
								System.out.printf("> Can't build there. Pick another tile.\n");
								Main.sc.nextLine();
								run = true;
							}

						}

					} else if (answer.equalsIgnoreCase("info")) {
						GameSystem.displayInfo();
						run = true;
					} else if (answer.equalsIgnoreCase("n")) {
						run = false;
					} else {
						System.out.printf("> Sorry, didn't recognise that input. Let's try again.\n");
						run = true;
					}

				}

			} catch (InputMismatchException e) {
				System.out.printf("> You must enter the NUMBER of one of your of tiles. Try again.\n");
				run = true;
				Main.sc.nextLine();
			}

			try {

				if (ownsAllDeserts(p)) {
					run = true;
					System.out.print(
							"> You own all Desert tiles. Would you like to invest in some small solar farm developments? [y/n] : ");
					String answer = Main.sc.nextLine();
					if (answer.equalsIgnoreCase("y")) {
						while (run) {
							System.out.print(
									"> Which tile would you like to develop? [4. The Gobi Desert/ 5. The Mojave Desert/ 6. The Sahara Desert] : ");
							int tile = Main.sc.nextInt();
							if (tile == 4 || tile == 5 || tile == 6) {
								buildDevelopments(tile, p);
								run = false;
							} else {
								System.out.printf("> Can't build there. Pick another tile.\n");
								Main.sc.nextLine();
								run = true;
							}

						}

					} else if (answer.equalsIgnoreCase("info")) {
						GameSystem.displayInfo();
						run = true;
					} else if (answer.equalsIgnoreCase("n")) {
						run = false;
					} else {
						System.out.printf("> Sorry, didn't recognise that input. Let's try again.\n");
						run = true;
					}
				}

			} catch (InputMismatchException e) {
				System.out.printf("> You must enter the NUMBER of one of your of tiles. Try again.\n");
				run = true;
				Main.sc.nextLine();
			}

			try {

				if (ownsAllForests(p)) {
					run = true;
					System.out.print(
							"> You own all Forest tiles. Would you like to invest in some small reforestation developments? [y/n] : ");
					String answer = Main.sc.nextLine();
					if (answer.equalsIgnoreCase("y")) {
						while (run) {
							System.out.print(
									"> Which tile would you like to develop? [8. The Congo Rainforest/ 9. The Redwood National Forest/ 10. The Amazon Rainforest] : ");
							int tile = Main.sc.nextInt();
							if (tile == 8 || tile == 9 || tile == 10) {
								buildDevelopments(tile, p);
								run = false;
							} else {
								System.out.printf("> Can't build there. Pick another tile.\n");
								Main.sc.nextLine();
								run = true;
							}

						}

					} else if (answer.equalsIgnoreCase("info")) {
						GameSystem.displayInfo();
						run = true;
					} else if (answer.equalsIgnoreCase("n")) {
						run = false;
					} else {
						System.out.printf("> Sorry, didn't recognise that input. Let's try again.\n");
						run = true;
					}
				}

			} catch (InputMismatchException e) {
				System.out.printf("> You must enter the NUMBER of one of your of tiles. Try again.\n");
				run = true;
				Main.sc.nextLine();
			}

			try {

				if (ownsAllRivers(p)) {
					run = true;
					System.out.print(
							"> You own all River tiles. Would you like to invest in some small hydroelectric developments? [y/n] : ");
					String answer = Main.sc.nextLine();
					if (answer.equalsIgnoreCase("y")) {
						while (run) {
							System.out.print(
									"> Which tile would you like to develop? [11. The Shannon River/ 12. The Colorado River] : ");
							int tile = Main.sc.nextInt();
							if (tile == 11 || tile == 12) {
								buildDevelopments(tile, p);
								run = false;
							} else {
								System.out.printf("> Can't build there! Pick another tile.\n");
								Main.sc.nextLine();
								run = true;
							}

						}

					} else if (answer.equalsIgnoreCase("info")) {
						GameSystem.displayInfo();
						run = true;
					} else if (answer.equalsIgnoreCase("n")) {
						run = false;
					} else {
						System.out.printf("> Sorry, didn't recognise that input. Let's try again.\n");
						run = true;
					}
				}

			} catch (InputMismatchException e) {
				System.out.printf("> You must enter the NUMBER of one of your of tiles. Try again.\n");
				run = true;
				Main.sc.nextLine();
			}

		} while (run);

	}

	/**
	 * 
	 * @param tile
	 * @param p
	 */
	public static void buildDevelopments(int tile, Player p) {

		boolean run = true;

		for (int loop = 0; loop < Main.gameBoard.length; loop++) {

			if (!Main.gameBoard[loop].getName().equals("Go") && (!Main.gameBoard[loop].getName().equals("Free Tile"))) {

				// Finding tile to develop specified by player
				if (tile - 1 == loop) {

					while (run) {

						PropertyTile tileToDevelop = ((PropertyTile) Main.gameBoard[loop]);

						// Building small developments
						if (tileToDevelop.getSmallDevelopments() < 3) {

							// Asking player how many they want to build
							System.out.printf(
									"> Small %s developments here will cost £%d each. How many would you like to invest in? [Up to %d can be built] : ",
									tileToDevelop.getDevelopmentType(), tileToDevelop.getValue() / 2,
									3 - tileToDevelop.getSmallDevelopments());
							int numberToBuild = Main.sc.nextInt();

							// Variable to store cost of developing small
							int smallCost = tileToDevelop.getValue() / 2;

							if ((tileToDevelop.getSmallDevelopments() + numberToBuild) <= 3
									&& (p.getBalance() > (smallCost * numberToBuild))) {

								switch (numberToBuild) {

								case 1:
									tileToDevelop.setSmallDevelopments(tileToDevelop.getSmallDevelopments() + 1);
									p.withdrawFunds(smallCost);
									p.addToScore(tileToDevelop.getValue() / 5);
									break;
								case 2:
									tileToDevelop.setSmallDevelopments(tileToDevelop.getSmallDevelopments() + 2);
									p.withdrawFunds(smallCost * 2);
									p.addToScore((tileToDevelop.getValue() / 5) * 2);
									break;
								case 3:
									tileToDevelop.setSmallDevelopments(tileToDevelop.getSmallDevelopments() + 3);
									p.withdrawFunds(smallCost * 3);
									p.addToScore((tileToDevelop.getValue() / 5) * 3);
									break;
								}

								tileToDevelop.setRent((tileToDevelop.getValue() / 2)
										+ (tileToDevelop.getSmallDevelopments() * (tileToDevelop.getValue() / 4)));

								System.out.printf(
										"> Success! There are now %d small %s developments on this tile [%s +%d points].\n",
										tileToDevelop.getSmallDevelopments(), tileToDevelop.getDevelopmentType(),
										p.getPlayerName(), (tileToDevelop.getValue() / 5)*numberToBuild);
								Main.sc.nextLine();
								run = false;

								// Player attempts to build more than 3 small
							} else if (tileToDevelop.getSmallDevelopments() + numberToBuild > 3) {
								System.out.printf(
										"> That will exceed the maximum of 3 small developments for this tile! Let's try again.\n");
								Main.sc.nextLine();
								run = true;

								// Player doesn't have enough money to build small
							} else if (p.getBalance() <= smallCost * numberToBuild) {
								System.out.printf(
										"> Sorry! Insufficient funds to invest in that many developments. Try again later.\n");
								Main.sc.nextLine();
								run = false;
							}

							// Build large development
						} else if (tileToDevelop.getSmallDevelopments() == 3
								&& tileToDevelop.getLargeDevelopment() < 1) {

							Main.sc.nextLine();
							int largeCost = tileToDevelop.getValue() / 2;

							System.out.printf(
									"> There are 3 small %s developments on this tile. Would you like to build a large %s development for £%d? [y/n] : ",
									tileToDevelop.getDevelopmentType(), tileToDevelop.getDevelopmentType(), largeCost);
							String buildLargeAnswer = Main.sc.nextLine();

							// If player has enough money to build large
							if (p.getBalance() > largeCost) {

								if (buildLargeAnswer.equals("y") && p.getBalance() > largeCost) {

									tileToDevelop.setRent((tileToDevelop.getValue() / 2) + (tileToDevelop.getValue()));

									System.out.printf("> Success! There is now a large %s development on this tile [%s +%d points].\n",
											tileToDevelop.getDevelopmentType(), p.getPlayerName(), tileToDevelop.getValue() / 5);
									tileToDevelop.setLargeDevelopment(1);
									p.withdrawFunds(largeCost);
									p.addToScore(tileToDevelop.getValue() / 5);
									run = false;
								}

								// Player does not have enough money to invest in large
							} else if (p.getBalance() <= largeCost) {
								System.out.printf(
										"> Sorry! Insufficient funds to invest in a large %s development. Try again later.\n",
										tileToDevelop.getDevelopmentType());
								run = false;

							}

						} else if (tileToDevelop.getLargeDevelopment() >= 1) {
							System.out.printf("> There is already a large %s development on this tile! \n",
									tileToDevelop.getDevelopmentType());
							Main.sc.nextLine();
							run = false;
						}

					}

				}

			}

		}

	}

}
