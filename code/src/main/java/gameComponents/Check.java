package src.main.java.gameComponents;

import java.util.ArrayList;

/**
 * Provides static methods to validate moves, construction, and game statuses in
 * the Santorini board game.
 */
public class Check {


	/**
	 * Checks if the specified position is inside the board.
	 *
	 * @param board the {@link Board} object.
	 * @param xPos  the row index to check.
	 * @param yPos  the column index to check.
	 * @return true if [xPos, yPos] is within [0..4], false otherwise.
	 */
	public static boolean isInsideBoard(Board board, int xPos, int yPos) {
		return xPos >= 0 && xPos < board.getHeight() && yPos >= 0 && yPos < board.getWidth();
	}

	/**
	 * Checks if the move from [sxPos, syPos] to [fxPos, fyPos] is within one cell
	 * distance.
	 * 
	 * @param sxPos starting x-position.
	 * @param syPos starting y-position.
	 * @param fxPos final x-position.
	 * @param fyPos final y-position.
	 * @return false if it is the same cell or more than 1 cell away, true
	 *         otherwise.
	 */
	public static boolean isMoveCorrect(Cell startingCell, Cell finalCell) {
		if (startingCell.equals(finalCell))
			return false;
		int dx = Math.abs(finalCell.getX() - startingCell.getX());
		int dy = Math.abs(finalCell.getY() - startingCell.getY());
		return dx <= 1 && dy <= 1;
	}

	/**
	 * Checks if the Worker is present in the cell.
	 * 
	 * Note: The original code had inverted logic. Here we name it clearly:
	 * 
	 * @param board the {@link Board} object.
	 * @param xPos  the x-position of the cell.
	 * @param yPos  the y-position of the cell.
	 * @return true if a worker is present, false otherwise.
	 */
	public static boolean isWorkerPresent(Cell cell) {
		return cell.getStatusWorker() == true;
	}

	/**
	 * Checks if a movement from start to final positions is valid, considering the
	 * presence of a dome or another worker and the height difference.
	 *
	 * @param board the current {@link Board}.
	 * @param sxPos starting x-position.
	 * @param syPos starting y-position.
	 * @param fxPos final x-position.
	 * @param fyPos final y-position.
	 * @return true if the movement is valid, false otherwise.
	 */
	public static boolean isValidMovement(Cell startingCell, Cell finalCell) {
		if (finalCell.isDome())
			return false;
		if (isWorkerPresent(finalCell))
			return false;
		int startingHeight = startingCell.getTower().getHeight();
		int finalHeight = finalCell.getTower().getHeight();
		return (finalHeight - startingHeight) <= 1;
	}
	
	/**
	 * Check if the destination cell is around the worker.
	 *
	 * @param startingRow starting row of the worker.
	 * @param startingColumn starting column of the worker.
	 * @param finalRow destination row of the worker.
	 * @param finalColumn destination column of the worker.
	 * @param aroundWorkerCells an ArrayList of Cells that contains all the cells around the worker
	 * @param upLeftCell.....downRightCell cells arounf the worker
	 * @return true if a cell is into the board and if the selected cell is around the worker.
	 */
	
	public static boolean aroundWorkerAndTowerCells (Cell startingCell, Cell finalCell) {
		//Initialization of some variables and boardEnd wich is the max index in rows and cols of he borad
		int boardStart = 0;
		int boardEnd = 4;
		int cellX = 0;
		int cellY = 0;
		
		int startingRow = startingCell.getX();
		int startingColumn = startingCell.getY();

		int finalRow = finalCell.getX();
		int finalColumn = finalCell.getY();
		
		 ArrayList<Cell> aroundWorkerCells = new ArrayList<Cell>();
		 
		Cell upLeftCell = new Cell(startingRow - 1, startingColumn - 1);
		aroundWorkerCells.add(upLeftCell);
		
		Cell upCell = new Cell(startingRow, startingColumn - 1);
		aroundWorkerCells.add(upCell);
		
		Cell upRightCell = new Cell(startingRow + 1, startingColumn -1);
		aroundWorkerCells.add(upRightCell);
		
		Cell CenterleftCell = new Cell(startingRow - 1, startingColumn);
		aroundWorkerCells.add(CenterleftCell);
		
		Cell CenterRightCell = new Cell(startingRow + 1, startingColumn);
		aroundWorkerCells.add(CenterRightCell);
		
		Cell downLeftCell = new Cell(startingRow - 1, startingColumn + 1);
		aroundWorkerCells.add(downLeftCell);
		
		Cell downCell = new Cell(startingRow, startingColumn + 1);
		aroundWorkerCells.add(downCell);
		
		Cell downRightCell = new Cell(startingRow + 1, startingColumn + 1);
		aroundWorkerCells.add(downRightCell);
		
		for (Cell cell : aroundWorkerCells) {
			
			cellX = cell.getX();
			cellY = cell.getY();
			
			if((cellX <= boardEnd && cellX >= boardStart) && (cellY <= boardEnd && cellY >= boardStart)){
				
				if(finalRow == cellX && finalColumn == cellY ) {
					//this is for debug purpose
					System.out.println("the cll is :" + cellX + "  " + cellY );
					return true;
				}
			}
			
		}
		
		return false;
	}

	/**
	 * Checks if a Worker at [xPos, yPos] is on a tower of height 3 (winning
	 * condition).
	 *
	 * @param board the {@link Board} object.
	 * @param xPos  the x-position to check.
	 * @param yPos  the y-position to check.
	 * @return true if the cell's tower height is 3, false otherwise.
	 */
	public static boolean isWinCondition(Cell cell) {
		return cell.getTower().getHeight() == 3;
	}

	/**
	 * Checks if a construction on [fxPos, fyPos] is valid (not a dome).
	 *
	 * @param board the {@link Board} object.
	 * @param fxPos the x-position where the worker attempts to build.
	 * @param fyPos the y-position where the worker attempts to build.
	 * @return true if a new level can be built, false otherwise.
	 */
	public static boolean isValidConstruction(Cell cell) {
		return !cell.isDome();
	}

	/**
	 * Checks if any of the two workers of the current player can move.
	 * 
	 * @param board   the {@link Board} object.
	 * @param workers an array containing positions of the player's 2 workers, in
	 *                the form [[x1, y1], [x2, y2]].
	 * @return true if at least one worker can move, false if neither can move.
	 */
	public static boolean PossibleMovement(Board board, Cell[] workers) {

		for (int i = 0; i < 2; i++) {

			int workerxPos = workers[i].getX();
			int workeryPos = workers[i].getY();

			for (int dx = -1; dx <= 1; dx++) {
				for (int dy = -1; dy <= 1; dy++) {

					int xPos = workerxPos + dx;
					int yPos = workeryPos + dy;

					// sé stesso
					if (dx == 0 && dy == 0)
						continue;
					// fuori dalla board
					if (!isInsideBoard(board, xPos, yPos))
						continue;
					// è un movimento valido?
					if (!isValidMovement(workers[i], board.cellAt(xPos, yPos)))
						continue;
					return true;
				}
			}
		}
		return false; // nessun worker si può muovere ==> GameState.ENDED
	}

}
