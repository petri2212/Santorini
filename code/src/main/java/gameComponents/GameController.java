
package src.main.java.gameComponents;
import java.util.Random;

public class GameController {

    private Board board;
    private PlayerColor turn;
    private GameState gameState;

    public GameController(Board board) {
        this.board = board;
        this.gameState = GameState.STARTING;
        int rng = new Random().nextInt(2);
        this.turn = PlayerColor.values()[rng];
    }

    public void gameLoop() {

        // Non funziona ancora, questa è giusto l'idea raffazzonata

        switch (gameState) {

            case STARTING:

//                // in un for loop per 2 volte VV
//
//                // per 2 volte, per ogni player
//                // il player sceglie dove piazzare il worker (a caso in questo esempio)
//                int xPos = 1;
//                int yPos = 1;
//                // check per vedere se può con if
//                board.checkWorkerPresence(xPos, yPos);
//                // se può lo mette
//                player = PlayerColor.RED;
//                board.placeWorker(player, xPos, yPos);
//                // così un'altra volta e anche per il secondo giocatore
//                // CAMBIO TURNO
//                // DOPO CAMBIO TURNO ==> GAMESTATE.RUNNING
//                break;

            case RUNNING:

//                // while loop finché una delle due condizioni di vittoria non sono vere VV
//
//                // check per vedere se i worker del player attuale si possono muovere
//                Worker workers[][] = board.findWorkersOf(player);
//                board.checkPossibleMovement(workers);
//                // se questa funzione torna falso vince il giocatore AVVERSARIO!!
//                // ==> GAMESTATE.ENDED
//
//                // il giocatore sceglie uno dei suoi due workers
//                // TODO da implementare con la gui questo.
//
//                // prova a muoversi da dove si trova
//                // chosenWorker = worker scelto
//
//                currentxPos = 1;
//                currentyPos = 1;
//                desiredxPos = 2;
//                desiredyPos = 1;
//                // check per vedere se la mossa è nel 3x3 intorno al player con if
//                board.isMoveCorrect(currentxPos, currentyPos, desiredxPos, desiredyPos);
//                // check per vedere se il movimento è possibile (no celle già occupate o dome) con if
//                board.isValidMovement(currentxPos, currentyPos, desiredxPos, desiredyPos);
//                // se possibile si sposta il worker
//                board.moveWorker(chosenWorker, currentxPos, currentyPos, desiredxPos, desiredyPos)
//                // check per vedere se il worker è su un terzo livello con un if
//                board.checkWinCondition(desiredxPos, desiredyPos);
//                // SE VERO ==> GAMESTATE.ENDED
//
//                // seleziona una casella dove costruire
//                desiredxPos = 3;
//                desiredyPos = 2;
//                // check per vedere se la mossa è nel 3x3 intorno al player con if
//                board.isMoveCorrect(currentxPos, currentyPos, desiredxPos, desiredyPos);
//                // check per vedere se la costruzione è possibile (non è dome) con if
//                board.isValidConstruction(desiredxPos, desiredyPos);
//                // se possibile livella la torre di quella cell
//                board.buildTower(desiredxPos, desiredyPos);
                // CAMBIO TURNO

                break;

            case ENDED:
                // qui ci si arriva se qualcuno o è arrivato al terzo piano oppure ha entrambi
                // gli worker che non si riescono a muovere, in ogni caso ora
                // è parte della gui festeggiare per la vittoria/sconfitta 🥳🥳

                break;

            default:
                // se sei arrivato qui... ehm.. piacere... ? ora puoi tornare negli altri case sopra dello switch??
                break;
        }


    }

}