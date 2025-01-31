package src.main.java.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.main.java.Controller;
import src.main.java.gamecomponents.GameManager;
import src.main.java.gamecomponents.GameState;
import src.main.java.gamecomponents.Player;
import src.main.java.gui.view.WinnerPageView;

/**
 * This is the controller for the Winning page, it extends Controller because of
 * the MVC and takes its own view as a parameter.
 */

public class WinnerPageController extends Controller<WinnerPageView> {
	
	private Player player;
	

	public WinnerPageController(GameManager model, WinnerPageView view) {
		super(model, view);
		
		ArrayList<Player> players = model.getPlayers();
		int playerTurn = model.getPlayerTurn();
		
		this.player = players.get(playerTurn);
		
		
		this.view.setWinnerName(this.player);	
		}

	@Override
	protected void initViewListeners() {
		// TODO Auto-generated method stub
		
		view.actionReturnMainPage = new ActionListener() {

			/**
			 * This is an action from the view and it returns to home page.
			 */
			public void actionPerformed(ActionEvent e) {
				model.changeState(GameState.HOME);
			}
		};
		
	}

}
