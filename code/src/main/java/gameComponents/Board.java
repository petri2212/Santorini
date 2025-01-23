
package src.main.java.gameComponents;

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
                this.board[i][j] = new Cell(i, j);
            }
        }
    }

    // Getters
    public Cell[][] getBoard() {
        return board;
    }

    public Cell cellAt(int xPos, int yPos) {
        return board[xPos][yPos];
    }
    
    // Setters
    // GAMESTATE.STARTING
    public void placeWorker(Worker worker, int xPos, int yPos) {
        cellAt(xPos,yPos).setWorker(worker);
    }

    // GAMESTATE.RUNNING
    public void moveWorker(Worker worker, int sxPos, int syPos, int fxPos, int fyPos) {
        cellAt(sxPos, syPos).removeWorker();
        cellAt(fxPos, fyPos).setWorker(worker);
    }
    
    public void buildTower(int fxPos, int fyPos) {
        cellAt(fxPos, fyPos).getTower().levelUp();
    }
    
    // Utils
    
    // Metodo per trovare i worker di un player in base al suo colore,
    // ritorna 1 array di 2 array (le due posizioni [x, y])
    public int[][] findWorkersOf(PlayerColor color) {

        int count = 0;
        int[][] positions = new int[2][2];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {

                if (cellAt(i, j).getWorker().getPlayer() == color) {
                    positions[count] = new int[] {i, j};
                    count++;

                    if (count == 2) return positions;

                }
            }
        }
        // ridondante, ma almeno non da' errore
		return positions;
    }
    
}
