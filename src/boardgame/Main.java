package boardgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class for the save our planet virtual board game
 * 
 * @author David Farrelly
 *
 */
public class Main {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Player> allPlayers = RegisterPlayer.registerPlayer(1000);
	public static Tile[] gameBoard = GameSystem.gameBoard();
	public static Dice dice = new Dice();
	public static MovePlayer move = new MovePlayer();

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// main flow
		while (move.isMakeMove()) {
			for (Player player : allPlayers) {
				if (move.isMakeMove() && player.getBalance() > 0) {
					move.movePlayer(player, player.getPosition(), dice);
					System.out.println();
				}
			}
		}

		// game over - displaying final info and winner
		GameSystem.displayInfo();

		double highestScore = 0;
		for (Player player : allPlayers) {
			if (player.getScore() > highestScore) {
				highestScore = player.getScore();
			}
		}

		for (Player player : allPlayers) {
			if (player.getScore() == highestScore) {
				System.out.printf(
						"\nCongradulations %s! You are the winner of the G.R.E.E.N award with %d points. Well done!.",
						player.getPlayerName(), player.getScore());
			}
		}
	}
}
