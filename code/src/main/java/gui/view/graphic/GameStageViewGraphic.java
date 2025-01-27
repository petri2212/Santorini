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
	private final int spazio_x_y = 142;
	private final int btn_length = 124;

	private JFrame mainFrame;
	private JLabel lblWarningHeader;
	private JLabel lblWarning;
	private JLabel lblBoard;
	private JLabel lblBottons;
	private JLabel lblLateralBoarderL;
	private JLabel lblLateralBoarderR;
	private JLabel lblPlayerTurn;
	private JPanel contentPane;
	private JPanel panelObjects;
	private JPanel panelWarning;
	private JPanel panelGuide;

	/* private action listeners */
	private MouseListener actionMouseOnBoard;

	/**
	 * 
	 *
	 * @param mainFrame
	 */
	public GameStageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		actionMouseOnBoard = initActionMouseOnBoard();

	}

	/**
	 * This is the override of the show method. Shows with graphic the board,
	 * bookshelf, personal goal and common goals. Let the user to take the objects
	 * and to place them into the bookshelf with all the checks needed. Let the user
	 * to Change the turn and interact with buttons.
	 */
	public void show() {
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);

		panelObjects = new JPanel();
		panelObjects.setOpaque(false);
		panelObjects.setBounds(0, 0, 1140, 760);
		panelObjects.setLayout(null);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		contentPane.add(panelObjects);

		// buttons border

		JPanel panelBoardbottons = new JPanel();
		panelBoardbottons.setLayout(null);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);
		panelBoardbottons.setOpaque(false);
		panelBoardbottons.setBounds(220, 18, 1140, 750);
		panelBoardbottons.setOpaque(false);
		contentPane.add(panelBoardbottons);

		// Bottoni prima riga

		CellButton btnRig0_col0 = new CellButton(0, 0);
		btnRig0_col0.setBorder(null);
		btnRig0_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col0.setContentAreaFilled(false);
		btnRig0_col0.setBounds(0, 0, btn_length, btn_length);
		btnRig0_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col0);

		CellButton btnRig0_col1 = new CellButton(0, 1);
		btnRig0_col1.setBorder(null);
		btnRig0_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col1.setContentAreaFilled(false);
		btnRig0_col1.setBounds(spazio_x_y, 0, btn_length, btn_length);
		btnRig0_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col1);

		CellButton btnRig0_col2 = new CellButton(0, 2);
		btnRig0_col2.setBorder(null);
		btnRig0_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col2.setContentAreaFilled(false);
		btnRig0_col2.setBounds(spazio_x_y * 2, 0, btn_length, btn_length);
		btnRig0_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col2);

		CellButton btnRig0_col3 = new CellButton(0, 3);
		btnRig0_col3.setBorder(null);
		btnRig0_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col3.setContentAreaFilled(false);
		btnRig0_col3.setBounds(spazio_x_y * 3, 0, btn_length, btn_length);
		btnRig0_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col3);

		CellButton btnRig0_col4 = new CellButton(0, 4);
		btnRig0_col4.setBorder(null);
		btnRig0_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col4.setContentAreaFilled(false);
		btnRig0_col4.setBounds(spazio_x_y * 4, 0, btn_length, btn_length);
		btnRig0_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col4);

		// Bottoni seconda riga

		CellButton btnRig1_col0 = new CellButton(1, 0);
		btnRig1_col0.setBorder(null);
		btnRig1_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col0.setContentAreaFilled(false);
		btnRig1_col0.setBounds(0, spazio_x_y, btn_length, btn_length);
		btnRig1_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col0);

		CellButton btnRig1_col1 = new CellButton(1, 1);
		btnRig1_col1.setBorder(null);
		btnRig1_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col1.setContentAreaFilled(false);
		btnRig1_col1.setBounds(spazio_x_y, spazio_x_y, btn_length, btn_length);
		btnRig1_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col1);

		CellButton btnRig1_col2 = new CellButton(1, 2);
		btnRig1_col2.setBorder(null);
		btnRig1_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col2.setContentAreaFilled(false);
		btnRig1_col2.setBounds(spazio_x_y * 2, spazio_x_y, btn_length, btn_length);
		btnRig1_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col2);

		CellButton btnRig1_col3 = new CellButton(1, 3);
		btnRig1_col3.setBorder(null);
		btnRig1_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col3.setContentAreaFilled(false);
		btnRig1_col3.setBounds(spazio_x_y * 3, spazio_x_y, btn_length, btn_length);
		btnRig1_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col3);

		CellButton btnRig1_col4 = new CellButton(1, 4);
		btnRig1_col4.setBorder(null);
		btnRig1_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col4.setContentAreaFilled(false);
		btnRig1_col4.setBounds(spazio_x_y * 4, spazio_x_y, btn_length, btn_length);
		btnRig1_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col4);

		// Bottoni terza riga

		CellButton btnRig3_col0 = new CellButton(2, 0);
		btnRig3_col0.setBorder(null);
		btnRig3_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col0.setContentAreaFilled(false);
		btnRig3_col0.setBounds(0, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col0);

		CellButton btnRig3_col1 = new CellButton(2, 1);
		btnRig3_col1.setBorder(null);
		btnRig3_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col1.setContentAreaFilled(false);
		btnRig3_col1.setBounds(spazio_x_y, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col1);

		CellButton btnRig3_col2 = new CellButton(2, 2);
		btnRig3_col2.setBorder(null);
		btnRig3_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col2.setContentAreaFilled(false);
		btnRig3_col2.setBounds(spazio_x_y * 2, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col2);
		
		CellButton btnRig3_col3 = new CellButton(2, 3);
		btnRig3_col3.setBorder(null);
		btnRig3_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col3.setContentAreaFilled(false);
		btnRig3_col3.setBounds(spazio_x_y * 3, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col3);

		CellButton btnRig3_col4 = new CellButton(2, 4);
		btnRig3_col4.setBorder(null);
		btnRig3_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col4.setContentAreaFilled(false);
		btnRig3_col4.setBounds(spazio_x_y * 4, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col4);

		// Bottoni quarta riga

		CellButton btnRig4_col0 = new CellButton(3, 0);
		btnRig4_col0.setBorder(null);
		btnRig4_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col0.setContentAreaFilled(false);
		btnRig4_col0.setBounds(0, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col0);

		CellButton btnRig4_col1 = new CellButton(3, 1);
		btnRig4_col1.setBorder(null);
		btnRig4_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col1.setContentAreaFilled(false);
		btnRig4_col1.setBounds(spazio_x_y, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col1);

		CellButton btnRig4_col2 = new CellButton(3, 2);
		btnRig4_col2.setBorder(null);
		btnRig4_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col2.setContentAreaFilled(false);
		btnRig4_col2.setBounds(spazio_x_y * 2, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col2);

		CellButton btnRig4_col3 = new CellButton(3, 3);
		btnRig4_col3.setBorder(null);
		btnRig4_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col3.setContentAreaFilled(false);
		btnRig4_col3.setBounds(spazio_x_y * 3, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col3);

		CellButton btnRig4_col4 = new CellButton(3, 4);
		btnRig4_col4.setBorder(null);
		btnRig4_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col4.setContentAreaFilled(false);
		btnRig4_col4.setBounds(spazio_x_y * 4, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col4);

		// Bottoni quinta riga

		CellButton btnRig5_col0 = new CellButton(4, 0);
		btnRig5_col0.setBorder(null);
		btnRig5_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col0.setContentAreaFilled(false);
		btnRig5_col0.setBounds(0, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col0);

		CellButton btnRig5_col1 = new CellButton(4, 1);
		btnRig5_col1.setBorder(null);
		btnRig5_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col1.setContentAreaFilled(false);
		btnRig5_col1.setBounds(spazio_x_y, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col1);

		CellButton btnRig5_col2 = new CellButton(4, 2);
		btnRig5_col2.setBorder(null);
		btnRig5_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col2.setContentAreaFilled(false);
		btnRig5_col2.setBounds(spazio_x_y * 2, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col2);

		CellButton btnRig5_col3 = new CellButton(4, 3);
		btnRig5_col3.setBorder(null);
		btnRig5_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col3.setContentAreaFilled(false);
		btnRig5_col3.setBounds(spazio_x_y * 3, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col3);

		CellButton btnRig5_col4 = new CellButton(4, 4);
		btnRig5_col4.setBorder(null);
		btnRig5_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col4.setContentAreaFilled(false);
		btnRig5_col4.setBounds(spazio_x_y * 4, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col4);

		// Boarder Image
		JPanel panelBoard = new JPanel();
		panelBoard.setOpaque(false);
		panelBoard.setBounds(0, 0, 1140, 720);
		contentPane.add(panelBoard);
		panelBoard.setLayout(new BorderLayout(0, 0));//

		lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setIcon(Icons.BOARD.load());
		panelBoard.add(lblBoard, BorderLayout.CENTER);// , BorderLayout.CENTER

		mainFrame.setBackground(new Color(36, 31, 49));
		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();

	}

	/* Private action listeners initialization */

	/**
	 * 
	 * @return
	 */
	private MouseListener initActionMouseOnBoard() {
		return new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				CellButton button = (CellButton) e.getSource();
				button.setBorder(null);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				CellButton button = (CellButton) e.getSource();
				button.setBorder(new LineBorder(new Color(0, 0, 0), 4));// new Color(87, 227, 137), 4)

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 
				 * ArrayList<BookshelfObject> obj = new ArrayList<>();
				 * 
				 * if (savedMatrixCoords.size() > 0) { ColumnButton button = (ColumnButton)
				 * e.getSource();
				 * 
				 * boolean success = false;
				 * 
				 * if (bookshelf.isThereEnoughSpace(button.getColIndex(),
				 * savedMatrixCoords.size())) { for (MatrixCoords coords : savedMatrixCoords) {
				 * obj.add(board.tryPickObject(coords)); }
				 * 
				 * success = bookshelf.tryAdd(button.getColIndex(), obj); }
				 * 
				 * if (!success) { showColWarning(); } else { savedMatrixCoords = new
				 * ArrayList<>(); hidePickedObjectsPanel(); printBookshelfObjects();
				 * showEndTurnButton(); } }
				 */
			}
		};

	}

}
