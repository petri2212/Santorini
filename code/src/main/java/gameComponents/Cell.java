
package src.main.java.gameComponents;

public class Cell {

    private int xPos;
    private int yPos;
    private Tower tower;
    private Worker worker;
    private WorkerStatus status;

    public Cell(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.tower = new Tower();
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
        return tower.levelUp();
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
    public boolean isDome() {
        return tower.isDome();
    }

}