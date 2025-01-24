
package src.main.java.gameComponents;

/**
 * Represents a player in the Santorini board game.
 * Each player has a color (RED or BLUE) and exactly two workers.
 */
public class Player {

    /** The color of this player: RED or BLUE. */
    private PlayerColor color;
    /** The two workers belonging to this player. */
    private Worker[] workers;

    /**
     * Constructs a new Player, assigning RED or BLUE based on the next ID from {@link IDMaker}.
     * Each player gets exactly two {@link Worker} objects.
     */
    public Player() {
        this.color = setColor();
        this.workers = new Worker[2];
        workers[0] = new Worker(color);
        workers[1] = new Worker(color);
    }

    // SETTERS
    
    /**
     * Determines the player's color based on the ID from {@link IDMaker}.
     * If the ID is odd => RED, if even => BLUE.
     *
     * @return the {@link PlayerColor} for this player.
     */
    private PlayerColor setColor() {

        int id = IDMaker.getInstance().getNextID();
        if (id % 2 == 1) {
            return PlayerColor.RED;
        }
        return PlayerColor.BLUE;

    }

    /**
     * Returns this player's color.
     *
     * @return the {@link PlayerColor}.
     */
    public PlayerColor getColor() {
        return color;
    }

    /**
     * Returns the two workers belonging to this player.
     *
     * @return an array of exactly two {@link Worker} objects.
     */
    public Worker[] getWorkers() {
        return workers;
    }
    
}