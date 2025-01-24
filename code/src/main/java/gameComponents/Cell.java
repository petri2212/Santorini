
package src.main.java.gameComponents;

/**
 * Represents a single cell on the Santorini board. Each Cell contains
 * a Tower and may or may not contain a Worker.
 */
public class Cell {

    /** The x-coordinate (row) of this cell. */
    private int xPos;
    /** The y-coordinate (column) of this cell. */
    private int yPos;
    /** The Tower in this cell. */
    private Tower tower;
    /** The Worker in this cell (null if no Worker present). */
    private Worker worker;
    /** Tracks whether a Worker is present or absent. */
    private WorkerStatus status;
    
    /**
     * Constructs a Cell with the given coordinates. Initializes a new Tower
     * (height=0, no dome) and sets no Worker in it by default.
     *
     * @param xPos the row index of this cell.
     * @param yPos the column index of this cell.
     */
    public Cell(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.tower = new Tower();
        this.worker = null;
        this.status = WorkerStatus.ABSENT;
    }

    // GETTERS
    
    // CELL RELATED
    
    /**
     * Returns the [x, y] coordinates of this cell.
     *
     * @return an int array {xPos, yPos}.
     */
    public int[] getPos() {
        return new int[] {xPos, yPos};
    }

    
    // TOWER RELATED
    
    /**
     * Returns the Tower located in this cell.
     *
     * @return the {@link Tower} object for this cell.
     */
    public Tower getTower() {
        return tower;
    }

    /**
     * Returns the height of the tower in this cell (shortcut).
     *
     * @return the integer height of the tower.
     */
    public int getHeight() {
        return tower.getHeight();
    }

    // WORKER RELATED
    
    /**
     * Returns the WorkerStatus of this cell (PRESENT/ABSENT).
     *
     * @return the {@link WorkerStatus} enum value of this cell.
     */
    public WorkerStatus getStatus() {
        return status;
    }

    /**
     * Returns the Worker in this cell (may be null if no Worker is present).
     * It's always better to use getStatus to check for worker presence
     * before using this method, or use the isWorkerPresent method in 
     * the {@link Check} class
     *
     * @return a {@link Worker} object, or null if none.
     */
    public Worker getWorker() {
        return worker;
    }

    // SETTERS
    
    // TOWER RELATED
    
    /**
     * Attempts to level up the Tower in this cell.
     *
     * @return true if the tower leveled up successfully, false if it was already a dome.
     */
    public boolean levelUpTower() {
        return tower.levelUp();
    }

    // WORKER RELATED
    
    /**
     * Sets (places) a Worker in this cell. Also updates the status to PRESENT.
     *
     * @param worker The worker to place in this cell.
     */
    public void setWorker(Worker worker) {
        this.worker = worker;
        this.status = WorkerStatus.PRESENT;
    }

    /**
     * Removes the Worker from this cell, setting it to null and status to ABSENT.
     */
    public void removeWorker() {
        this.worker = null;
        this.status = WorkerStatus.ABSENT;
    }

    // UTILS
    
    /**
     * Checks if the tower in this cell has a dome.
     *
     * @return true if the tower is a dome, false otherwise.
     */
    public boolean isDome() {
        return tower.isDome();
    }

}