package resources;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Lists all the images used by the game.
 */

public enum Images implements Resource<Image> {

	MAIN_PAGE_BACKGROUND("./assets/Backgrounds/m_background_resized.png"),
	ICON_SANTORINI("./assets/Backgrounds/santorini.png");
	

	private String path;

	private Images(String path) {
		this.path = path;
	}

	/**
	 * Loads an image from the specified path attribute.
	 *
	 * @return an Image object from the java.awt package
	 */
	@Override
	public Image load() {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
