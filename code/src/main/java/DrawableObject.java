package src.main.java;

import java.awt.Image;

/**
 * Can be used to assign a ResourceImage to an object. The object that
 * implements this interface must specify the ResourceImage in the getImage
 * method.
 */
public interface DrawableObject {

	/**
	 * @return the object image as a ResourceImage
	 */
	public Image getImage(int level);
}