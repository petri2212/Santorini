package src.test.java.gameComponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gameComponents.Player;
import src.main.java.gameComponents.PlayerColor;
import src.main.java.gameComponents.Worker;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("A", PlayerColor.RED);
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
            assertEquals(PlayerColor.RED, worker.getPlayer(), "Worker's player color should be null initially");
        }
    }

    /*
     * This test aims to check the setColor and getColor methods functionality
     */
    @Test
    void testSetAndGetColor() {
        assertEquals(PlayerColor.RED, player.getColor(), "Player color should be set to RED");
        player.setColor(PlayerColor.BLUE);
        assertEquals(PlayerColor.BLUE, player.getColor(), "Player color should be updated to BLUE");
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

    /*
     * This test aims to check the workers ownership logic
     */
    @Test
    void testWorkerOwnership() {
        Worker worker1 = player.getWorkers()[0];
        Worker worker2 = player.getWorkers()[1];
        assertEquals(PlayerColor.RED, worker1.getPlayer(), "Worker1 should belong to RED player");
        assertEquals(PlayerColor.RED, worker2.getPlayer(), "Worker2 should belong to RED player");
    }
}
