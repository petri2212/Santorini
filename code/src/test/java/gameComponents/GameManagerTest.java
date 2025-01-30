package src.test.java.gameComponents;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.gameComponents.GameManager;
import src.main.java.gameComponents.Player;
import src.main.java.gameComponents.PlayerColor;
import src.main.java.UI;

class GameManagerTest {

    private GameManager gameManager;
    private UI mockUI;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager(mockUI);
    }

    /*
     * This test aims to check basic GameManager functionality
     */
    @Test
    void testGameManagerInitialization() {
        assertNull(gameManager.getBoard(), "Board should be null before initialization");
        assertEquals(0, gameManager.getPlayerTurn(), "Initial turn should be 0");
    }

    /*
     * This test aims to check the setPlayers method functionality
     */
    @Test
    void testSetPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("A");
        Player player2 = new Player("B");
        players.add(player1);
        players.add(player2);
        gameManager.setPlayers(players);
        assertEquals(2, gameManager.getPlayers().size(), "Players list should contain two players");
        assertEquals(player1, gameManager.getPlayers().get(0), "First player should be Alice");
        assertEquals(player2, gameManager.getPlayers().get(1), "Second player should be Bob");
    }


}
