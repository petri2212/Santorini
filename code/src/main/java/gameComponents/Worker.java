
package src.main.java.gameComponents;

public class Worker {

    private int id;
    private PlayerColor player;

    public Worker(PlayerColor player) {
        this.id = IDMaker.getInstance().getNextID();
        this.player = player;
    }

    // Getters
    public int getID() {
        return id;
    }

    public PlayerColor getPlayer() {
        return player;
    }

}