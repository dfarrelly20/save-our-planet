package boardgame;

/**
 * Class represents a Player
 * 
 * @author Shay Fegan
 *
 */
public class Player {

	/**
	 * The name of the player - between 1 and 12 characters
	 */
	private String playerName;

	/**
	 * The minimum and maximum length that the player name can be set to
	 */
	private final int NAME_LENGTH_MIN = 1;
	private final int NAME_LENGTH_MAX = 15;

	/**
	 * The ID of the player - between 1 and 4
	 */
	private int id;

	/**
	 * The current balance of the player
	 */
	private double balance;

	/**
	 * The current tile position of the player
	 */
	private int position;
	
	private int score = 0;

	/**
	 * Default constructor
	 */
	public Player() {
	}

	/**
	 * Constructor to create a player
	 * 
	 * @param id
	 * @param playerName
	 * @param balance
	 * @param position
	 */
	public Player(int id, String playerName, double balance, int position) {
		this.id = id;
		this.setPlayerName(playerName);
		this.setBalance(balance);
		this.position = position;
	}

	/**
	 * Returns the name of the player as a String.
	 * 
	 * @return
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Sets the name of the player. Name must be a letter, can't be an empty field
	 * or start with white space. The name must be at least 1 character and no more
	 * than 12
	 * 
	 * @param playerName
	 * @throws IllegalArgumentException
	 */
	public void setPlayerName(String playerName) throws IllegalArgumentException {
		if (!playerName.isEmpty() && playerName.matches("[a-zA-Z ]+") && !playerName.startsWith(" ")
				&& (playerName.length() >= NAME_LENGTH_MIN && playerName.length() <= NAME_LENGTH_MAX)) {
			
			// Setting player name and converting first letter to upper case if needed
			this.playerName = playerName.substring(0, 1).toUpperCase() + playerName.substring(1);
		} else {
			this.playerName = "[Please enter a name]";
			throw new IllegalArgumentException("Sorry! Don't recognise that as a valid name. Hit ENTER to try again. ");
		}
	}

	/**
	 * Returns the balance of the player as a double.
	 * 
	 * @return
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance of the player (double).
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Returns the position of the player as an int.
	 * 
	 * @return
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the position of the player (int).
	 * 
	 * @param position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Returns the ID of the player as an int.
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the ID of the player (int).
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 
	 * @param funds
	 */
	public void depositFunds(int funds) {
		this.balance = balance + funds;
	}

	/**
	 * 
	 * @param funds
	 */
	public void withdrawFunds(int funds) {
		this.balance = balance - funds;
	}
	
	public void addToScore(int points) {
		this.score = score + points;
	}

	/**
	 * Method displays player info
	 */
	public void display() {
		System.out.printf("\t %-12s £%-12.2f %-12d\n", getPlayerName(), getBalance(), getPosition());
	}
}
