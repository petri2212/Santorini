
package src.main.java.gameComponents;

public class IDMaker {

    // Classe singleton per ottenere ID crescenti
    // Utilizzata nella clase Player e Worker per gli ID

    private static IDMaker instance;
    private int currentID;

    private IDMaker() {
        currentID = 0;
    }

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

    public synchronized int getNextID() {
        return ++currentID;
    }

    public synchronized int getCurrentID() {
        return currentID;
    }

}