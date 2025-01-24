package src.main.java;

import src.main.java.gameComponents.GameController;
import src.main.java.gameComponents.Board;
import src.main.java.gameComponents.Player;
import src.main.java.gameComponents.PlayerColor;

/**
 * The Main class is the entry point for the Santorini board game application. 
 * It initializes the game board and controller and starts the game loop.
 */
public class Main {
	
    /**
     * The entry point of the application. It initializes a {@link Board}
     * and a {@link GameController}, then starts the game's main loop.
     *
     * @param args command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

    	// inizializza una board 5x5
    	Board board = new Board(5, 5);
    	Player redPlayer = new Player(PlayerColor.RED);
    	Player bluePlayer = new Player(PlayerColor.BLUE);
    	
        GameController game = new GameController(board, redPlayer, bluePlayer);
        // inizia il gioco
        game.gameLoop();
        
    }
}