package src.main.java.gui.view;

import java.awt.event.ActionListener;

import src.main.java.gameComponents.Board;
import src.main.java.gameComponents.Player;
import src.main.java.View;

/**
 * This is an abstract class that implements the view interface. it is the
 * splitter for the graphic and the console for the game stage page.
 */
public abstract class GameStageView implements View {

	protected static final int MAX_PICKED_WORKERS = 1;
	public boolean movePhase = true;
	public boolean buildPhase = false;
	public boolean isFirstTurn;
	public int turn;

	protected Board board;
	protected String playerName;
	protected String playerOpponent;
	public Player player;
	public Player opponent;

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

	public void setPlayerName(String playerName, String opponent) {
		this.playerName = playerName;
		this.playerOpponent = opponent;
	}
	public void setPlayerFirstTurn(boolean bol) {
		this.isFirstTurn = bol;
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getOpponent() {
		return opponent;
	}

	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	
	

}
