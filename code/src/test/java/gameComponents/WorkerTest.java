package src.test.java.gameComponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.main.java.gameComponents.IDMaker;
import src.main.java.gameComponents.PlayerColor;
import src.main.java.gameComponents.Worker;

class WorkerTest {

	/*
	 * This test aims to check the basics of the Worker class
	 */
    @Test
    void testWorkerInitialization() {
        Worker worker = new Worker();
        assertTrue(worker.getID() > 0, "Worker ID should be greater than 0");
    }

	/*
	 * This test aims to check the uniqueness of the worker's ID
	 */
    @Test
    void testUniqueIDs() {
        IDMaker idMaker = IDMaker.getInstance();
        int initialID = idMaker.getCurrentID();
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        assertEquals(initialID + 1, worker1.getID(), "Worker1 ID should be initialID + 1");
        assertEquals(initialID + 2, worker2.getID(), "Worker2 ID should be initialID + 2");
    }

	/*
	 * This test aims to check the getID method functionality
	 */
    @Test
    void testGetID() {
        Worker worker = new Worker();
        assertEquals(IDMaker.getInstance().getCurrentID(), worker.getID(), "Worker ID should match current ID from IDMaker");
    }

}
