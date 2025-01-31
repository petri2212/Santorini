
package src.main.java.gamecomponents;

import java.util.ArrayList;

import src.main.java.Ui;

/**
 * PROTOTYPE Controls the overall flow of the game, managing turn order and the
 * current {@link GameState}.
 */
public class GameManager {

	/** The main board of the game. */
	private Board board;
	/** The current player's turn, can be RED or BLUE. */
	private int turn;
	private int turnOpp = 1;
	private boolean isLastTurn;

	/** The current state of the game. */
	private GameState gameState;
	private ArrayList<Player> players;
	private Ui ui;

	/**
	 * Constructs a {@code GameController} with a given board, sets the initial
	 * {@link GameState} to STARTING, and randomly picks which player (RED or BLUE)
	 * goes first.
	 *
	 * @param board the {@link Board} to be used by the game.
	 */
	public GameManager(Ui ui) {

		// this.board = board;
		// initializePlayers(redPlayer, bluePlayer);
		this.ui = ui;

	}

	public void start() {
		gameState = GameState.HOME;
		gameLoop();
	}

	/**
	 * Set the current players.
	 *
	 * @param players is a list of players
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * Outlines the main game loop logic based on {@link GameState}.
	 */
	public void gameLoop() {
		switch (gameState) {

		case HOME:
			players = new ArrayList<>();
			ui.showMainPage(this);
			break;

		case INSERT_PLAYERS:
			ui.showInsertPlayersPage(this);
			break;

		case INIT_GAME:
			board = new Board(5, 5);
			changeState(GameState.GAME_STAGE);
			break;

		case GAME_STAGE:
			ui.showGameStagePage(this);
			break;

		case CONTROLS:
			Cell[] workerCells;
			workerCells = board.findWorkersOf(players.get(turn));
			for (Cell worker : workerCells) {
				if (Check.isWinCondition(worker)) {
					changeState(GameState.ENDED);
				}
			}
			if(gameState != GameState.ENDED) {
			updatePlayerTurnAndChangeState();
			}
			break;

		case ENDED:
			ui.showWinnerPage(this);
			break;

		case EXIT:
			System.exit(0);
			break;

		default:
			break;
		}

	}
	
	public void updatePlayerTurnAndChangeState() {
		
		
		
		if (turn < players.size() - 1) {
			turn++;
			turnOpp = 0;
			changeState(GameState.GAME_STAGE);
		} else {
			if (isLastTurn) {
				changeState(GameState.ENDED);
			} else {
				turnOpp++;
				turn = 0;
				changeState(GameState.GAME_STAGE);
			}
		}
	}
	

	public Board getBoard() {
		return board;
	}

	public int getPlayerTurn() {
		return this.turn;
	}

	public int getPlayerOppTurn() {
		return this.turnOpp;
	}

	/**
	 * @return the current playing players
	 */
	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public void changeState(GameState nextState) {
		this.gameState = nextState;
		gameLoop();
	}


}