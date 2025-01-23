
package main.Santorini.gameComponents;

public class Tower {

    private int height;
    private boolean isDome;

    public Tower() {
        this.height = 0;
        this.isDome = false;
    }

    // Getters
    public int getHeight() {
        return height;
    }

    public boolean isDome() {
        return isDome;
    }

    // Setters
    // Metodo per fare livellare una torre
    public boolean levelUp() {
        if (!this.isDome) {
            this.height++;
            if (this.height == 4) this.isDome = true;
            return true;
        }
        return false;
    }

}