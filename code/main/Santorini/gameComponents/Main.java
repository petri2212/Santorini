package main.Santorini.gameComponents;

import src.main.java.gameComponents.GameController;
import src.main.java.gameComponents.Board;

public class Main {
    public static void main(String[] args) {

    	Board board = new Board();
        GameController game = new GameController(board);
        game.gameLoop();
        
    }
}