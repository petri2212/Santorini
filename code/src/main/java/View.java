package src.main.java;

import javax.sound.sampled.LineUnavailableException;

/**
 * Abstract class for the creation of View classes of the MVC design patter.
 * No business logic should be implemented in the concrete implementations of this class.
 */
public interface View {

	/**
	 * This method must be implemented specifically for every View, allowing to manage different
	 * types of input-output models.
	 * @throws LineUnavailableException 
	 */
	public abstract void show();

}
