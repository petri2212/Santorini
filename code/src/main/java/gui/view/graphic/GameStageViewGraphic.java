package src.main.java.gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
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

import src.main.java.gameComponents.Cell;
import src.main.java.gameComponents.Check;
import src.main.java.components.BackgroundPanel;
import src.main.java.components.CellButton;
import src.main.java.gui.view.GameStageView;
import resources.Icons;
import resources.Images;

/**
 * This is the view graphic for the game stage page and it extends the abstract
 * view.
 */
public class GameStageViewGraphic extends GameStageView {

	private final int spazio_x_y = 142;
	private final int btn_length = 124;
	private final int dim_worker = 30;

	private JFrame mainFrame;

	// Jlabel
	private JLabel lblWarningHeader;
	private JLabel lblWarning;
	private JLabel lblBoard;
	private JLabel lblPlayerTurn;

	// JPanel
	private JPanel contentPane;
	private JPanel panelBoard;
	private JPanel panelObjects;
	private JPanel panelWarning;
	private JPanel panelGuide;
	private JPanel panelBoardbottons;

	// Jbutton
	private JButton btnHelp;
	private JButton btnEndTurn;
	private JButton btnAcknowledge;
	private JButton btnAccept;
	private JButton btnCancel;

	private JButton btnWorkerR1;
	/*
	 * int posWR1_x = 980; int posWR1_y = 60;
	 */
	private JButton btnWorkerR2;
	/*
	 * int posWR2_x = 1020 ; int posWR2_y = 60;
	 */

	private JButton btnWorkerB1;
	/*
	 * int posWB1_x = 980; int posWB1_y = 60;
	 */
	private JButton btnWorkerB2;
	/*
	 * int posWB2_x = 1020; int posWB2_y = 60;
	 */
	ArrayList<JButton> obj = new ArrayList<>();
	ArrayList<CellButton> cellButton = new ArrayList<>();
	BackgroundPanel [][] objectPanel = new BackgroundPanel[25][25];
	
	private BackgroundPanel[] panelPickedWorkers = new BackgroundPanel[2];

	/* private action listeners */
	private MouseListener actionMouseOnBoard;

	private ActionListener actionHideGuidePanel;
	private ActionListener actionPutWorkersInQueue;
	private ActionListener actionHideWarningPanel;
	private ActionListener actionShowHelpDialog;
	private ActionListener actionShowReturnHomeDialog;
	private ActionListener actionHideReturnMainPage;

	/**
	 * 
	 *
	 * @param mainFrame
	 */
	public GameStageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		actionMouseOnBoard = initActionMouseOnBoard();
		actionHideGuidePanel = initActionHideGuidePanel();
		actionHideWarningPanel = initActionHideWarningPanel();
		actionShowHelpDialog = initActionShowHelpDialog();
		actionShowReturnHomeDialog = initActionShowReturnHomeDialog();
		actionHideReturnMainPage = initActionHideReturnMainPage();
		actionPutWorkersInQueue = initactionPutWorkersInQueue();
	}

	/**
	 * This is the override of the show method. Shows with graphic the board,
	 * bookshelf, personal goal and common goals. Let the user to take the objects
	 * and to place them into the bookshelf with all the checks needed. Let the user
	 * to Change the turn and interact with buttons.
	 */
	public void show() {
		// contentPane + panelObjects
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);

		/* ********************* GUIDE DIALOG ************************ */
		panelGuide = new JPanel();
		panelGuide.setVisible(false);
		panelGuide.setEnabled(false);
		panelGuide.setBounds(288, 185, 537, 346);
		contentPane.add(panelGuide);
		panelGuide.setLayout(null);

		JLabel lblGuideHeader = new JLabel("Quick Guide");
		lblGuideHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuideHeader.setBounds(0, 0, 537, 41);
		panelGuide.add(lblGuideHeader);

		JLabel lblGuide = new JLabel("<html>ciao questo è come funaizona il gioca</html>");
		lblGuide.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuide.setBounds(10, 40, 515, 230);
		panelGuide.add(lblGuide);

		JButton btnGuideAcknowledge = new JButton("Ok");
		btnGuideAcknowledge.setBounds(208, 293, 117, 25);
		btnGuideAcknowledge.addActionListener(actionHideGuidePanel);
		panelGuide.add(btnGuideAcknowledge);

		/* ********************* WARNING DIALOG ************************ */
		panelWarning = new JPanel();
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		lblWarningHeader = new JLabel("Get Ready!");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		lblWarning = new JLabel("Its " + playerName + "'s turn.");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		btnAcknowledge.addActionListener(actionHideWarningPanel);
		panelWarning.add(btnAcknowledge);

		btnAccept = new JButton("Ok");
		btnAccept.setVisible(false);
		btnAccept.setEnabled(false);
		btnAccept.setBounds(300, 193, 117, 25);
		btnAccept.addActionListener(actionReturnMainPage);
		panelWarning.add(btnAccept);

		btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		btnCancel.setEnabled(false);
		btnCancel.setBounds(100, 193, 117, 25);
		btnCancel.addActionListener(actionHideReturnMainPage);
		panelWarning.add(btnCancel);

		/* ********************* Labels ************************ */
		JLabel Workers = new JLabel("Workers");
		Workers.setVerticalAlignment(SwingConstants.BOTTOM);
		Workers.setHorizontalTextPosition(SwingConstants.CENTER);
		Workers.setHorizontalAlignment(SwingConstants.CENTER);
		Workers.setForeground(Color.WHITE);
		Workers.setFont(new Font("Purisa", Font.BOLD, 16));
		Workers.setBounds(942, 0, 188, 46);
		contentPane.add(Workers);

		// Worker Rossi
		btnWorkerR1 = new JButton("WorkerR1");
		btnWorkerR1.setIcon(Icons.ICON_WORKER_RED.load());
		btnWorkerR1.setDisabledIcon(Icons.ICON_WORKER_RED.load());
		// btnWorkerR1.setBackground(Color.RED);
		btnWorkerR1.setOpaque(false);
		btnWorkerR1.setVisible(false);
		btnWorkerR1.setFocusPainted(false);

		btnWorkerR1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWorkerR1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWorkerR1.setForeground(new Color(255, 255, 255));
		btnWorkerR1.setFont(new Font("Purisa", Font.BOLD, 16));
		btnWorkerR1.setBounds(player.posWR1_x, player.posWR1_y, dim_worker, dim_worker);
		btnWorkerR1.addActionListener(actionPutWorkersInQueue);
		contentPane.add(btnWorkerR1);
		// System.out.println(player.getName() + player.posWB1_x);

		btnWorkerR2 = new JButton("WorkerR2");
		btnWorkerR2.setIcon(Icons.ICON_WORKER_RED.load());
		btnWorkerR2.setDisabledIcon(Icons.ICON_WORKER_RED.load());
		// btnWorkerR2.setBackground(Color.RED);
		btnWorkerR2.setVisible(false);
		btnWorkerR2.setOpaque(false);

		btnWorkerR2.setFocusPainted(false);
		btnWorkerR2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWorkerR2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWorkerR2.setForeground(new Color(255, 255, 255));
		btnWorkerR2.setFont(new Font("Purisa", Font.BOLD, 16));
		btnWorkerR2.setBounds(player.posWR2_x, player.posWR2_y, dim_worker, dim_worker);
		btnWorkerR2.addActionListener(actionPutWorkersInQueue);
		contentPane.add(btnWorkerR2);

		// Worker Blue
		btnWorkerB1 = new JButton("WorkerB1");

		btnWorkerB1.setIcon(Icons.ICON_WORKER_BLUE.load());
		btnWorkerB1.setDisabledIcon(Icons.ICON_WORKER_BLUE.load());
		btnWorkerB1.setOpaque(false);
		btnWorkerB1.setVisible(false);
		btnWorkerB1.setFocusPainted(false);

		btnWorkerB1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWorkerB1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWorkerB1.setForeground(new Color(255, 255, 255));
		btnWorkerB1.setFont(new Font("Purisa", Font.BOLD, 16));
		btnWorkerB1.setBounds(player.posWB1_x, player.posWB1_y, 30, 30);
		btnWorkerB1.addActionListener(actionPutWorkersInQueue);
		contentPane.add(btnWorkerB1);

		btnWorkerB2 = new JButton("WorkerB2");

		btnWorkerB2.setIcon(Icons.ICON_WORKER_BLUE.load());
		btnWorkerB2.setDisabledIcon(Icons.ICON_WORKER_BLUE.load());
		btnWorkerB2.setVisible(false);
		btnWorkerB2.setOpaque(false);

		btnWorkerB2.setFocusPainted(false);
		btnWorkerB2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWorkerB2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWorkerB2.setForeground(new Color(255, 255, 255));
		btnWorkerB2.setFont(new Font("Purisa", Font.BOLD, 16));
		btnWorkerB2.setBounds(player.posWB2_x, player.posWB1_y, 30, 30);
		btnWorkerB2.addActionListener(actionPutWorkersInQueue);
		contentPane.add(btnWorkerB2);

		printWorkers();

		JLabel lblPlayerTurnHeader = new JLabel("Player's Turn:");
		lblPlayerTurnHeader.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerTurnHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerTurnHeader.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerTurnHeader.setForeground(new Color(255, 255, 255));
		lblPlayerTurnHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurnHeader.setBounds(0, 0, 188, 46);
		contentPane.add(lblPlayerTurnHeader);

		lblPlayerTurn = new JLabel(playerName);
		lblPlayerTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerTurn.setForeground(new Color(255, 255, 255));
		lblPlayerTurn.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerTurn.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurn.setBounds(0, 47, 189, 42);
		contentPane.add(lblPlayerTurn);

		JLabel lblPickedWorker = new JLabel("Picked Workers");
		lblPickedWorker.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPickedWorker.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPickedWorker.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickedWorker.setForeground(Color.WHITE);
		lblPickedWorker.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPickedWorker.setBounds(954, 345, 167, 46);
		contentPane.add(lblPickedWorker);

		/* ********************* PICKED OBJECTS ************************ */
		panelPickedWorkers[0] = new BackgroundPanel();
		BackgroundPanel panelObject1 = panelPickedWorkers[0];
		panelObject1.setBounds(953, 399, 67, 67);
		panelObject1.setVisible(false);
		panelObject1.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelObject1);

		JLabel lblObject1 = new JLabel("1");
		lblObject1.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject1.setForeground(new Color(237, 51, 59));
		lblObject1.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject1.setHorizontalTextPosition(SwingConstants.CENTER);
		panelObject1.add(lblObject1);

		panelPickedWorkers[1] = new BackgroundPanel();
		BackgroundPanel panelObject2 = panelPickedWorkers[1];
		panelObject2.setBounds(1050, 399, 67, 67);
		panelObject2.setVisible(false);
		panelObject2.setLayout(new BorderLayout(0, 0));
		contentPane.add(panelObject2);

		JLabel lblObject2 = new JLabel("2");
		lblObject2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblObject2.setHorizontalAlignment(SwingConstants.CENTER);
		lblObject2.setFont(new Font("Purisa", Font.BOLD, 60));
		lblObject2.setForeground(new Color(237, 51, 59));
		panelObject2.add(lblObject2);

		btnHelp = new JButton("Help");
		btnHelp.setBackground(new Color(255, 255, 255));
		btnHelp.setOpaque(false);
		btnHelp.setFocusPainted(false);
		btnHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHelp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHelp.setForeground(new Color(255, 255, 255));
		btnHelp.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHelp.setBounds(965, 645, 142, 57);
		btnHelp.addActionListener(actionShowHelpDialog);

		contentPane.add(btnHelp);

		btnEndTurn = new JButton("End Turn");
		if (isFirstTurn || player.isFirstTurn) {
			btnEndTurn.setEnabled(false);
		}else {
			btnEndTurn.setEnabled(true);
		}
		btnEndTurn.setVisible(true);
		btnEndTurn.setBackground(new Color(255, 255, 255));
		btnEndTurn.setOpaque(false);
		btnEndTurn.setFocusPainted(false);
		btnEndTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEndTurn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setFont(new Font("Purisa", Font.BOLD, 16));
		btnEndTurn.setBounds(965, 550, 142, 57);
		btnEndTurn.addActionListener(actionEndTurn);
		contentPane.add(btnEndTurn);

		JButton btnHome = new JButton("<--");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setOpaque(false);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHome.setFocusPainted(false);
		btnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(20, 645, 142, 57);
		btnHome.addActionListener(actionShowReturnHomeDialog);
		contentPane.add(btnHome);

		panelObjects = new JPanel();
		panelObjects.setOpaque(false);
		panelObjects.setBounds(220, 18, 1140, 750);
		panelObjects.setLayout(null);
		panelObjects.setVisible(true);
		panelObjects.setEnabled(false);
		contentPane.add(panelObjects);

		// buttons border

		panelBoardbottons = new JPanel();
		panelBoardbottons.setLayout(null);
		panelBoardbottons.setVisible(false);
		panelBoardbottons.setEnabled(false);
		panelBoardbottons.setOpaque(false);
		panelBoardbottons.setBounds(220, 18, 1140, 750);
		panelBoardbottons.setOpaque(false);
		contentPane.add(panelBoardbottons);

		// Bottoni prima riga

		CellButton btnRig0_col0 = new CellButton(0, 0, 0, 0);
		btnRig0_col0.setBorder(null);
		btnRig0_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col0.setContentAreaFilled(false);
		btnRig0_col0.setBounds(0, 0, btn_length, btn_length);
		btnRig0_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col0);

		CellButton btnRig0_col1 = new CellButton(0, 1, spazio_x_y, 0);
		btnRig0_col1.setBorder(null);
		btnRig0_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col1.setContentAreaFilled(false);
		btnRig0_col1.setBounds(spazio_x_y, 0, btn_length, btn_length);
		btnRig0_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col1);

		CellButton btnRig0_col2 = new CellButton(0, 2, spazio_x_y * 2, 0);
		btnRig0_col2.setBorder(null);
		btnRig0_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col2.setContentAreaFilled(false);
		btnRig0_col2.setBounds(spazio_x_y * 2, 0, btn_length, btn_length);
		btnRig0_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col2);

		CellButton btnRig0_col3 = new CellButton(0, 3, spazio_x_y * 3, 0);
		btnRig0_col3.setBorder(null);
		btnRig0_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col3.setContentAreaFilled(false);
		btnRig0_col3.setBounds(spazio_x_y * 3, 0, btn_length, btn_length);
		btnRig0_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col3);

		CellButton btnRig0_col4 = new CellButton(0, 4, spazio_x_y * 4, 0);
		btnRig0_col4.setBorder(null);
		btnRig0_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0_col4.setContentAreaFilled(false);
		btnRig0_col4.setBounds(spazio_x_y * 4, 0, btn_length, btn_length);
		btnRig0_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0_col4);

		// Bottoni seconda riga

		CellButton btnRig1_col0 = new CellButton(1, 0, 0, spazio_x_y);
		btnRig1_col0.setBorder(null);
		btnRig1_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col0.setContentAreaFilled(false);
		btnRig1_col0.setBounds(0, spazio_x_y, btn_length, btn_length);
		btnRig1_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col0);

		CellButton btnRig1_col1 = new CellButton(1, 1, spazio_x_y, spazio_x_y);
		btnRig1_col1.setBorder(null);
		btnRig1_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col1.setContentAreaFilled(false);
		btnRig1_col1.setBounds(spazio_x_y, spazio_x_y, btn_length, btn_length);
		btnRig1_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col1);

		CellButton btnRig1_col2 = new CellButton(1, 2, spazio_x_y * 2, spazio_x_y);
		btnRig1_col2.setBorder(null);
		btnRig1_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col2.setContentAreaFilled(false);
		btnRig1_col2.setBounds(spazio_x_y * 2, spazio_x_y, btn_length, btn_length);
		btnRig1_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col2);

		CellButton btnRig1_col3 = new CellButton(1, 3, spazio_x_y * 3, spazio_x_y);
		btnRig1_col3.setBorder(null);
		btnRig1_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col3.setContentAreaFilled(false);
		btnRig1_col3.setBounds(spazio_x_y * 3, spazio_x_y, btn_length, btn_length);
		btnRig1_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col3);

		CellButton btnRig1_col4 = new CellButton(1, 4, spazio_x_y * 4, spazio_x_y);
		btnRig1_col4.setBorder(null);
		btnRig1_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1_col4.setContentAreaFilled(false);
		btnRig1_col4.setBounds(spazio_x_y * 4, spazio_x_y, btn_length, btn_length);
		btnRig1_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1_col4);

		// Bottoni terza riga

		CellButton btnRig3_col0 = new CellButton(2, 0, 0, spazio_x_y * 2);
		btnRig3_col0.setBorder(null);
		btnRig3_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col0.setContentAreaFilled(false);
		btnRig3_col0.setBounds(0, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col0);

		CellButton btnRig3_col1 = new CellButton(2, 1, spazio_x_y, spazio_x_y * 2);
		btnRig3_col1.setBorder(null);
		btnRig3_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col1.setContentAreaFilled(false);
		btnRig3_col1.setBounds(spazio_x_y, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col1);

		CellButton btnRig3_col2 = new CellButton(2, 2, spazio_x_y * 2, spazio_x_y * 2);
		btnRig3_col2.setBorder(null);
		btnRig3_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col2.setContentAreaFilled(false);
		btnRig3_col2.setBounds(spazio_x_y * 2, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col2);

		CellButton btnRig3_col3 = new CellButton(2, 3, spazio_x_y * 3, spazio_x_y * 2);
		btnRig3_col3.setBorder(null);
		btnRig3_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col3.setContentAreaFilled(false);
		btnRig3_col3.setBounds(spazio_x_y * 3, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col3);

		CellButton btnRig3_col4 = new CellButton(2, 4, spazio_x_y * 4, spazio_x_y * 2);
		btnRig3_col4.setBorder(null);
		btnRig3_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3_col4.setContentAreaFilled(false);
		btnRig3_col4.setBounds(spazio_x_y * 4, spazio_x_y * 2, btn_length, btn_length);
		btnRig3_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3_col4);

		// Bottoni quarta riga

		CellButton btnRig4_col0 = new CellButton(3, 0, 0, spazio_x_y * 3);
		btnRig4_col0.setBorder(null);
		btnRig4_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col0.setContentAreaFilled(false);
		btnRig4_col0.setBounds(0, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col0);

		CellButton btnRig4_col1 = new CellButton(3, 1, spazio_x_y, spazio_x_y * 3);
		btnRig4_col1.setBorder(null);
		btnRig4_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col1.setContentAreaFilled(false);
		btnRig4_col1.setBounds(spazio_x_y, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col1);

		CellButton btnRig4_col2 = new CellButton(3, 2, spazio_x_y * 2, spazio_x_y * 3);
		btnRig4_col2.setBorder(null);
		btnRig4_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col2.setContentAreaFilled(false);
		btnRig4_col2.setBounds(spazio_x_y * 2, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col2);

		CellButton btnRig4_col3 = new CellButton(3, 3, spazio_x_y * 3, spazio_x_y * 3);
		btnRig4_col3.setBorder(null);
		btnRig4_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col3.setContentAreaFilled(false);
		btnRig4_col3.setBounds(spazio_x_y * 3, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col3);

		CellButton btnRig4_col4 = new CellButton(3, 4, spazio_x_y * 4, spazio_x_y * 3);
		btnRig4_col4.setBorder(null);
		btnRig4_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4_col4.setContentAreaFilled(false);
		btnRig4_col4.setBounds(spazio_x_y * 4, spazio_x_y * 3, btn_length, btn_length);
		btnRig4_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4_col4);

		// Bottoni quinta riga

		CellButton btnRig5_col0 = new CellButton(4, 0, 0, spazio_x_y * 4);
		btnRig5_col0.setBorder(null);
		btnRig5_col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col0.setContentAreaFilled(false);
		btnRig5_col0.setBounds(0, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col0);

		CellButton btnRig5_col1 = new CellButton(4, 1, spazio_x_y, spazio_x_y * 4);
		btnRig5_col1.setBorder(null);
		btnRig5_col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col1.setContentAreaFilled(false);
		btnRig5_col1.setBounds(spazio_x_y, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col1);

		CellButton btnRig5_col2 = new CellButton(4, 2, spazio_x_y * 2, spazio_x_y * 4);
		btnRig5_col2.setBorder(null);
		btnRig5_col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col2.setContentAreaFilled(false);
		btnRig5_col2.setBounds(spazio_x_y * 2, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col2);

		CellButton btnRig5_col3 = new CellButton(4, 3, spazio_x_y * 3, spazio_x_y * 4);
		btnRig5_col3.setBorder(null);
		btnRig5_col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col3.setContentAreaFilled(false);
		btnRig5_col3.setBounds(spazio_x_y * 3, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col3);

		CellButton btnRig5_col4 = new CellButton(4, 4, spazio_x_y * 4, spazio_x_y * 4);
		btnRig5_col4.setBorder(null);
		btnRig5_col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5_col4.setContentAreaFilled(false);
		btnRig5_col4.setBounds(spazio_x_y * 4, spazio_x_y * 4, btn_length, btn_length);
		btnRig5_col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5_col4);

		printTowers();

		// Boarder Image
		panelBoard = new JPanel();
		panelBoard.setOpaque(false);
		panelBoard.setBounds(0, 0, 1140, 720);
		contentPane.add(panelBoard);
		panelBoard.setLayout(new BorderLayout(0, 0));//

		lblBoard = new JLabel("");
		lblBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoard.setIcon(Icons.BOARD.load());
		panelBoard.add(lblBoard, BorderLayout.CENTER);// , BorderLayout.CENTER

//

		mainFrame.setBackground(new Color(36, 31, 49));
		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();

	}

	private void printWorkers() {
		System.out.println("printWorkers: " + isFirstTurn);
		if (player.isFirstTurn && isFirstTurn) {

			btnWorkerR2.setVisible(true);
			btnWorkerR2.setEnabled(true);

			btnWorkerR1.setVisible(true);
			btnWorkerR1.setEnabled(true);
		} else if (player.isFirstTurn) {

			btnWorkerB2.setVisible(true);
			btnWorkerB2.setEnabled(true);

			btnWorkerB1.setVisible(true);
			btnWorkerB1.setEnabled(true);
			/*
			 * btnWorkerR2.setVisible(false); btnWorkerR2.setEnabled(false);
			 * 
			 * btnWorkerR1.setVisible(false); btnWorkerR1.setEnabled(false);
			 */
		} /*
			 * else if(!player.isFirstTurn) { btnWorkerR2.setVisible(true);
			 * btnWorkerR2.setEnabled(true);
			 * 
			 * btnWorkerR1.setVisible(true); btnWorkerR1.setEnabled(true);
			 * 
			 * } else{ btnWorkerB2.setVisible(true); btnWorkerB2.setEnabled(true);
			 * 
			 * btnWorkerB1.setVisible(true); btnWorkerB1.setEnabled(true);
			 * 
			 * }
			 */

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				Cell objectCell = board.cellAt(r, c);

				if (objectCell.getStatusWorker() == true) {
					int s = 30;
					// int x = 260 + c * (s + 100);
					// int y = 65 + r * (s + 100);

					int x = 266 + c * (s + 112);
					int y = 66 + r * (s + 112);

					if (objectCell.getWorker().getID() == 1) {
						btnWorkerR1.setVisible(true);
						btnWorkerR1.setBounds(x, y, s, s);

					} else if (objectCell.getWorker().getID() == 2) {
						btnWorkerR2.setVisible(true);
						btnWorkerR2.setBounds(x, y, s, s);

					} else if (objectCell.getWorker().getID() == 3) {
						btnWorkerB1.setVisible(true);
						btnWorkerB1.setBounds(x, y, s, s);

					} else if (objectCell.getWorker().getID() == 4) {
						btnWorkerB2.setVisible(true);
						btnWorkerB2.setBounds(x, y, s, s);

					}

				}
			}
		}

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
				button.setBorder(new LineBorder(new Color(200, 200, 200), 4));// new Color(87, 227, 137), 4)

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// System.out.println("mouse click: " + isFirstTurn);
				CellButton button = (CellButton) e.getSource();
				/*
				 * System.out.println(button.getRowIndex() + " c:  " + button.getColIndex());
				 * System.out.println( "la cella è: " + board.cellAt(button.getRowIndex(),
				 * button.getColIndex()).getStatusWorker());
				 */

				// first turn handling
				if (isFirstTurn) {
					if (!obj.isEmpty()) {
						if (obj.get(0).equals(btnWorkerR1)) {
							if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {

								board.placeWorker(player.getWorker(0), button.getRowIndex(), button.getColIndex());
								obj.remove(btnWorkerR1);
								btnWorkerR1.setBounds(button.posX + 266, button.posY + 66, dim_worker, dim_worker);
								btnWorkerR1.setEnabled(false);
								
							}

						} else if (obj.get(0).equals(btnWorkerR2)) {
							if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
								board.placeWorker(player.getWorker(1), button.getRowIndex(), button.getColIndex());
								obj.remove(btnWorkerR2);
								btnWorkerR2.setBounds(button.posX + 266, button.posY + 66, dim_worker, dim_worker);
								btnWorkerR2.setEnabled(false);
							}
						}

					}
					

				}
				
				/*
				 * This control for the red's turn enable the endButton only when he
				 * has placed all two workers
				 */
				if(!btnWorkerR1.isEnabled() && !btnWorkerR2.isEnabled()) {
					btnEndTurn.setEnabled(true);
				}

				if (player.isFirstTurn) {
					if (!obj.isEmpty()) {
						if (obj.get(0).equals(btnWorkerB1)) {

							if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
								board.placeWorker(player.getWorker(0), button.getRowIndex(), button.getColIndex());
								obj.remove(btnWorkerB1);
								btnWorkerB1.setBounds(button.posX + 266, button.posY + 66, dim_worker, dim_worker);
								btnWorkerB1.setEnabled(false);
							}
						} else if (obj.get(0).equals(btnWorkerB2)) {
							if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
								board.placeWorker(player.getWorker(1), button.getRowIndex(), button.getColIndex());
								obj.remove(btnWorkerB2);
								btnWorkerB2.setBounds(button.posX + 266, button.posY + 66, dim_worker, dim_worker);
								btnWorkerB2.setEnabled(false);
							}
						}

					}
					
				}
				
				/*
				 * This control for the blue's turn enable the endButton only when he
				 * has placed all two workers
				 */
				if(!btnWorkerB1.isEnabled() && !btnWorkerB2.isEnabled()) {
					btnEndTurn.setEnabled(true);
				}
				
				
				if (!player.isFirstTurn) {
					btnEndTurn.setEnabled(true);
					// others turns handlings
					if (movePhase && cellButton.size() == 0) {
						// board
						if (board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {

							if (board.cellAt(button.getRowIndex(), button.getColIndex()).getWorker()
									.equals(player.getWorker(0))) {
								cellButton.add(button);
							} else if (board.cellAt(button.getRowIndex(), button.getColIndex()).getWorker()
									.equals(player.getWorker(1))) {
								cellButton.add(button);
							}

						}
					} else if (movePhase && cellButton.size() == 1) {
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker() && Check
								.isValidMovement(board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
										board.cellAt(button.getRowIndex(), button.getColIndex())) && Check
											.aroundWorkerCells(board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
													board.cellAt(button.getRowIndex(), button.getColIndex()))) {

							board.moveWorker(
									board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex).getWorker(),
									board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
									board.cellAt(button.rowIndex, button.colIndex));
							movePhase = false;
							buildPhase = true;
							printWorkers();
						} else {
							cellButton.remove(0);
						}

					}

					if (buildPhase && cellButton.size() == 0) {
						// && Check.isValidMovement(null, null)
						if (board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
							if (board.cellAt(button.getRowIndex(), button.getColIndex()).getWorker()
									.equals(player.getWorker(0))) {
								cellButton.add(button);
							} else if (board.cellAt(button.getRowIndex(), button.getColIndex()).getWorker()
									.equals(player.getWorker(1))) {
								cellButton.add(button);
							}

						}
					} else if (buildPhase && cellButton.size() == 1) {
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {

							if (Check.isValidConstruction(board.cellAt(button.getRowIndex(), button.getColIndex()))) {
								board.cellAt(button.rowIndex, button.colIndex).levelUpTower();
								// int height = board.cellAt(button.rowIndex, button.colIndex).getHeight();
								System.out.println("il livello della torre su cui si vuole costruire è: "
										+ board.cellAt(button.rowIndex, button.colIndex).getHeight());
							}
							movePhase = false;
							buildPhase = false;
							printTowers();
							printWorkers();
						}
					}

				}
				
				if (!player.isFirstTurn) {
					btnEndTurn.setEnabled(true);
				}
				
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						System.out.print(" " + board.cellAt(r, c).getStatusWorker());

					}
					System.out.println("\n");
				}

				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						System.out.print(" " + board.cellAt(r, c).getHeight());

					}
					System.out.println("\n");
				}

			}

		};

	}

	private void printTowers() {

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				Cell objectCell = board.cellAt(r, c);

				int height = objectCell.getHeight();
				int s = 112;
				// int x = 260 + c * (s + 100);
				// int y = 65 + r * (s + 100);

				// ---> giusta int x = 226 + c * (s + 30);
				int x = 6 + c * (s + 30);
				// ---> giusta int y = 25 + r * (s + 30);
				int y = 6 + r * (s + 30);
				if(height == 0) {
					continue;
				}
				
				Image image = null ;
				if (height == 1) {

					 image = Images.ICON_BLOCK_layer1.load();

				} else if (height == 2) {
					 image = Images.ICON_BLOCK_layer2.load();

				} else if (height == 3) {
					 image = Images.ICON_BLOCK_layer3.load();

				}
				else if (height == 4) {
					 image = Images.ICON_BLOCK_DOME.load();

				}
				if(objectPanel[r][c] == null) {
					objectPanel[r][c] = new BackgroundPanel(image);
				}else {
					objectPanel[r][c].setBackground(image);
				}
				objectPanel[r][c].setBounds(x, y, s, s);
				panelObjects.add(objectPanel[r][c]);
				panelObjects.repaint();
				panelObjects.revalidate();

			}
		}

	}

	private void hideGuidePanel() {
		panelGuide.setVisible(false);
		panelGuide.setEnabled(false);
		panelObjects.setVisible(true);
		panelObjects.setEnabled(true);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);
	}

	private void showReturnHomeDialog() {
		panelWarning.setVisible(true);
		panelWarning.setEnabled(true);
		lblWarningHeader.setText("Warning");
		lblWarning.setText("<html>Are you sure you want to exit to the main menu?<br>All progress will be lost.");
		btnAcknowledge.setVisible(false);
		btnAcknowledge.setEnabled(false);
		btnAccept.setVisible(true);
		btnAccept.setEnabled(true);
		btnCancel.setVisible(true);
		btnCancel.setEnabled(true);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);
	}


	private void showHelpDialog() {
		panelGuide.setVisible(true);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);

	}

	private void hideWarningPanel() {
		panelWarning.setVisible(false);
		panelWarning.setEnabled(false);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);
	}


	private void hideReturnHomeDialog() {
		panelWarning.setVisible(false);
		panelWarning.setEnabled(false);
		btnAcknowledge.setVisible(true);
		btnAcknowledge.setEnabled(true);
		btnAccept.setVisible(false);
		btnAccept.setEnabled(false);
		btnCancel.setVisible(false);
		btnCancel.setEnabled(false);
		panelBoardbottons.setVisible(true);
		panelBoardbottons.setEnabled(true);
	}


	private ActionListener initactionPutWorkersInQueue() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// se è il primo turno sposto entrambi gli workers del giocatore in
				// PickedWorkers, per poi posizionarli su una casella,
				// durante questa fase il panel board è (devo implementarlo)disattivato perchè
				// non posso posizionare i giocatori
				if (player.isFirstTurn && playerName != playerOpponent) {
					if (btnWorkerR1.equals(e.getSource()) && btnWorkerR1.isEnabled()) {
						obj.add(btnWorkerR1);
						player.posWR1_y = 400;
						btnWorkerR1.setBounds(980, player.posWR1_y, dim_worker, dim_worker);

					} else if (btnWorkerR2.equals(e.getSource()) && btnWorkerR2.isEnabled()) {
						obj.add(btnWorkerR2);
						player.posWR2_y = 400;
						btnWorkerR2.setBounds(1020, player.posWR2_y, dim_worker, dim_worker);
					}
				}

				if (player.isFirstTurn) {
					if (btnWorkerB1.equals(e.getSource()) && btnWorkerB1.isEnabled()) {
						obj.add(btnWorkerB1);
						player.posWB1_y = 400;
						btnWorkerB1.setBounds(980, player.posWB1_y, dim_worker, dim_worker);

					} else if (btnWorkerB2.equals(e.getSource()) && btnWorkerB2.isEnabled()) {
						obj.add(btnWorkerB2);
						player.posWB2_y = 400;
						btnWorkerB2.setBounds(1020, player.posWB2_y, dim_worker, dim_worker);
					}
				}

			}

		};

	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideGuidePanel() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideGuidePanel();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionHideWarningPanel() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideWarningPanel();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionShowReturnHomeDialog() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showReturnHomeDialog();
			}
		};
	}

	/**
	 * 
	 * @return
	 */
	private ActionListener initActionShowHelpDialog() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showHelpDialog();
			}
		};
	}

	private ActionListener initActionHideReturnMainPage() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideReturnHomeDialog();
			}
		};
	}

}
