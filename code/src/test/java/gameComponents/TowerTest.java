package src.test.java.gameComponents;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gameComponents.Tower;

class TowerTest {

    private Tower tower;

    @BeforeEach
    void setUp() {
        tower = new Tower();
    }

    /*
     * This test aims to check the basics of the Tower class
     */
    @Test
    void testTowerInitialization() {
        assertEquals(0, tower.getHeight(), "Initial tower height should be 0");
        assertFalse(tower.isDome(), "Initial tower should not be a dome");
    }

    /*
     * This test aims to check the levelUp method functionality
     */
    @Test
    void testLevelUp() {
        // Level 1
        assertTrue(tower.levelUp(), "Level up to height 1 should be successful");
        assertEquals(1, tower.getHeight(), "Tower height should be 1");
        assertFalse(tower.isDome(), "Tower should not be a dome at height 1");

        // Level 2
        assertTrue(tower.levelUp(), "Level up to height 2 should be successful");
        assertEquals(2, tower.getHeight(), "Tower height should be 2");
        assertFalse(tower.isDome(), "Tower should not be a dome at height 2");

        // Level 3
        assertTrue(tower.levelUp(), "Level up to height 3 should be successful");
        assertEquals(3, tower.getHeight(), "Tower height should be 3");
        assertFalse(tower.isDome(), "Tower should not be a dome at height 3");

        // Level 4 (Dome)
        assertTrue(tower.levelUp(), "Level up to height 4 should be successful");
        assertEquals(4, tower.getHeight(), "Tower height should be 4");
        assertTrue(tower.isDome(), "Tower should be a dome at height 4");

        // Attempt to level up beyond dome
        assertFalse(tower.levelUp(), "Level up should fail when tower is already a dome");
        assertEquals(4, tower.getHeight(), "Tower height should remain at 4");
        assertTrue(tower.isDome(), "Tower should still be a dome");
    }

    /*
     * This test aims to check the isDome method functionality
     */
    @Test
    void testIsDome() {
        assertFalse(tower.isDome(), "Initial tower should not be a dome");
        for (int i = 0; i < 4; i++) {
            tower.levelUp();
        }
        assertTrue(tower.isDome(), "Tower should be a dome after 4 level ups");
    }

    /*
     * This test aims to check the getHeigth method functionality
     */
    @Test
    void testGetHeight() {
        assertEquals(0, tower.getHeight(), "Initial height should be 0");
        tower.levelUp();
        assertEquals(1, tower.getHeight(), "Height should be 1 after one level up");
    }
}
