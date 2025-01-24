package src.main.java.gameComponents;

/**
 * Provides static methods to validate moves, construction, and
 * game statuses in the Santorini board game.
 */
public class Check {

    // Check generali
    // Prefissi: s = starting, f = final

    /**
     * Checks if the specified position is inside the board.
     *
     *@param board the {@link Board} object.
     * @param xPos the row index to check.
     * @param yPos the column index to check.
     * @return true if [xPos, yPos] is within [0..4], false otherwise.
     */
    public static boolean isInsideBoard(Board board, int xPos, int yPos) {
    	// Non dovrebbe servire se c'è già un check nella GUI, ma nel caso è qui
        if ((xPos < 0 || xPos > board.getWidth()) || (yPos < 0 || yPos > board.getHeight())) return false;
        return true;
    }

    /**
     * Checks if the move from [sxPos, syPos] to [fxPos, fyPos] is within one cell distance.
     * 
     * @param sxPos starting x-position.
     * @param syPos starting y-position.
     * @param fxPos final x-position.
     * @param fyPos final y-position.
     * @return false if it is the same cell or more than 1 cell away, true otherwise.
     */
    public static boolean isMoveCorrect(Cell startingCell, Cell finalCell) {
    	int sxPos = startingCell.getPos()[0], syPos = startingCell.getPos()[1];
    	int fxPos = finalCell.getPos()[0], fyPos = finalCell.getPos()[1];
        if (sxPos == fxPos && syPos == fyPos) return false; // non si è mosso
        if (Math.abs(fxPos - sxPos) > 1 || Math.abs(fyPos - syPos) > 1) return false;
        return true;
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
    	return cell.getStatus() == WorkerStatus.PRESENT;
    }

    /**
     * Checks if a movement from start to final positions is valid,
     * considering the presence of a dome or another worker and the height difference.
     *
     * @param board the current {@link Board}.
     * @param sxPos starting x-position.
     * @param syPos starting y-position.
     * @param fxPos final x-position.
     * @param fyPos final y-position.
     * @return true if the movement is valid, false otherwise.
     */
    public static boolean isValidMovement(Board board, Cell startingCell, Cell finalCell) {

    	int sxPos = startingCell.getPos()[0], syPos = startingCell.getPos()[1];
    	int fxPos = finalCell.getPos()[0], fyPos = finalCell.getPos()[1];
    	
        if (board.cellAt(fxPos, fyPos).getTower().isDome()) return false;
        if (isWorkerPresent(finalCell)) return false;

        int startingHeight = board.cellAt(sxPos, syPos).getTower().getHeight();
        int finalHeight = board.cellAt(fxPos, fyPos).getTower().getHeight();
        if (finalHeight - startingHeight > 1) return false; // non può salire su una torre più alta di +1
        return true;

    }

    /**
     * Checks if a Worker at [xPos, yPos] is on a tower of height 3 (winning condition).
     *
     * @param board the {@link Board} object.
     * @param xPos  the x-position to check.
     * @param yPos  the y-position to check.
     * @return true if the cell's tower height is 3, false otherwise.
     */
    public static boolean WinCondition(Cell cell) {
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
        return cell.getTower().isDome() == false;

    }

    /**
     * Checks if any of the two workers of the current player can move.
     * 
     * @param board   the {@link Board} object.
     * @param workers an array containing positions of the player's 2 workers,
     *                in the form [[x1, y1], [x2, y2]].
     * @return true if at least one worker can move, false if neither can move.
     */
    public static boolean PossibleMovement(Board board, Cell[] workers) {

        for (int i = 0; i < 2; i++) {
	
        	int workerxPos = workers[i].getPos()[0], workeryPos = workers[i].getPos()[1];
        
            int starting_height = board.cellAt(workerxPos, workeryPos).getTower().getHeight();

            int verticalRange = board.getHeight() - 1;
            int horizontalRange = board.getWidth() - 1;
            
            int leftRange = clamp(0, workerxPos - 1, horizontalRange);
            int rightRange = clamp(0, workerxPos + 1, horizontalRange);
            int upRange = clamp(0, workeryPos - 1, verticalRange);
            int downRange = clamp(0, workeryPos + 1, verticalRange);

            for (int x = leftRange; x <= rightRange; x++) {
                for (int y = upRange; y <= downRange; y++) {

                    if (x == workerxPos && y == workeryPos) continue; // sé stesso
                    if (board.cellAt(x, y).getTower().isDome()) continue; // il worker non può salire su un dome

                    if (board.cellAt(x, y).getTower().getHeight() <= 1 + starting_height) {
                        // un worker si può muovere
                        return true;
                    }
                }
            }
        }

        return false; // nessun worker si può muovere ==> GameState.ENDED
    }

    // UTILS

    /**
     * Clamps the integer n between min and max.
     *
     * @param min the minimum value.
     * @param n   the value to clamp.
     * @param max the maximum value.
     * @return the clamped value.
     */
    private static int clamp(int min, int n, int max) {
        // Non avevo voglia di stare a scrivere minmax ovunque
        return Math.max(min, Math.min(max, n));
    }
	
}
