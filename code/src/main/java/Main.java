package src.main.java;

import src.main.java.gameComponents.GameManager;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

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
     * and a {@link GameManager}, then starts the game's main loop.
     *
     * @param args command-line arguments (not used in this application).
     * @throws LineUnavailableException 
     * @throws IOException 
     * @throws UnsupportedAudioFileException 
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    	// inizializza una board 5x5
    	Board board = new Board(5, 5);
    	Player redPlayer = new Player(PlayerColor.RED);
    	Player bluePlayer = new Player(PlayerColor.BLUE);
    	UI ui = new GraphicUI();
    	
        GameManager game = new GameManager(board, redPlayer, bluePlayer, ui);
        // inizia il gioco
        File file = new File("honey.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
        game.gameLoop();
        
    }
}