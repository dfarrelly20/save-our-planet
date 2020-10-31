/**
 * 
 */
package boardgame;

import java.util.InputMismatchException;

/**
 * @author David Farrelly
 *
 */
public class PropertyTile extends Tile {

	/**
	 * The value of this tile
	 */
	private int value;

	/**
	 * The terrain type of this tile. Can be set to: MOUNTAINS, DESERT, FOREST,
	 * RIVERS
	 */
	private TerrainTypes terrainTypes;

	/**
	 * The rent for this tile
	 */
	private int rent;

	/**
	 * Whether or not this tile has been invested in
	 */
	private boolean bought = false;

	/**
	 * The name of the player who has invested in this tile
	 */
	private String ownerName;

	/**
	 * The number of small developments on this tile
	 */
	private int smallDevelopments = 0;

	/**
	 * The minimum number of small developments that can be on this tile
	 */
	private final int MIN_SMALL_DEVELOPMENTS = 0;

	/**
	 * The maximum number of small developments that can be on this tile
	 */
	private final int MAX_SMALL_DEVELOPMENTS = 3;

	/**
	 * The number of large developments on this tile
	 */
	private int largeDevelopment = 0;

	/**
	 * The development type of this tile. Can be set to: windfarm, solarfarm,
	 * reforestation, hydroelectric
	 */
	private DevelopmentTypes developmentType;

	/**
	 * Default constructor
	 */
	public PropertyTile() {

	}

	/**
	 * Constructor with args to create a tile
	 * 
	 * @param name            - the name of this tile
	 * @param value           - the value of this tile
	 * @param terrain         - the type of terrain to set for this tile
	 * @param rent            - the rent of this tile
	 * @param developmentType - the type of development to set for this tile
	 */
	public PropertyTile(String name, int value, TerrainTypes terrain, int rent, DevelopmentTypes developmentType) {
		super(name);
		this.value = value;
		this.terrainTypes = terrain;
		this.setRent(rent);
		this.developmentType = developmentType;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the terrain
	 */
	public TerrainTypes getTerrain() {
		return terrainTypes;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(TerrainTypes terrain) {
		this.terrainTypes = terrain;
	}

	/**
	 * @return the rent
	 */
	public int getRent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}

	/**
	 * @return the bought
	 */
	public boolean isBought() {
		return bought;
	}

	/**
	 * @param bought the bought to set
	 */
	public void setBought(boolean bought) {
		this.bought = bought;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the smallDevelopments
	 */
	public int getSmallDevelopments() {
		return smallDevelopments;
	}

	/**
	 * @param smallDevelopments the smallDevelopments to set
	 */
	public void setSmallDevelopments(int smallDevelopments) throws InputMismatchException {
		if (smallDevelopments >= MIN_SMALL_DEVELOPMENTS && smallDevelopments <= MAX_SMALL_DEVELOPMENTS) {
			this.smallDevelopments = smallDevelopments;
		} else {
			throw new InputMismatchException("You must enter a NUMBER between 1 and 3!");
		}

	}

	/**
	 * @return the largeDevelopment
	 */
	public int getLargeDevelopment() {
		return largeDevelopment;
	}

	/**
	 * @param largeDevelopment the largeDevelopment to set
	 */
	public void setLargeDevelopment(int largeDevelopment) {
		this.largeDevelopment = largeDevelopment;
	}

	/**
	 * @return the developmentType
	 */
	public DevelopmentTypes getDevelopmentType() {
		return developmentType;
	}

	/**
	 * @param developmentType the developmentType to set
	 */
	public void setDevelopmentType(DevelopmentTypes developmentType) {
		this.developmentType = developmentType;
	}

	/**
	 * The action to take when the player lands on a property tile.
	 * 
	 * If the tile is not owned by any player, this player is offered the chance to
	 * invest in the tile.
	 * 
	 * If the tile is already owned by another player, the player who landed here
	 * will make a contribution to the player who owns the tile.
	 * 
	 * If the tile is already owned by the player who landed here, they are informed
	 * of this.
	 * 
	 * @param - The player who has landed on the tile
	 */
	@Override
	public void action(Player p) {

		// If this tile is not owned by ANY player
		if (!this.bought) {
			checkTileNotOwned(p);

			// If this tile is owned by a different player to the player who landed
		} else if (!p.getPlayerName().equals(this.getOwnerName())) {
			checkTileOwned(p);

			// If the player who landed on the tile already owns it
		} else if (p.getPlayerName().equals(this.getOwnerName())) {
			checkPlayerOwnsTile(p, this);
		}

	}

	/**
	 * Method checks if the tile the player has landed on is not currently owned. If
	 * true, the player is asked whether they would like to invest in the tile. If
	 * they choose to do so they become the 'owner' of this tile. In this case the
	 * value of the tile is withdrawn from the player funds and the player's score
	 * is increased.
	 * 
	 * @param p - the player who has landed here
	 */
	private void checkTileNotOwned(Player p) {
		System.out.printf("> %s, you have landed on tile %d [%s][£%d].\n", p.getPlayerName(), p.getPosition() + 1,
				getName(), getValue());
		GameSystem.pause(800);

		boolean run = true;

		do {

			// Informing the player that this tile can be invested in
			System.out.printf(
					"> This tile is currently seeking funding for environmental projects. Would you like to invest £%d? [y/n] : ",
					getValue());
			String answer = Main.sc.nextLine();

			// If player chooses YES to investing
			if (answer.equalsIgnoreCase("y") && p.getBalance() > getValue()) {

				setBought(true);
				setOwnerName(p.getPlayerName());

				// Withdrawing money from player and adding to their score
				p.withdrawFunds(getValue());
				p.addToScore(getValue() / 10);

				System.out.printf(
						"> Success! %s [£%.2f] you are now the largest investor on %s tile [%s +%d points].\n",
						p.getPlayerName(), p.getBalance(), getName(), p.getPlayerName(), getValue() / 10);
				run = false;
				GameSystem.pause(700);

				// Player chooses NO to investing
			} else if (answer.equalsIgnoreCase("n")) {
				run = false;

				// Player does not have enough FUNDS to invest - can't invest
			} else if (p.getBalance() <= getValue()) {
				System.out.print("> Sorry! You have insufficient funds to invest in this tile. \n");
				run = false;

				// Player requests the displayInfo method
			} else if (answer.equals("info")) {
				GameSystem.displayInfo();
				run = true;

				// Player enters an invalid response
			} else {
				System.out.print("> Sorry! Didn't recognise that input. Let's try again. \n");
				run = true;
			}

		} while (run);

	}

	/**
	 * Method checks if the tile that the player has landed on is already owned by
	 * another player. If it is, this player is informed who owns it and the
	 * donation they are paying.
	 * 
	 * Both the player who landed on the tile and the investor in the tile both have
	 * their funds updated. The investor of the tile else has their score added to.
	 * 
	 * @param p - the player who has landed on the tile
	 */
	private void checkTileOwned(Player p) {

		// Informing player someone else has already invested in this tile
		System.out.printf("> %s, you have landed on tile %d [%s][£%d], where %s is already the largest investor.\n",
				p.getPlayerName(), p.getPosition() + 1, getName(), getValue(), getOwnerName());
		GameSystem.pause(800);

		// Checking if player can afford to donate
		if (p.getBalance() > this.rent) {

			System.out.printf(
					"> You are impressed by their environmental efforts and contribute £%d to their cause [%s +%d points].\n",
					this.rent, getOwnerName(), getValue() / 10);
			GameSystem.pause(800);

			p.withdrawFunds(this.rent);

			// Depositing funds to owner of tile and adding to their score
			for (Player owner : Main.allPlayers) {

				if (owner.getPlayerName().equals(getOwnerName())) {
					owner.depositFunds(this.rent);
					owner.addToScore(getValue() / 10);
				}

			}

			// Player who landed does not have enough funds to cover donation cost - remove
			// from array list
		} else if (p.getBalance() <= this.rent) {

			System.out.printf(
					"> With your own money running very low, you decide to donate your remaining funds to their cause for the benefit of the planet. Well played!\n",
					p.getPlayerName());

			Main.allPlayers.remove(p);

			// Depositing the player's remaining funds to the investor of this tile
			for (Player owner : Main.allPlayers) {

				if (owner.getPlayerName().equals(getOwnerName())) {
					owner.depositFunds((int) p.getBalance());
					owner.addToScore(getValue() / 10);
				}

			}

		}

	}

	/**
	 * Method checks if the tile the player has landed on is already invested in by
	 * them.
	 * 
	 * @param p - the player who has landed on this tile
	 */
	private void checkPlayerOwnsTile(Player p, PropertyTile tile) {

		System.out.printf("> You have landed on tile %d [%s][£%d]. You are already the major investor in this area! \n",
				p.getPosition() + 1, getName(), getValue(), getOwnerName());
		GameSystem.pause(800);

	}

}
