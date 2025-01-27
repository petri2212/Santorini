package src.main.java;

/**
 * This class has to handle the model exceptions
 */
public class MVCNoModelException extends RuntimeException {

	private static final long serialVersionUID = -7764095798580399612L;

	public MVCNoModelException() {
		super();
	}

	public MVCNoModelException(String message) {
		super(message);
	}
}
