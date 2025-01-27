
package src.main.java.gameComponents;

/**
 * Represents a player in the Santorini board game. Each player has a color (RED
 * or BLUE) and exactly two workers.
 */
public class Player {

	/** The color of this player: RED or BLUE. */
	private PlayerColor color;

	/** The two workers belonging to this player. */
	private Worker[] workers;
	private String name;

	/**
	 * Constructs a new Player, assigning RED or BLUE based on the next ID from
	 * {@link IDMaker}. Each player gets exactly two {@link Worker} objects.
	 */
	public Player(String name) {
		this.name = name;
		this.workers = new Worker[2];
		workers[0] = new Worker(color);
		workers[1] = new Worker(color);
	}

	// GETTERS

	/**
	 * Returns this player's color.
	 *
	 * @return the {@link PlayerColor}.
	 */
	public PlayerColor getColor() {
		return color;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}

	/**
	 * Returns the two workers belonging to this player.
	 *
	 * @return an array of exactly two {@link Worker} objects.
	 */
	public Worker[] getWorkers() {
		return workers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}