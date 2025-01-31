
package src.main.java.gamecomponents;


/**
 * The Board class holds a 2D array of Cell objects, representing a 5x5 grid in
 * the Santorini board game.
 */
public class Board {

	/**
	 * The height of the board (number of rows).
	 */
	private int height;

	/**
	 * The width of the board (number of columns).
	 */
	private int width;

	/**
	 * A 2D array representing the game board, where each cell can contain Towers or
	 * Workers.
	 */
	private Cell[][] board;

	/**
	 * Constructs a Board of size h x w (standard 5x5), initializing each cell with
	 * a new {@link Cell} instance.
	 * 
	 * @param height The height of the board (standard: 5).
	 * @param width  The width of the board (standard: 5).
	 */
	public Board(int height, int width) {

		this.height = height;
		this.width = width;
		this.board = new Cell[this.height][this.width];

		// Inizializzazione della board 5x5 composta da classi Cell
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.board[i][j] = new Cell(i, j);
			}
		}
	}

	/**
	 * Returns the entire 2D array of cells for this board.
	 *
	 * @return 2D array of Cell objects.
	 */
	public Cell[][] getBoard() {
		return board;
	}

	// GETTERS

	/**
	 * Returns the Cell at the specified coordinates.
	 *
	 * @param xPos The x-coordinate (row index).
	 * @param yPos The y-coordinate (column index).
	 * @return The {@link Cell} at [xPos][yPos].
	 */
	public Cell cellAt(int xPos, int yPos) {
		return board[xPos][yPos];
	}

	/**
	 * Returns the height of the whole board (standard rules: 5).
	 *
	 * @return the integer height of the board.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns the width of the whole board (standard rules: 5).
	 *
	 * @return the integer width of the board.
	 */
	public int getWidth() {
		return width;
	}
	

	// SETTERS

	// GAMESTATE.STARTING

	/**
	 * Places a Worker in the given coordinates on the board.
	 *
	 * @param worker The worker to place.
	 * @param xPos   The x-coordinate (row index).
	 * @param yPos   The y-coordinate (column index).
	 */
	public void placeWorker(Worker worker, int xPos, int yPos) {
		cellAt(xPos, yPos).setWorker(worker);
	}

	// GAMESTATE.RUNNING

	/**
	 * Moves a worker from one cell to another.
	 *
	 * @param worker The worker to move.
	 * @param sxPos  The starting x-coordinate.
	 * @param syPos  The starting y-coordinate.
	 * @param fxPos  The final x-coordinate.
	 * @param fyPos  The final y-coordinate.
	 */
	public void moveWorker(Worker worker, Cell iniciatlCell, Cell finalCell) {
		iniciatlCell.removeWorker();
		finalCell.setWorker(worker);
	}
	

	/**
	 * Builds (levels up) a tower at the specified coordinates.
	 *
	 * @param fxPos The x-coordinate where to build.
	 * @param fyPos The y-coordinate where to build.
	 */
	public void buildTower(Cell cell) {
		cell.getTower().levelUp();
	}
	
	
	
	

	// UTILS

	
     /* Finds the positions of two workers belonging to a specific player color.
     *
     * @param color The {@link PlayerColor} of the workers to find.
     * @return A 2D array of size [2][2], where each sub-array is [x, y].
     */
    public Cell[] findWorkersOf(Player player) {
   
        int count = 0;
        Cell[] positions = new Cell[2];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                Cell cell = cellAt(i, j);

                if (cell.getStatusWorker() == false) {
                    continue;
                }

                if (cell.getWorker().equals(player.getWorker(0)) || cell.getWorker().equals(player.getWorker(1))) {
                    positions[count] = cell;
                    count++;

                    if (count == 2) {
                        break;
                    }
                }
            }

            if (count == 2) {
                break;
            }
        }

        if (positions[0].getWorker().getID() > positions[1].getWorker().getID()) {
            Cell temp = positions[0];
            positions[0] = positions[1];
            positions[1] = temp;
        }

        return positions;
    }

}
