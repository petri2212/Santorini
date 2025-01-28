
package src.main.java.gameComponents;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

// TODO rimuovere quando abbiamo la GUI
import java.util.Scanner;

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
	private Player currentPlayer;
	private Player opponentPlayer;
	private Player winner;
	private Player looser;
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
			this.winner = null;
			this.looser = null;
			players = new ArrayList<>();
			ui.showMainPage(this);

			// // in un for loop per 2 volte VV
			//
			// // per 2 volte, per ogni player
			// // il player sceglie dove piazzare il worker (a caso in questo esempio)
			// int xPos = 1;
			// int yPos = 1;
			// // check per vedere se può con if
			// Check.isWorkerPresent(board, xPos, yPos);
			// // se può lo mette
			// player = PlayerColor.RED; // giusto come esempio qui
			// board.placeWorker(player, xPos, yPos);
			// // così un'altra volta e anche per il secondo giocatore
			// // CAMBIO TURNO
			// // DOPO CAMBIO TURNO ==> GAMESTATE.RUNNING
			// break;
			/*
			 * for (int i = 0; i < 2; i++) {
			 * 
			 * for (int j = 0; j < 2; j ++) {
			 * 
			 * // TODO AGGANCIO GUI QUI // TODO QUI LA GUI PASSERA UNA CLASSE CELL A QUESTA
			 * PARTE DI CODICE, E IN BASE // A SE LA CELL È OCCUPATA O MENO DARÀ POSITIVO O
			 * NEGATIVO
			 * 
			 * boolean correct = false; while (!correct) {
			 * 
			 * int xPos = input("Inserisci la posizione x del worker: ", 0,
			 * this.board.getWidth()); int yPos =
			 * input("Inserisci la posizione y del worker: ", 0, this.board.getHeight());
			 * 
			 * Cell cell = board.cellAt(xPos, yPos);
			 * 
			 * if (!Check.isWorkerPresent(cell)) {
			 * board.placeWorker(currentPlayer.getWorkers()[i], xPos, yPos); correct = true;
			 * } else { print("Hai scelto un posto già occupato!"); } } }
			 * 
			 * 
			 * cambioTurno();
			 * 
			 * }
			 */

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
			// // while loop finché una delle due condizioni di vittoria non sono vere VV
			//
			// // check per vedere se i worker del player attuale si possono muovere
			// Worker workers[][] = board.findWorkersOf(player);
			// Check.PossibleMovement(board, workers);
			// // se questa funzione torna falso vince il giocatore AVVERSARIO!!
			// // ==> GAMESTATE.ENDED
			//
			// // il giocatore sceglie uno dei suoi due workers
			// // TODO da implementare con la gui questo.
			//
			// // prova a muoversi da dove si trova
			// // chosenWorker = worker scelto
			//
			// currentxPos = 1;
			// currentyPos = 1;
			// desiredxPos = 2;
			// desiredyPos = 1;
			// // check per vedere se la mossa è nel 3x3 intorno al player con if
			// Check.isMoveCorrect(currentxPos, currentyPos, desiredxPos, desiredyPos);
			// // check per vedere se il movimento è possibile (no celle già occupate o
			// dome) con if
			// board.isValidMovement(board, currentxPos, currentyPos, desiredxPos,
			// desiredyPos);
			// // se possibile si sposta il worker
			// board.moveWorker(chosenWorker, currentxPos, currentyPos, desiredxPos,
			// desiredyPos)
			// // check per vedere se il worker è su un terzo livello con un if
			// Check.WinCondition(board, desiredxPos, desiredyPos);
			// // SE VERO ==> GAMESTATE.ENDED
			//
			// // seleziona una casella dove costruire
			// desiredxPos = 3;
			// desiredyPos = 2;
			// // check per vedere se la mossa è nel 3x3 intorno al player con if
			// Check.isMoveCorrect(currentxPos, currentyPos, desiredxPos, desiredyPos);
			// // check per vedere se la costruzione è possibile (non è dome) con if
			// Check.isValidConstruction(board, desiredxPos, desiredyPos);
			// // se possibile livella la torre di quella cell
			// board.buildTower(desiredxPos, desiredyPos);
			// CAMBIO TURNO
			/*
			 * while (winner == null) {
			 * 
			 * // Troviamo i worker del current player Cell workerCells[] =
			 * board.findWorkersOf(currentPlayer);
			 * 
			 * // WIN CONDITION // Vediamo se si possono muovere if
			 * (!Check.PossibleMovement(board, workerCells)) { this.winner = opponentPlayer;
			 * this.looser = currentPlayer; nextGameState(); break; }
			 * 
			 * // TODO rimuovere quando abbiamo una GUI print("I tuoi worker si trovano in",
			 * workerCells);
			 * 
			 * // TODO AGGANCIO GUI QUI // QUI LA GUI EVIDENZIERÀ I DUE WORKER DELLA PERSONA
			 * CHE DEVE GIOCARE // E NE SCEGLIERÀ UNA E PASSERÀ LA CLASSE CELL QUI // Il
			 * giocatore seleziona un worker, qui scegliamo giusto il primo Cell
			 * startingCell = workerCells[0];
			 * 
			 * boolean correct = false; Cell finalCell = null; while (!correct) {
			 * 
			 * // TODO AGGANCIO GUI QUI // QUI LA GUI EVIDENZIERÀ IL 3X3 INTORNO AL WORKER
			 * SCELTO // E PASSERÀ LA CLASSE CELL SCELTA QUI // Il giocatore sceglie la cell
			 * dove muoversi, anche qui dato dalla gui finalCell = board.cellAt(2, 2);
			 * 
			 * // Controllo se il movimento è corretto (3x3 intorno al worker) if
			 * (!Check.isMoveCorrect(startingCell, finalCell)) continue; // Controllo se il
			 * movimento è possibile if (!Check.isValidMovement(startingCell, finalCell))
			 * continue;
			 * 
			 * correct = true;
			 * 
			 * }
			 * 
			 * // Muoviamo il worker board.moveWorker(startingCell.getWorker(),
			 * startingCell, finalCell);
			 * 
			 * // Calcoliamo la win condition se il worker si trova su un "terzo" piano if
			 * (Check.isWinCondition(finalCell)) { this.winner = currentPlayer; this.looser
			 * = opponentPlayer; nextGameState(); break; }
			 * 
			 * // Il giocatore sceglie una casella intorno al suo worker dove costruire
			 * correct = false; finalCell = null; while (!correct) {
			 * 
			 * // TODO AGGANCIO GUI QUI // QUI LA GUI PASSERÀ LA CLASSE CELL DI DOVE IL
			 * GIOCATORE VUOLE COSTRUIRE // Il giocatore sceglie la cell dove costruire,
			 * anche qui dato dalla gui finalCell = board.cellAt(2, 2);
			 * 
			 * // Controllo se il movimento è corretto (3x3 intorno al worker) if
			 * (!Check.isMoveCorrect(startingCell, finalCell)) continue; // Controllo se la
			 * costruzione è possibile if (!Check.isValidConstruction(finalCell)) continue;
			 * 
			 * correct = true;
			 * 
			 * }
			 * 
			 * // Costruiamo in quella cell board.buildTower(finalCell);
			 * 
			 * cambioTurno();
			 * 
			 * }
			 */
			break;
			
			
		case CONTROLS:
			updatePlayerTurnAndChangeState();
			break;

		case ENDED:
			// qui ci si arriva se qualcuno o è arrivato al terzo piano oppure ha entrambi
			// gli worker che non si riescono a muovere, in ogni caso ora
			// è parte della gui festeggiare per la vittoria/sconfitta 🥳🥳

			print("Congratulazioni", winner, "hai vinto!!");
			print("Riprova di nuovo", looser);

			break;

		case EXIT:
			System.exit(0);
			break;

		default:
			// se sei arrivato qui... ehm.. piacere... ? ora puoi tornare negli altri case
			// sopra dello switch??
			break;
		}

	}
	/**
	 * Updates the player turn and checks if this is the last turn to be done.
	 */
	public void updatePlayerTurnAndChangeState() {
		if (turn < players.size() - 1) {
			turn++;
			turnOpp=0;
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

	/*
	 * private void cambioTurno() { // Swap players Player temp =
	 * this.currentPlayer; this.currentPlayer = this.opponentPlayer;
	 * this.opponentPlayer = temp;
	 * 
	 * // Swap turno this.turn = (this.turn == PlayerColor.RED) ? PlayerColor.BLUE :
	 * PlayerColor.RED; }
	 */

	/*
	 * private void nextGameState() {
	 * 
	 * switch (this.gameState) { case STARTING: this.gameState = GameState.RUNNING;
	 * break; case RUNNING: this.gameState = GameState.ENDED; break; case ENDED: //
	 * TODO vedere cosa fare qui, se chiudere il gioco o ricominciare this.gameState
	 * = GameState.IDLE; break; default: print("Ehm..."); } }
	 */
	
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

	// TODO rimuovere più avanti
	private int input(String str, int min, int max) {
		print(str);
		Scanner scanner = new Scanner(System.in);
		int number = -1;
		boolean valid = false;

		while (!valid) {
			try {
				if (scanner.hasNextInt()) {
					number = scanner.nextInt();
					if (number >= min && number <= max) {
						valid = true;
					} else {
						print("Errore, il numero deve essere tra", min, "e", max);
					}
				} else {
					print("Errore, non era un numero!");
					scanner.next();
				}
			} catch (Exception e) {
				print("Si è verificato un errore. Riprova.");
			}
		}

		scanner.close();
		return number;
	}

}