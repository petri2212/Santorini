package src.main.java;

import javax.sound.sampled.LineUnavailableException;

import src.main.java.gameComponents.GameManager;

/**
 * Abstract class for the creation of Controller classes of the MVC design
 * patter. The Controller holds a reference to the model. The model is the
 * GameManager that contains the business logic.
 */
public abstract class Controller<T extends View> {

	protected GameManager model;
	protected T view;

	/**
	 * Stores the Model and the View references and initializes the View listeners.
	 * Null model will cause the constructor to throw a MVCNoModelException. Null
	 * view will cause the constructor to throw a MVCNoViewException.
	 *
	 * @param model is the reference to the GameManager instance that contains the
	 *              business logic
	 * @param view  is the reference to the View instance that contains the visual
	 *              output
	 */
	public Controller(GameManager model, T view) {
		if (model == null) {
			throw new MVCNoModelException();
		}

		if (view == null) {
			throw new MVCNoViewException();
		}

		this.model = model;
		this.view = view;

		initViewListeners();
	}

	/**
	 * Initializes the listeners of the controlled View. This method is called
	 * inside the constructor to be sure not to forget to call this method.
	 */
	protected abstract void initViewListeners();

	/**
	 * Loads the view and call the method show() of the View interface. Using this
	 * function instead of directly view.show() assures that the Controller is ready
	 * to manage the View inputs.
	 * 
	 * @throws LineUnavailableException
	 */
	public void start() {
		view.show();
	}
}