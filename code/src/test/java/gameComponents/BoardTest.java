package src.test.java.gameComponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gameComponents.Board;
import src.main.java.gameComponents.Cell;
import src.main.java.gameComponents.Player;
import src.main.java.gameComponents.PlayerColor;
import src.main.java.gameComponents.Worker;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5, 5);
    }

    /*
     * This test aims to check basic board initialization
     */
    @Test
    void testBoardInitialization() {
        assertEquals(5, board.getHeight(), "Board height should be 5");
        assertEquals(5, board.getWidth(), "Board width should be 5");
        Cell[][] cells = board.getBoard();
        assertNotNull(cells, "Board cells should not be null");
        assertEquals(5, cells.length, "Board should have 5 rows");
        for (int i = 0; i < 5; i++) {
            assertEquals(5, cells[i].length, "Each row should have 5 columns");
            for (int j = 0; j < 5; j++) {
                assertNotNull(cells[i][j], "Each cell should be initialized");
                assertEquals(i, cells[i][j].getX(), "Cell X position mismatch");
                assertEquals(j, cells[i][j].getY(), "Cell Y position mismatch");
            }
        }
    }

    /*
     * This test aims to check basic Cell class logic
     */
    @Test
    void testCellAt() {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                Cell cell = board.cellAt(i, j);
                assertNotNull(cell, "Cell should not be null at position (" + i + "," + j + ")");
                assertEquals(i, cell.getX(), "Cell X position mismatch");
                assertEquals(j, cell.getY(), "Cell Y position mismatch");
            }
        }
    }

    /*
     * This test aims to check the placeWorker method functionality
     */
    @Test
    void testPlaceWorker() {
        Player player = new Player("A");
        Worker worker = player.getWorkers()[0];
        board.placeWorker(worker, 2, 3);
        Cell cell = board.cellAt(2, 3);
        assertEquals(worker, cell.getWorker(), "Worker should be placed at (2,3)");
        assertEquals(cell.getStatusWorker(), src.main.java.gameComponents.WorkerStatus.PRESENT, "Worker status should be PRESENT");
    }

    /* 
     * This test aims to check the moveWorker method functionality
     */
    @Test
    void testMoveWorker() {
        Player player = new Player("A");
        Worker worker = player.getWorkers()[0];
        board.placeWorker(worker, 1, 1);
        Cell startingCell = board.cellAt(1, 1);
        Cell finalCell = board.cellAt(2, 2);
        board.moveWorker(worker, startingCell, finalCell);
        assertNull(startingCell.getWorker(), "Starting cell should have no worker after move");
        assertEquals(worker, finalCell.getWorker(), "Worker should be moved to final cell");
    }

    /*
     * This test aims to check the buildTower method functionality
     */
    @Test
    void testBuildTower() {
        Cell cell = board.cellAt(0, 0);
        int initialHeight = cell.getHeight();
        board.buildTower(cell);
        assertEquals(initialHeight + 1, cell.getHeight(), "Tower height should increment by 1");
    }

    /*
     * This test aims to check the findWorkersOf method functionality
     */
    @Test
    void testFindWorkersOf() {
        Player player = new Player("A");
        Worker worker1 = player.getWorkers()[0];
        Worker worker2 = player.getWorkers()[1];
        board.placeWorker(worker1, 0, 0);
        board.placeWorker(worker2, 4, 4);
        Cell[] workers = board.findWorkersOf(player);
        assertNotNull(workers, "Workers array should not be null");
        assertEquals(2, workers.length, "Workers array should have 2 elements");
    }

    /*
     * This test aims to check the getBoard method functionality
     */
    @Test
    void testGetBoard() {
        Cell[][] cells = board.getBoard();
        assertNotNull(cells, "getBoard should not return null");
        assertEquals(5, cells.length, "Board should have 5 rows");
    }
}
