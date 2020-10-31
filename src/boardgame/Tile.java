/**
 * 
 */
package boardgame;

/**
 * Class represent a tile
 * 
 * @author David Farrelly
 *
 */
public abstract class Tile {

	/**
	 * The name of this tile
	 */
	private String name;

	/**
	 * Default constructor
	 */
	public Tile() {

	}

	/**
	 * 
	 * @param name - the name of this tile
	 */
	public Tile(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public abstract void action(Player p);

}
