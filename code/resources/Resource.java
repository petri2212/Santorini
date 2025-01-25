package resources;

/**
 * Represents a generic external resource that can be loaded into the program.
 *
 * @param <T> is the type of resource
 */
public interface Resource<T> {

	/**
	 * Loads the external resource converting it in a Java usable object.
	 *
	 * @return T as a generic type of resource
	 */
	public T load();

}