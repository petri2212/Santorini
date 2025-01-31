package src.main.java;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

import src.main.java.gamecomponents.Board;
import src.main.java.gamecomponents.GameManager;

/**
 * The Main class is the entry point for the Santorini board game application.
 * It initializes the game board and controller and starts the game loop.
 */
public class Santorini {

	/**
	 * The entry point of the application. It initializes a {@link Board} and a
	 * {@link GameManager}, then starts the game's main loop.
	 *
	 * @param args command-line arguments (not used in this application).
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Ui ui = new GraphicUI();
		
		GameManager game = new GameManager(ui);
		// inizia il gioco
		
		File file = new File("./assets/music/back_sound.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);

		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		clip.start();
		FloatControl fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		fc.setValue(-40.0f);
		

		// System.out.println(clip.getLevel());

		game.start();

	}
}