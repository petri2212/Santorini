
package main.Santorini.gameComponents;

public class Worker {

    private int ID id;
    private PlayerColor player;

    public Worker(PlayerColor player) {
        this.id = IDMAKER.getInstance().getNextID();
        this.player = player;
    }

    // Getters
    public int getID() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

}