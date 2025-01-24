
package src.main.java.gameComponents;

/**
 * A thread-safe singleton class generating unique incremental IDs. It's
 * used in the classes {@link Player} and {@link Worker}.
 */
public class IDMaker {

    private static IDMaker instance;
    private int currentID;

    /**
     * Private constructor to enforce singleton usage.
     */
    private IDMaker() {
        currentID = 0;
    }

    /**
     * Returns the single instance of {@code IDMaker}. Creates one if it does not exist.
     *
     * @return the singleton instance of {@code IDMaker}.
     */
    public static IDMaker getInstance() {
        if (instance == null) {
            synchronized (IDMaker.class) {
                if (instance == null) {
                    instance = new IDMaker();
                }
            }
        }
        return instance;
    }

    /**
     * Increments and returns the next unique ID.
     *
     * @return the next integer ID.
     */
    public synchronized int getNextID() {
        return ++currentID;
    }

    /**
     * Returns the current value of the incremental ID
     * without incrementing it.
     *
     * @return the current integer ID.
     */
    public synchronized int getCurrentID() {
        return currentID;
    }

}