package src.test.java.gamecomponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gamecomponents.Player;

import src.main.java.gamecomponents.Worker;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("A");
    }

    /*
     * This test aims to check the basics of the Player class
     */
    @Test
    void testPlayerInitialization() {
        assertEquals("A", player.getName(), "Player name should be set correctly");
        assertNotNull(player.getWorkers(), "Workers array should not be null");
        assertEquals(2, player.getWorkers().length, "Player should have exactly two workers");
        for (Worker worker : player.getWorkers()) {
            assertNotNull(worker, "Worker should be initialized");
        }
    }

    /*
     * This test aims to check the getWorkers method functionality
     */
    @Test
    void testGetWorkers() {
        Worker[] workers = player.getWorkers();
        assertNotNull(workers, "Workers array should not be null");
        assertEquals(2, workers.length, "Workers array should have two workers");
        for (Worker worker : workers) {
            assertNotNull(worker, "Each worker should be initialized");
            // Since worker's player color is not set in Player constructor in the original code,
            // this may need to be adjusted based on actual implementation
        }
    }

    /*
     * This test aims to check the setName and getName methods functionality
     */
    @Test
    void testSetAndGetName() {
        player.setName("B");
        assertEquals("B", player.getName(), "Player name should be updated to Frank");
    }
}

