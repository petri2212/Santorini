package resources;

import javax.swing.ImageIcon;

/**
 * Lists all the icons images used by the game.
 */
public enum Icons implements Resource<ImageIcon> {

	ICON_BLOCK_layer1("./assets/blocks/build_1.png"),
	ICON_BLOCK_layer2("./assets/blocks/build_2.png"),
	ICON_BLOCK_layer3("./assets/blocks/build_3.png"),
	ICON_BLOCK_Dome("./assets/blocks/dome.png"),
	SANTORINI_LOGO("./assets/Backgrounds/santorini-logo.png");
	

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
