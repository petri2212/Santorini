
package src.main.java.gameComponents;

import java.util.ArrayList;

import src.main.java.UI;

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
	private UI ui;

	/**
	 * Constructs a {@code GameController} with a given board, sets the initial
	 * {@link GameState} to STARTING, and randomly picks which player (RED or BLUE)
	 * goes first.
	 *
	 * @param board the {@link Board} to be used by the game.
	 */
	public GameManager(UI ui) {

		// this.board = board;
		// initializePlayers(redPlayer, bluePlayer);
		this.ui = ui;

	}

	public void start() {
		gameState = GameState.HOME;
		gameLoop();
	}

	/*
	 * private void initializePlayers(Player redPlayer, Player bluePlayer) {
	 * this.currentPlayer = new Random().nextBoolean() ? redPlayer : bluePlayer;
	 * this.opponentPlayer = (this.currentPlayer == redPlayer) ? bluePlayer :
	 * redPlayer;
	 * 
	 * }
	 */
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

		// Non funziona ancora, questa è giusto l'idea raffazzonata

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
			//aggiungere pagina vittoria
			print("Congratulazioni", players.get(turn).getName(), "hai vinto!!");
			print("Riprova di nuovo", players.get(turnOpp).getName());
			ui.showWinnerPage(this);
			break;

		case EXIT:
			System.exit(0);
			break;

		default:
			break;
		}

	}

	/**
	 * Updates the player turn and checks if this is the last turn to be done.
	 */
	/*public void updatePlayerTurnAndChangeState() {
		changeState(GameState.ENDED);
	}*/
	
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

	// TODO rimuovere più avanti
	// Odio scrivere System.Out.Print
	private void print(Object... args) {
		for (Object arg : args) {
			System.out.print(arg + " ");
		}
		System.out.println();
	}

}