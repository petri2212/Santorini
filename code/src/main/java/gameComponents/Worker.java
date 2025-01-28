
package src.main.java.gameComponents;

import java.awt.Image;

import resources.Images;
import src.main.java.DrawableObject;

/**
 * Represents a worker in the Santorini board game. Each worker has a unique ID
 * and belongs to a specific {@link PlayerColor}.
 */
public class Worker{
	/*
	WORKER_RED(new Images[] { Images.ICON_WORKER_RED}),
	WORKER_BLUE(new Images[] { Images.ICON_WORKER_BLUE});
*/
	/** The unique ID of this worker, assigned by {@link IDMaker}. */
	private int id;
	/** The color of the player controlling this worker. */
	//private Images[] images;
	/**
	 * Constructs a Worker belonging to a specified player color. Also acquires a
	 * unique ID from {@link IDMaker}.
	 *
	 * @param player the {@link PlayerColor} owning this worker.
	 */
	public Worker() {
		this.id = IDMaker.getInstance().getNextID();
	//	this.player = player;
	}

	// GETTERS

	/**
	 * Returns the unique ID of this worker.
	 *
	 * @return the worker's ID.
	 */
	public int getID() {
		return id;
	}

	

	/**
	 * Returns the color of the player controlling this worker.
	 *
	 * @return the {@link PlayerColor}.
	 */
	/*
	public PlayerColor getPlayer() {
		return player;
	}*/

}