package src.main.java.gui.view;

import java.awt.event.ActionListener;

import src.main.java.View;
import src.main.java.gamecomponents.Board;
import src.main.java.gamecomponents.Player;

public abstract class WinnerPageView implements View {
	
	public String winner;
	
	/**
	 * Those are all the actions declaration.
	 */

	public ActionListener actionReturnMainPage;
	
	/**
	 * Those methods are all setters for parameters of this class.
	 */
	public void setWinnerName(Player player) {
		this.winner = player.getName();
	}

}
