package resources;

import javax.swing.ImageIcon;

/**
 * Lists all the icons images used by the game.
 */
public enum Icons implements Resource<ImageIcon> {

	FIRST_PLAYER_ICON("./assets/Backgrounds/f_player.png"), BOARD("./assets/Board/Board_resize.png"),
	SECOND_PLAYER_ICON("./assets/Backgrounds/s_player.png"), SANTORINI_LOGO("./assets/Backgrounds/santorini-logo.png");

	private String path;

	private Icons(String path) {
		this.path = path;
	}

	/**
	 * Loads an icon image from the specified path attribute.
	 *
	 * @return an ImageIcon object from the javax.swing package
	 */
	@Override
	public ImageIcon load() {
		return new ImageIcon(path);
	}

}
