package boardgame;

/**
 * Class represents a free tile
 * 
 * @author David Farrelly
 *
 */
public class FreeTile extends Tile {

	/**
	 * 
	 */
	public FreeTile() {

	}

	/**
	 * 
	 * @param name
	 */
	public FreeTile(String name) {
		super(name);
	}

	/**
	 * The action to take on this tile. In this case the tile has no significant
	 * action except to print a message to the player.
	 */
	@Override
	public void action(Player p) {
		System.out.println("> [Free Tile] You have been working hard to save the planet. Time to take a break!");
		GameSystem.pause(700);

	}

}
