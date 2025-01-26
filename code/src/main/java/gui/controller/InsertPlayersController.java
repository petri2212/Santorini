package src.main.java.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.main.java.Controller;
import src.main.java.gui.view.InsertPlayersView;
import src.main.java.gameComponents.GameManager;
import src.main.java.gameComponents.GameState;
import src.main.java.Main;
import src.main.java.gameComponents.Player;
import src.main.java.gameComponents.PlayerColor;

/**
 * This is the controller for the insert players, it extends Controller because
 * of the MVC and takes its own view as a parameter.
 */
public class InsertPlayersController extends Controller<InsertPlayersView> {

	/**
	 * This is the constructor of the class.
	 * 
	 * @param model super from the controller class
	 * @param view  super from the controller class
	 */
	public InsertPlayersController(GameManager model, InsertPlayersView view) {
		super(model, view);
	}

	/**
	 * This is an override of the listener where there are the actions.
	 */
	protected void initViewListeners() {
		
		view.actionReturnMainPage = new ActionListener() {

			/**
			 * This is an action from the view and it returns to home page.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};

		view.actionInitGame = new ActionListener() {

			/**
			 * This is an action from the view check if there is
			 * the minimum number of players.
			 */
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = view.getInseredPlayers();

				if (players.size() < 2) {
					view.showTooFewPlayersWarning();
				} else {
					model.setPlayers(view.getInseredPlayers());
					model.changeState(GameState.INIT_GAME);
				}
			}
		};

		view.actionInsertPlayer = new ActionListener() {

			/**
			 * This is an action from the view try to insert a new player
			 * into he list with all the controls that it needs.
			 */
			public void actionPerformed(ActionEvent e) {
				ArrayList<Player> players = view.getInseredPlayers();
				String input = view.getInput();
				
				Player player = new Player(input);
				

				if (input == null || input.isEmpty()) {
					view.showInvalidInputWarning();
					return;
				} else if (players.contains(player)) {
					view.showDoublePlayersWarning();
					return;
				} else if (players.size() == 2) {
					view.showTooManyPlayersWarning();
				} else {
					view.insertPlayers(player);
					view.showInseredPlayer();
				}
			}
		};
	}

}