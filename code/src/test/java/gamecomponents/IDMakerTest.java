package src.test.java.gamecomponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.main.java.gamecomponents.IDMaker;

class IDMakerTest {

	/*
	 * This test aims to check the basics of the IDMaker instancing
	 */
    @Test
    void testSingletonInstance() {
        IDMaker instance1 = IDMaker.getInstance();
        IDMaker instance2 = IDMaker.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same (singleton)");
    }

    /* 
     * This test aims to check the getNextID method functionality
     */
    @Test
    void testGetNextID() {
        IDMaker idMaker = IDMaker.getInstance();
        int initialID = idMaker.getCurrentID();
        int nextID = idMaker.getNextID();
        assertEquals(initialID + 1, nextID, "Next ID should be initial ID + 1");
        assertEquals(nextID, idMaker.getCurrentID(), "Current ID should be updated to next ID");
    }

    /*
     * This test aims to check the getCurrentID method functionality
     */
    @Test
    void testGetCurrentID() {
        IDMaker idMaker = IDMaker.getInstance();
        int currentID = idMaker.getCurrentID();
        assertEquals(currentID, idMaker.getCurrentID(), "Current ID should remain the same when not incremented");
    }
}
