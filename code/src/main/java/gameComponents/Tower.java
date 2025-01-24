
package src.main.java.gameComponents;

/**
 * Represents a tower in the Santorini board game. A tower has a height
 * (from 0 to 4) and may or may not be a dome if height >= 4.
 */
public class Tower {

    /** The current height of this tower (0..4). */
    private int height;
    /** True if this tower is a dome (height = 4). */
    private boolean isDome;

    /**
     * Constructs a new Tower with height 0 (ground level) and no dome.
     */
    public Tower() {
        this.height = 0;
        this.isDome = false;
    }

    // GETTERS
    
    /**
     * Returns the integer height of this tower.
     *
     * @return the tower height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Checks if this tower has a dome.
     *
     * @return true if the tower is a dome, false otherwise.
     */
    public boolean isDome() {
        return isDome;
    }

    // SETTER

    /**
     * Increments the height of this tower by one, up to 4.
     * If the tower reaches height 4, it becomes a dome.
     *
     * @return true if the tower leveled up successfully, false if already a dome.
     */
    public boolean levelUp() {
        if (!this.isDome) {
            this.height++;
            if (this.height == 4) this.isDome = true;
            return true;
        }
        return false;
    }

}