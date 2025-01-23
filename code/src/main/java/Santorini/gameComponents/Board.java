
package main.Santorini.gameComponents;

public class Board {

    private Cell[][] board;
    private int height;
    private int width;

    public Board() {

        this.height = 5;
        this.width = 5;

        // Inizializzazione della board 5x5 composta da classi Cell
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.board[i][j] = Cell(i, j, null, null);
            }
        }
    }

    // Getters
    public Cell[][] getBoard() {
        return board;
    }

    public Cell cellAt(int xPos, int yPos) {
        return board[xPos, yPos];
    }

    
    // Setters
    // GAMESTATE.STARTING
    public void placeWorker(Worker worker, int xPos, int yPos) {
        cellAt(xPos,yPos).setWorker(worker, xPos, yPos)
    }

    // GAMESTATE.RUNNING
    public void moveWorker(Worker worker, int sxPos, int syPos, int fxPos, int fyPos) {
        cellAt(sxPos, syPos).removeWorker();
        cellAt(fxPos, fyPos).setWorker(worker)
    }
    
    public void buildTower(int fxPos, int fyPos) {
        cellAt(fxPos, fyPos).getTower().levelUp();
    }
    
    // Check generali
    // Prefissi: s = starting, f = final

    // Non dovrebbe servire se c'è già un check nella GUI, ma nel caso è qui
    public isInsideBoard(int xPos, int yPos) {
        if (fxPos < 0 || fxPos > 4) || (fyPos < 0 || fyPos > 4) return false;
        return true;
    }

    // Check per vedere se la casella scelta è nei dintorni 3x3 della casella di partenza
    public boolean isMoveCorrect(int sxPos, int syPos, int fxPos, int fyPos) {
        if (sxPos == fxPos && syPos == fyPos) return false; // non si è mosso
        if (Math.abs(fxPos - sxPos) > 1 || Math.abs(fyPos - syPos) > 1) return false;
        return true;
    }

    // Check per testare la presenza di worker in una Cell
    public boolean isWorkerPresent(int xPos, int yPos) {
        if (cellAt(xPos, yPos).getStatus() == WorkerStatus.ABSENT) return true;
        return false;
    }

    // Check per vedere se il movimento è valido
    public boolean isValidMovement(int sxPos, int syPos, int fxPos, int fyPos) {

        if cellAt(fxPos, fyPos).getTower().isDome() return false
        if isWorkerPresent(xPos, yPos) return false;

        int startingHeight = cellAt(sxPos, syPos).getTower().getHeight();
        int finalHeight = cellAt(fxPos, fyPos).getTower().getHeight();
        if finalHeight - startingHeight > 1 return false; // non può salire su una torre più alta di +1
        return true;

    }

    // Check se un worker è in una casella di altezza 3
    public boolean checkWinCondition(int xPos, int yPos) {
        if cellAt(xPos, yPos).getTower().getHeight() == 3 return true;
        return false;
    }

    // Check per vedere se la costruzione è valida
    public boolean isValidConstruction(int fxPos, int fyPos) {

        if cellAt(fxPos, fyPos).getTower.isDome() return false
        return true;

    }

    // Check per vedere se il movimento degli worker è possibile a inizio gioco
    public boolean checkPossibleMovement(int[][] workers) {

        for (int i = 0; i < 2; i++) {

            int workerxPos = workers[i][0];
            int workeryPos = workers[i][1];

            int starting_height = cellAt(workerxPos, workeryPos).getTower().getHeight();

            int leftRange = clamp(0, workerxPos - 1, 4);
            int rightRange = clamp(0, workerxPos + 1, 4);
            int upRange = clamp(0, workeryPos - 1, 4);
            int downRange = clamp(0, workerxPos + 1, 4);

            for (int x = leftRange; x <= rightRange; x++) {
                for (int y = upRange; y <= downRange; y++) {

                    if (x == workerxPos && y == workeryPos) continue // sé stesso
                    if (cellAt(x, y).getTower().isDome()) continue // il worker non può salire su un dome

                    if (cellAt(x, y).getTower().getHeight() <= 1 + starting_height) {
                        // un worker si può muovere
                        return true;
                    }
                }
            }
        }

        return false; // nessun worker si può muovere ==> GameState.ENDED
    }

    // Utils

    private clamp(int min, int n, int max) {
        // Non avevo voglia di stare a scrivere minmax ovunque
        return Math.max(min, Math.min(max, n));
    }

    // Metodo per trovare i worker di un player in base al suo colore,
    // ritorna 1 array di 2 array (le due posizioni [x, y])
    public int[][] findWorkersOf(PlayerColor color) {

        int count = 0;
        int[][] positions = new int[2][2];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {

                if (cellAt(i, j).getWorker().getPlayer() == color){
                    positions[count] == new int[] {i, j};
                    count++;

                    if count == 2 return positions;

                }
            }
        }
    }
    
}
