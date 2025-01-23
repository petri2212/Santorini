
package main.Santorini.gameComponents;

public class Player {

    private PlayerColor color;
    private Worker[] workers;

    public Player() {
        this.color = setColor();
        this.workers = new Worker[2];
        workers[0] = new Worker(color);
        workers[1] = new Worker(color);
    }

    // Setters
    private PlayerColor setColor() {

        id = IDMaker.getInstance().getNextID();
        if (id % 2 == 1) {
            return PlayerColor.RED;
        }
        return PlayerColor.BLUE;

    }

}