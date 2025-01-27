package src.main.java.gui.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import src.main.java.gameComponents.Board;
import src.main.java.View;

/**
 * This is an abstract class that implements the view interface. it is the
 * splitter for the graphic and the console for the game stage page.
 */
public abstract class GameStageView implements View {

	protected static final int MAX_PICKED_WORKERS = 1;
	private int isFirstTurn = 0;

	protected Board board;
	protected String playerName;

	/**
	 * Those are all the actions declaration.
	 */

	public ActionListener actionEndTurn;

	public ActionListener actionBuild;

	public ActionListener actionReturnMainPage;

	/**
	 * Those methods are all setters for parameters of this class.
	 */

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
