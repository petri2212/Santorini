package src.main.java.gameComponents;

public class Check {

    // Check generali
    // Prefissi: s = starting, f = final

    // Non dovrebbe servire se c'è già un check nella GUI, ma nel caso è qui
    public static boolean isInsideBoard(int xPos, int yPos) {
        if ((xPos < 0 || xPos > 4) || (yPos < 0 || yPos > 4)) return false;
        return true;
    }

    // Check per vedere se la casella scelta è nei dintorni 3x3 della casella di partenza
    public static boolean isMoveCorrect(int sxPos, int syPos, int fxPos, int fyPos) {
        if (sxPos == fxPos && syPos == fyPos) return false; // non si è mosso
        if (Math.abs(fxPos - sxPos) > 1 || Math.abs(fyPos - syPos) > 1) return false;
        return true;
    }

    // Check per testare la presenza di worker in una Cell
    public static boolean isWorkerPresent(Board board, int xPos, int yPos) {
        if (board.cellAt(xPos, yPos).getStatus() == WorkerStatus.ABSENT) return true;
        return false;
    }

    // Check per vedere se il movimento è valido
    public static boolean isValidMovement(Board board, int sxPos, int syPos, int fxPos, int fyPos) {

        if (board.cellAt(fxPos, fyPos).getTower().isDome()) return false;
        if (isWorkerPresent(board, fxPos, fyPos)) return false;

        int startingHeight = board.cellAt(sxPos, syPos).getTower().getHeight();
        int finalHeight = board.cellAt(fxPos, fyPos).getTower().getHeight();
        if (finalHeight - startingHeight > 1) return false; // non può salire su una torre più alta di +1
        return true;

    }

    // Check se un worker è in una casella di altezza 3
    public static boolean WinCondition(Board board, int xPos, int yPos) {
        if (board.cellAt(xPos, yPos).getTower().getHeight() == 3) return true;
        return false;
    }

    // Check per vedere se la costruzione è valida
    public static boolean isValidConstruction(Board board, int fxPos, int fyPos) {

        if (board.cellAt(fxPos, fyPos).getTower().isDome()) return false;
        return true;

    }

    // Check per vedere se il movimento degli worker è possibile a inizio gioco
    public static boolean PossibleMovement(Board board, int[][] workers) {

        for (int i = 0; i < 2; i++) {

            int workerxPos = workers[i][0];
            int workeryPos = workers[i][1];

            int starting_height = board.cellAt(workerxPos, workeryPos).getTower().getHeight();

            int leftRange = clamp(0, workerxPos - 1, 4);
            int rightRange = clamp(0, workerxPos + 1, 4);
            int upRange = clamp(0, workeryPos - 1, 4);
            int downRange = clamp(0, workerxPos + 1, 4);

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

    // Utils

    private static int clamp(int min, int n, int max) {
        // Non avevo voglia di stare a scrivere minmax ovunque
        return Math.max(min, Math.min(max, n));
    }
	
}
