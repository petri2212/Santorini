package src.main.java.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.main.java.Controller;
import src.main.java.gui.view.MainPageView;

import src.main.java.gameComponents.GameManager;
import src.main.java.gameComponents.GameState;
/**
 * This is the controller for the main page, it extends
 * Controller because of the MVC and takes its own view as a parameter.
 */
public class MainPageController extends Controller<MainPageView> {

	/**
	 * This is the constructor of the class.
	 * 
	 * @param model super from the controller class
	 * @param view  super from the controller class
	 */
	public MainPageController(GameManager model, MainPageView view) {
		super(model, view);
	}

	/**
	 * This is an override of the listener where there are the actions.
	 */
	public void initViewListeners() {
		view.actionNewGame = new ActionListener() {

			/**
			 * This is an action form the view and it returns to the insert player page.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.INSERT_PLAYERS);
			}
			
		};
		
		view.actionExit = new ActionListener() {
			
			/**
			 * This is an action form the view it ends the program.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.EXIT);
			}
		};
	}
}
