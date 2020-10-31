/**
 * 
 */
package boardgame;

/**
 * Class represents a Go Tile
 * 
 * @author David Farrelly
 *
 */
public class GoTile extends Tile {

	/**
	 * 
	 */
	public GoTile() {

	}

	/**
	 * @param name
	 */
	public GoTile(String name) {
		super(name);

	}

	/**
	 * The action to take. If the players lands on this tile they receive £400. If
	 * they pass the tile but have not landed on it they receive £200.
	 */
	@Override
	public void action(Player p) {

		// Checking if player has landed on Go tile - deposit double money
		if (p.getPosition() == 0) {
			System.out.println("> [Land On Go] UNESCO has taken an interest in your environmental work. Collect £400!");
			p.depositFunds(400);
			GameSystem.pause(700);

			// If the player just passes Go, deposit £200
		} else {
			System.out.println("> [Pass Go] Your environmental efforts have been recognised. Collect £200!");
			p.depositFunds(200);
			GameSystem.pause(700);
		}

	}

}
