package src.test.java.gamecomponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gamecomponents.Cell;
import src.main.java.gamecomponents.Tower;
import src.main.java.gamecomponents.Worker;
import src.main.java.gamecomponents.WorkerStatus;

class CellTest {

    private Cell cell;
    private Worker worker;

    @BeforeEach
    void setUp() {
        cell = new Cell(2, 3);
        worker = new Worker();
    }

    /*
     * This test aims to check basic cell initialization
     */
    @Test
    void testCellInitialization() {
        assertEquals(2, cell.getX(), "Cell X position should be 2");
        assertEquals(3, cell.getY(), "Cell Y position should be 3");
        assertNotNull(cell.getTower(), "Tower should be initialized");
        assertEquals(0, cell.getTower().getHeight(), "Initial tower height should be 0");
        assertFalse(cell.isDome(), "Initial tower should not be a dome");
        assertEquals(WorkerStatus.ABSENT, cell.getStatusWorker(), "Initial worker status should be ABSENT");
        assertNull(cell.getWorker(), "Initial worker should be null");
    }

    /*
     * This test aims to check the setWorker method functionality
     */
    @Test
    void testSetWorker() {
        cell.setWorker(worker);
        assertEquals(WorkerStatus.PRESENT, cell.getStatusWorker(), "Worker status should be PRESENT after setting worker");
        assertEquals(worker, cell.getWorker(), "Worker should be set correctly");
    }

    /*
     * This test aims to check the removeWorker method functionality
     */
    @Test
    void testRemoveWorker() {
        cell.setWorker(worker);
        cell.removeWorker();
        assertEquals(WorkerStatus.ABSENT, cell.getStatusWorker(), "Worker status should be ABSENT after removal");
        assertNull(cell.getWorker(), "Worker should be null after removal");
    }

    /* 
     * This test aims to check the levelUpTower method functionality
     */
    @Test
    void testLevelUpTower() {
        Tower tower = cell.getTower();
        assertTrue(cell.levelUpTower(), "First level up should be successful");
        assertEquals(1, tower.getHeight(), "Tower height should be 1 after first level up");
        assertFalse(tower.isDome(), "Tower should not be a dome at height 1");

        // Level up to dome
        cell.levelUpTower(); // height 2
        cell.levelUpTower(); // height 3 
        assertTrue(cell.levelUpTower(), "Level up to dome should be successful");
        assertEquals(4, tower.getHeight(), "Tower height should be 4");
        assertTrue(tower.isDome(), "Tower should be a dome at height 4");

        // Attempt to level up beyond dome
        assertFalse(cell.levelUpTower(), "Level up should fail when tower is already a dome");
        assertEquals(4, tower.getHeight(), "Tower height should remain at 4");
    }

    /* 
     * This test aims to check the isDome method functionality
     */
    @Test
    void testIsDome() {
        assertFalse(cell.isDome(), "Initial tower should not be a dome");
        cell.getTower().levelUp(); // height 1
        assertFalse(cell.isDome(), "Tower should not be a dome at height 1");
        // Level up to height 4
        cell.getTower().levelUp(); // height 2
        cell.getTower().levelUp(); // height 3
        cell.getTower().levelUp(); // height 4
        assertTrue(cell.isDome(), "Tower should be a dome at height 4");
    }

    /*
     * This test aims to check the getPos method functionality
     */
    @Test
    void testGetPos() {
        int[] pos = cell.getPos();
        assertNotNull(pos, "getPos should not return null");
        assertEquals(2, pos[0], "X position should match");
        assertEquals(3, pos[1], "Y position should match");
    }

    /*
     * This test aims to check the getHeight method functionality
     */
    @Test
    void testGetHeight() {
        assertEquals(0, cell.getHeight(), "Initial tower height should be 0");
        cell.getTower().levelUp();
        assertEquals(1, cell.getHeight(), "Tower height should be 1 after level up");
    }
}
