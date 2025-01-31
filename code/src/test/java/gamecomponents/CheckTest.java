package src.test.java.gamecomponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gamecomponents.Board;
import src.main.java.gamecomponents.Cell;
import src.main.java.gamecomponents.Check;
import src.main.java.gamecomponents.Player;
import src.main.java.gamecomponents.Worker;

class CheckTest {

    private Board board;
    private Player playerRed;
    private Player playerBlue;
    private Worker redWorker1;
    private Worker redWorker2;
    private Worker blueWorker1;

    @BeforeEach
    void setUp() {
        board = new Board(5, 5);
        playerRed = new Player("A");
        redWorker1 = playerRed.getWorkers()[0];
        redWorker2 = playerRed.getWorkers()[1];
        playerBlue = new Player("B");
        blueWorker1 = playerBlue.getWorkers()[0];
    }

    /*
     * This test aims to check the isInsideBoard method functionality
     */
    @Test
    void testIsInsideBoard() {
        assertTrue(Check.isInsideBoard(board, 0, 0), "Position (0,0) should be inside the board");
        assertTrue(Check.isInsideBoard(board, 4, 4), "Position (4,4) should be inside the board");
        assertFalse(Check.isInsideBoard(board, -1, 0), "Negative X should be outside the board");
        assertFalse(Check.isInsideBoard(board, 0, -1), "Negative Y should be outside the board");
        assertFalse(Check.isInsideBoard(board, 5, 5), "Position (5,5) should be outside the board");
        assertFalse(Check.isInsideBoard(board, 2, 5), "Y=5 should be outside the board");
        assertFalse(Check.isInsideBoard(board, 5, 2), "X=5 should be outside the board");
    }

    /*
     * This test aims to check the isMoveCorrect method functionality
     */
    @Test
    void testIsMoveCorrect() {
        Cell start = board.cellAt(2, 2);
        Cell same = board.cellAt(2, 2);
        Cell adjacent = board.cellAt(2, 3);
        Cell diagonal = board.cellAt(3, 3);
        Cell far = board.cellAt(4, 4);

        assertFalse(Check.isMoveCorrect(start, same), "Moving to the same cell should be incorrect");
        assertTrue(Check.isMoveCorrect(start, adjacent), "Moving to an adjacent cell should be correct");
        assertTrue(Check.isMoveCorrect(start, diagonal), "Moving to a diagonally adjacent cell should be correct");
        assertFalse(Check.isMoveCorrect(start, far), "Moving more than one cell away should be incorrect");
    }

    /*
     * This test aims to check the isWorkerPresent method functionality
     */
    @Test
    void testIsWorkerPresent() {
        Cell cellWithWorker = board.cellAt(1, 1);
        assertFalse(Check.isWorkerPresent(cellWithWorker), "Initially, worker should not be present");
        Worker worker = playerRed.getWorkers()[0];
        cellWithWorker.setWorker(worker);
        assertTrue(Check.isWorkerPresent(cellWithWorker), "Worker should be present after setting");
        cellWithWorker.removeWorker();
        assertFalse(Check.isWorkerPresent(cellWithWorker), "Worker should not be present after removal");
    }

    /*
     * This test aims to check the isValidMovement method functionality
     */
    @Test
    void testIsValidMovement() {
        Cell start = board.cellAt(2, 2);
        Cell end = board.cellAt(2, 3);
        start.setWorker(redWorker1);
        // No tower height difference
        assertTrue(Check.isValidMovement(start, end), "Valid movement with no height difference");

        // Increase height by 1
        end.getTower().levelUp();
        assertTrue(Check.isValidMovement(start, end), "Valid movement with height difference of +1");

        // Increase height by 2
        end.getTower().levelUp();
        assertFalse(Check.isValidMovement(start, end), "Invalid movement with height difference of +2");

        // Place a dome
        end.getTower().levelUp(); // height 3
        end.getTower().levelUp(); // height 4 (dome)
        Cell anotherEnd = board.cellAt(3, 3);
        anotherEnd.setWorker(blueWorker1);
        assertFalse(Check.isValidMovement(start, anotherEnd), "Invalid movement to a cell with a worker");

        // Movement to a dome
        Cell domeCell = board.cellAt(1, 1);
        domeCell.getTower().levelUp(); // height 1
        domeCell.getTower().levelUp(); // height 2
        domeCell.getTower().levelUp(); // height 3
        domeCell.getTower().levelUp(); // height 4 (dome)
        assertFalse(Check.isValidMovement(start, domeCell), "Invalid movement to a cell with a dome");
    }

    /* 
     * This test aims to check the isWinCondition method functionality
     */
    @Test
    void testIsWinCondition() {
        Cell cell = board.cellAt(4, 4);
        assertFalse(Check.isWinCondition(cell), "Win condition should be false initially");
        cell.getTower().levelUp();
        cell.getTower().levelUp();
        cell.getTower().levelUp();
        assertTrue(Check.isWinCondition(cell), "Win condition should be true");
    }

    /*
     * This test aims to check the isValidConstruction method functionality
     */
    @Test
    void testIsValidConstruction() {
        Cell cell = board.cellAt(0, 0);
        assertTrue(Check.isValidConstruction(cell), "Construction should be valid initially");
        cell.getTower().levelUp(); // height 1
        assertTrue(Check.isValidConstruction(cell), "Construction should be valid at height 1");
        // Build up to dome
        cell.getTower().levelUp(); // height 2
        cell.getTower().levelUp(); // height 3 
        cell.getTower().levelUp(); // height 4 (dome)
        assertFalse(Check.isValidConstruction(cell), "Construction should be invalid at dome level");
    }

    /*
     * This test aims to check the possibleMovement method functionality
     */
    @Test
    void testPossibleMovement() {
        // Place workers
        board.placeWorker(redWorker1, 2, 2);
        board.placeWorker(redWorker2, 4, 4);
        Cell[] workers = board.findWorkersOf(playerRed);
        assertNotNull(workers, "Workers should not be null");
        assertEquals(2, workers.length, "There should be two workers");

        // No towers or workers blocking
        assertTrue(Check.PossibleMovement(board, workers), "Possible movement should be true when movement is available");

        // Block all surrounding cells for first worker
        Cell worker1 = workers[0];
        for (int dx = -1; dx <=1; dx++) {
            for (int dy = -1; dy <=1; dy++) {
                if (dx ==0 && dy==0) continue; 
                int newX = worker1.getX() + dx;
                int newY = worker1.getY() + dy;
                if (Check.isInsideBoard(board, newX, newY)) {
                    Cell cell = board.cellAt(newX, newY);
                    cell.setWorker(new Worker()); // Place a worker to block
                }
            }
        }

        // Check possible movement still possible for second worker
        assertTrue(Check.PossibleMovement(board, workers), "Possible movement should be true for second worker");

        // Block all movement for second worker
        Cell worker2 = workers[1];
        for (int dx = -1; dx <=1; dx++) {
            for (int dy = -1; dy <=1; dy++) {
                if (dx ==0 && dy==0) continue;
                int newX = worker2.getX() + dx;
                int newY = worker2.getY() + dy;
                if (Check.isInsideBoard(board, newX, newY)) {
                    Cell cell = board.cellAt(newX, newY);
                    cell.setWorker(new Worker()); // Place a worker to block
                }
            }
        }

        assertFalse(Check.PossibleMovement(board, workers), "Possible movement should be false when all workers are blocked");
    }
}
