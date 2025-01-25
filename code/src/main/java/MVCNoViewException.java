package src.main.java;
/**
 *This class has to handle the view exceptions
 */
public class MVCNoViewException extends RuntimeException {

	private static final long serialVersionUID = 8885426844032805934L;

	public MVCNoViewException() {
		super();
	}

	public MVCNoViewException(String message) {
		super(message);
	}
}
