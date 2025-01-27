package src.main.java.gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import src.main.java.gameComponents.Board;
import src.main.java.gameComponents.Cell;
import src.main.java.components.BackgroundPanel;
import src.main.java.components.CellButton;
import src.main.java.components.CellObjectButton;
import src.main.java.gui.view.GameStageView;
import resources.Icons;

/**
 * This is the view graphic for the game stage page and it extends the abstract
 * view.
 */
public class GameStageViewGraphic extends GameStageView {

	private static final int PICKED_WORKER_1_INDEX = 0;
	private static final int PICKED_WORKER_2_INDEX = 1;

	/**
	 * 
	 *
	 * @param mainFrame
	 */
	public GameStageViewGraphic(JFrame mainFrame) {

	}

	/**
	 * This is the override of the show method. Shows with graphic the board,
	 * bookshelf, personal goal and common goals. Let the user to take the objects
	 * and to place them into the bookshelf with all the checks needed. Let the user
	 * to Change the turn and interact with buttons.
	 */
	public void show() {

	}
}