
package main.Santorini.gameComponents;

public class Cell {

    private static int xPos;
    private static int yPos;
    private static Tower tower;
    private static Worker worker;
    private static WorkerStatus status;

    public Cell(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.tower = 0;
        this.worker = null;
        this.status = WorkerStatus.ABSENT;
    }

    // Cell related
    public int[] getPos() {
        return new int[] {xPos, yPos};
    }

    // Getters
    // Tower related
    public Tower getTower() {
        return tower;
    }

    public int getHeight() {
        return tower.getHeight();
    }

    public WorkerStatus getStatus() {
        return status;
    }

    // Worker related
    public Worker getWorker() {
        return worker;
    }

    // Setters
    // Tower related
    public boolean levelUpTower() {
        return this.Tower.levelUp();
    }

    // Worker related
    public void setWorker(Worker worker) {
        this.worker = worker;
        this.status = WorkerStatus.PRESENT;
    }

    public void removeWorker() {
        this.worker = null;
        this.status = WorkerStatus.ABSENT;
    }

    // Utils
    public bool isDome() {
        return tower.isDome();
    }

}