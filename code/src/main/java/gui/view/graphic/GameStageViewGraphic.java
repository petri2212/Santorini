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

import src.main.java.components.BackgroundPanel;
import src.main.java.components.CellButton;
import src.main.java.gamecomponents.Cell;
import src.main.java.gamecomponents.Check;
import src.main.java.gui.view.GameStageView;
import resources.Icons;
import resources.Images;

/**
 * This is the view graphic for the game stage page and it extends the abstract
 * view.
 */
public class GameStageViewGraphic extends GameStageView {

	private final static String FONT = "Purisa";

	private final int spazioXY = 142;
	private final int btnLength = 124;
	private final int dimWorker = 30;

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
	BackgroundPanel[][] objectPanel = new BackgroundPanel[25][25];

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

		JLabel lblGuide = new JLabel(
				"<html><p dir=\"auto\">In <strong>ogni turno</strong> il giocatore sceglier&agrave; solo uno tra i suoi worker, lo dovr&agrave; muovere e solo dopo costruire con lo stesso.</p>\r\n"
						+ "<p dir=\"auto\">&nbsp;</p>\r\n"
						+ "<p dir=\"auto\">Il <strong>worker</strong> si pu&ograve; muovere nelle 8 caselle adiacenti a s&eacute; che non siano occupati da un altro worker o una&nbsp;<strong><em>dome</em></strong> (cupola). Il <strong>worker</strong> pu&ograve; muoversi verso l'alto di solo un livello alla volta (non pu&ograve; salire due livelli in un solo turno). Il <strong>worker</strong> pu&ograve; sempre muoversi verso il basso, indipendentemente da quanti livelli deve passare.</p>\r\n"
						+ "<p dir=\"auto\">Si pu&ograve; costruire un&nbsp;<strong><em>block</em>&nbsp;</strong>o una&nbsp;<strong><em>dome</em>&nbsp;</strong>in una delle 8 caselle adiacenti e libere da altri lavoratori attorno al lavoratore appena mosso. Si pu&ograve; costruire una&nbsp;<em>dome</em>&nbsp;solo sopra un edificio composto da 3&nbsp;<em>blocks. </em>Una torre di 3&nbsp;<em>blocks</em>&nbsp;e una&nbsp;<em>dome</em>&nbsp;in cima viene chiamata&nbsp;<strong><em>Complete Tower</em></strong> (Torre Completa).</p>\r\n"
						+ "<p dir=\"auto\">&nbsp;</p>\r\n"
						+ "<p dir=\"auto\">Se un <strong>worke</strong>r arriva ad altezza 3 il suo rispettivo giocatore vince. Un giocatore deve sempre avere un worker capace di muoversi di una casella, altrimenti ha perso</p>\r\n"
						+ "<div class=\"markdown-heading\" dir=\"auto\">&nbsp;</div>\r\n"
						+ "<div class=\"markdown-heading\" dir=\"auto\">&nbsp;</div>\r\n"
						+ "<div class=\"markdown-heading\" dir=\"auto\">&nbsp;</div></html>");
		lblGuide.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuide.setBounds(10, 40, 515, 270); // 515, 230
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
		JLabel workers = new JLabel("Workers");
		workers.setVerticalAlignment(SwingConstants.BOTTOM);
		workers.setHorizontalTextPosition(SwingConstants.CENTER);
		workers.setHorizontalAlignment(SwingConstants.CENTER);
		workers.setForeground(Color.WHITE);
		workers.setFont(new Font(FONT, Font.BOLD, 16));
		workers.setBounds(942, 0, 188, 46);
		contentPane.add(workers);

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
		btnWorkerR1.setFont(new Font(FONT, Font.BOLD, 16));
		btnWorkerR1.setBounds(player.posWR1X, player.posWR1Y, dimWorker, dimWorker);
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
		btnWorkerR2.setFont(new Font(FONT, Font.BOLD, 16));
		btnWorkerR2.setBounds(player.posWR2X, player.posWR2Y, dimWorker, dimWorker);
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
		btnWorkerB1.setFont(new Font(FONT, Font.BOLD, 16));
		btnWorkerB1.setBounds(player.posWB1X, player.posWB1Y, 30, 30);
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
		btnWorkerB2.setFont(new Font(FONT, Font.BOLD, 16));
		btnWorkerB2.setBounds(player.posWB2X, player.posWB1Y, 30, 30);
		btnWorkerB2.addActionListener(actionPutWorkersInQueue);
		contentPane.add(btnWorkerB2);

		printWorkers();

		JLabel lblPlayerTurnHeader = new JLabel("Player's Turn:");
		lblPlayerTurnHeader.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPlayerTurnHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerTurnHeader.setFont(new Font(FONT, Font.BOLD, 16));
		lblPlayerTurnHeader.setForeground(new Color(255, 255, 255));
		lblPlayerTurnHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerTurnHeader.setBounds(0, 0, 188, 46);
		contentPane.add(lblPlayerTurnHeader);

		lblPlayerTurn = new JLabel(playerName);
		lblPlayerTurn.setFont(new Font(FONT, Font.BOLD, 16));
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
		lblPickedWorker.setFont(new Font(FONT, Font.BOLD, 16));
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
		lblObject1.setFont(new Font(FONT, Font.BOLD, 60));
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
		lblObject2.setFont(new Font(FONT, Font.BOLD, 60));
		lblObject2.setForeground(new Color(237, 51, 59));
		panelObject2.add(lblObject2);

		btnHelp = new JButton("Help");
		btnHelp.setBackground(new Color(255, 255, 255));
		btnHelp.setOpaque(false);
		btnHelp.setFocusPainted(false);
		btnHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHelp.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHelp.setForeground(new Color(255, 255, 255));
		btnHelp.setFont(new Font(FONT, Font.BOLD, 16));
		btnHelp.setBounds(965, 645, 142, 57);
		btnHelp.addActionListener(actionShowHelpDialog);

		contentPane.add(btnHelp);

		btnEndTurn = new JButton("End Turn");
		if (isFirstTurn || player.isFirstTurn) {
			btnEndTurn.setEnabled(false);
		} else {
			btnEndTurn.setEnabled(true);
		}
		btnEndTurn.setVisible(true);
		btnEndTurn.setBackground(new Color(255, 255, 255));
		btnEndTurn.setOpaque(false);
		btnEndTurn.setFocusPainted(false);
		btnEndTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEndTurn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEndTurn.setForeground(new Color(255, 255, 255));
		btnEndTurn.setFont(new Font(FONT, Font.BOLD, 16));
		btnEndTurn.setBounds(965, 550, 142, 57);
		btnEndTurn.addActionListener(actionEndTurn);
		contentPane.add(btnEndTurn);

		JButton btnHome = new JButton("<--");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setOpaque(false);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font(FONT, Font.BOLD, 16));
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

		CellButton btnRig0Col0 = new CellButton(0, 0, 0, 0);
		btnRig0Col0.setBorder(null);
		btnRig0Col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0Col0.setContentAreaFilled(false);
		btnRig0Col0.setBounds(0, 0, btnLength, btnLength);
		btnRig0Col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0Col0);

		CellButton btnRig0Col1 = new CellButton(0, 1, spazioXY, 0);
		btnRig0Col1.setBorder(null);
		btnRig0Col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0Col1.setContentAreaFilled(false);
		btnRig0Col1.setBounds(spazioXY, 0, btnLength, btnLength);
		btnRig0Col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0Col1);

		CellButton btnRig0Col2 = new CellButton(0, 2, spazioXY * 2, 0);
		btnRig0Col2.setBorder(null);
		btnRig0Col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0Col2.setContentAreaFilled(false);
		btnRig0Col2.setBounds(spazioXY * 2, 0, btnLength, btnLength);
		btnRig0Col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0Col2);

		CellButton btnRig0Col3 = new CellButton(0, 3, spazioXY * 3, 0);
		btnRig0Col3.setBorder(null);
		btnRig0Col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0Col3.setContentAreaFilled(false);
		btnRig0Col3.setBounds(spazioXY * 3, 0, btnLength, btnLength);
		btnRig0Col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0Col3);

		CellButton btnRig0Col4 = new CellButton(0, 4, spazioXY * 4, 0);
		btnRig0Col4.setBorder(null);
		btnRig0Col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig0Col4.setContentAreaFilled(false);
		btnRig0Col4.setBounds(spazioXY * 4, 0, btnLength, btnLength);
		btnRig0Col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig0Col4);

		// Bottoni seconda riga

		CellButton btnRig1Col0 = new CellButton(1, 0, 0, spazioXY);
		btnRig1Col0.setBorder(null);
		btnRig1Col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1Col0.setContentAreaFilled(false);
		btnRig1Col0.setBounds(0, spazioXY, btnLength, btnLength);
		btnRig1Col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1Col0);

		CellButton btnRig1Col1 = new CellButton(1, 1, spazioXY, spazioXY);
		btnRig1Col1.setBorder(null);
		btnRig1Col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1Col1.setContentAreaFilled(false);
		btnRig1Col1.setBounds(spazioXY, spazioXY, btnLength, btnLength);
		btnRig1Col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1Col1);

		CellButton btnRig1Col2 = new CellButton(1, 2, spazioXY * 2, spazioXY);
		btnRig1Col2.setBorder(null);
		btnRig1Col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1Col2.setContentAreaFilled(false);
		btnRig1Col2.setBounds(spazioXY * 2, spazioXY, btnLength, btnLength);
		btnRig1Col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1Col2);

		CellButton btnRig1Col3 = new CellButton(1, 3, spazioXY * 3, spazioXY);
		btnRig1Col3.setBorder(null);
		btnRig1Col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1Col3.setContentAreaFilled(false);
		btnRig1Col3.setBounds(spazioXY * 3, spazioXY, btnLength, btnLength);
		btnRig1Col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1Col3);

		CellButton btnRig1Col4 = new CellButton(1, 4, spazioXY * 4, spazioXY);
		btnRig1Col4.setBorder(null);
		btnRig1Col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig1Col4.setContentAreaFilled(false);
		btnRig1Col4.setBounds(spazioXY * 4, spazioXY, btnLength, btnLength);
		btnRig1Col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig1Col4);

		// Bottoni terza riga

		CellButton btnRig3Col0 = new CellButton(2, 0, 0, spazioXY * 2);
		btnRig3Col0.setBorder(null);
		btnRig3Col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3Col0.setContentAreaFilled(false);
		btnRig3Col0.setBounds(0, spazioXY * 2, btnLength, btnLength);
		btnRig3Col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3Col0);

		CellButton btnRig3Col1 = new CellButton(2, 1, spazioXY, spazioXY * 2);
		btnRig3Col1.setBorder(null);
		btnRig3Col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3Col1.setContentAreaFilled(false);
		btnRig3Col1.setBounds(spazioXY, spazioXY * 2, btnLength, btnLength);
		btnRig3Col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3Col1);

		CellButton btnRig3Col2 = new CellButton(2, 2, spazioXY * 2, spazioXY * 2);
		btnRig3Col2.setBorder(null);
		btnRig3Col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3Col2.setContentAreaFilled(false);
		btnRig3Col2.setBounds(spazioXY * 2, spazioXY * 2, btnLength, btnLength);
		btnRig3Col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3Col2);

		CellButton btnRig3Col3 = new CellButton(2, 3, spazioXY * 3, spazioXY * 2);
		btnRig3Col3.setBorder(null);
		btnRig3Col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3Col3.setContentAreaFilled(false);
		btnRig3Col3.setBounds(spazioXY * 3, spazioXY * 2, btnLength, btnLength);
		btnRig3Col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3Col3);

		CellButton btnRig3Col4 = new CellButton(2, 4, spazioXY * 4, spazioXY * 2);
		btnRig3Col4.setBorder(null);
		btnRig3Col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig3Col4.setContentAreaFilled(false);
		btnRig3Col4.setBounds(spazioXY * 4, spazioXY * 2, btnLength, btnLength);
		btnRig3Col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig3Col4);

		// Bottoni quarta riga

		CellButton btnRig4Col0 = new CellButton(3, 0, 0, spazioXY * 3);
		btnRig4Col0.setBorder(null);
		btnRig4Col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4Col0.setContentAreaFilled(false);
		btnRig4Col0.setBounds(0, spazioXY * 3, btnLength, btnLength);
		btnRig4Col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4Col0);

		CellButton btnRig4Col1 = new CellButton(3, 1, spazioXY, spazioXY * 3);
		btnRig4Col1.setBorder(null);
		btnRig4Col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4Col1.setContentAreaFilled(false);
		btnRig4Col1.setBounds(spazioXY, spazioXY * 3, btnLength, btnLength);
		btnRig4Col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4Col1);

		CellButton btnRig4Col2 = new CellButton(3, 2, spazioXY * 2, spazioXY * 3);
		btnRig4Col2.setBorder(null);
		btnRig4Col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4Col2.setContentAreaFilled(false);
		btnRig4Col2.setBounds(spazioXY * 2, spazioXY * 3, btnLength, btnLength);
		btnRig4Col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4Col2);

		CellButton btnRig4Col3 = new CellButton(3, 3, spazioXY * 3, spazioXY * 3);
		btnRig4Col3.setBorder(null);
		btnRig4Col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4Col3.setContentAreaFilled(false);
		btnRig4Col3.setBounds(spazioXY * 3, spazioXY * 3, btnLength, btnLength);
		btnRig4Col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4Col3);

		CellButton btnRig4Col4 = new CellButton(3, 4, spazioXY * 4, spazioXY * 3);
		btnRig4Col4.setBorder(null);
		btnRig4Col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig4Col4.setContentAreaFilled(false);
		btnRig4Col4.setBounds(spazioXY * 4, spazioXY * 3, btnLength, btnLength);
		btnRig4Col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig4Col4);

		// Bottoni quinta riga

		CellButton btnRig5Col0 = new CellButton(4, 0, 0, spazioXY * 4);
		btnRig5Col0.setBorder(null);
		btnRig5Col0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5Col0.setContentAreaFilled(false);
		btnRig5Col0.setBounds(0, spazioXY * 4, btnLength, btnLength);
		btnRig5Col0.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5Col0);

		CellButton btnRig5Col1 = new CellButton(4, 1, spazioXY, spazioXY * 4);
		btnRig5Col1.setBorder(null);
		btnRig5Col1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5Col1.setContentAreaFilled(false);
		btnRig5Col1.setBounds(spazioXY, spazioXY * 4, btnLength, btnLength);
		btnRig5Col1.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5Col1);

		CellButton btnRig5Col2 = new CellButton(4, 2, spazioXY * 2, spazioXY * 4);
		btnRig5Col2.setBorder(null);
		btnRig5Col2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5Col2.setContentAreaFilled(false);
		btnRig5Col2.setBounds(spazioXY * 2, spazioXY * 4, btnLength, btnLength);
		btnRig5Col2.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5Col2);

		CellButton btnRig5Col3 = new CellButton(4, 3, spazioXY * 3, spazioXY * 4);
		btnRig5Col3.setBorder(null);
		btnRig5Col3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5Col3.setContentAreaFilled(false);
		btnRig5Col3.setBounds(spazioXY * 3, spazioXY * 4, btnLength, btnLength);
		btnRig5Col3.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5Col3);

		CellButton btnRig5Col4 = new CellButton(4, 4, spazioXY * 4, spazioXY * 4);
		btnRig5Col4.setBorder(null);
		btnRig5Col4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRig5Col4.setContentAreaFilled(false);
		btnRig5Col4.setBounds(spazioXY * 4, spazioXY * 4, btnLength, btnLength);
		btnRig5Col4.addMouseListener(actionMouseOnBoard);
		panelBoardbottons.add(btnRig5Col4);

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
				if (isFirstTurn && !obj.isEmpty()) {
					if (obj.get(0).equals(btnWorkerR1)) {
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
							board.placeWorker(player.getWorker(0), button.getRowIndex(), button.getColIndex());
							obj.remove(btnWorkerR1);
							btnWorkerR1.setBounds(button.posX + 266, button.posY + 66, dimWorker, dimWorker);
							btnWorkerR1.setEnabled(false);
						}

					} else if (obj.get(0).equals(btnWorkerR2)) {
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
							board.placeWorker(player.getWorker(1), button.getRowIndex(), button.getColIndex());
							obj.remove(btnWorkerR2);
							btnWorkerR2.setBounds(button.posX + 266, button.posY + 66, dimWorker, dimWorker);
							btnWorkerR2.setEnabled(false);
						}
					}

				}

				/*
				 * This control for the red's turn enable the endButton only when he has placed
				 * all two workers
				 */
				if (!btnWorkerR1.isEnabled() && !btnWorkerR2.isEnabled()) {
					btnEndTurn.setEnabled(true);
				}

				if (player.isFirstTurn && !obj.isEmpty()) {

					if (obj.get(0).equals(btnWorkerB1)) {

						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
							board.placeWorker(player.getWorker(0), button.getRowIndex(), button.getColIndex());
							obj.remove(btnWorkerB1);
							btnWorkerB1.setBounds(button.posX + 266, button.posY + 66, dimWorker, dimWorker);
							btnWorkerB1.setEnabled(false);
						}
					} else if (obj.get(0).equals(btnWorkerB2)) {
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()) {
							board.placeWorker(player.getWorker(1), button.getRowIndex(), button.getColIndex());
							obj.remove(btnWorkerB2);
							btnWorkerB2.setBounds(button.posX + 266, button.posY + 66, dimWorker, dimWorker);
							btnWorkerB2.setEnabled(false);
						}
					}

				}

				/*
				 * This control for the blue's turn enable the endButton only when he has placed
				 * all two workers
				 */
				if (!btnWorkerB1.isEnabled() && !btnWorkerB2.isEnabled()) {
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
						if (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker()
								&& Check.isValidMovement(
										board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
										board.cellAt(button.getRowIndex(), button.getColIndex()))
								&& Check.aroundWorkerAndTowerCells(
										board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
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
					} else if ((buildPhase && cellButton.size() == 1)
							&& (!board.cellAt(button.getRowIndex(), button.getColIndex()).getStatusWorker())) {

						if (Check.isValidConstruction(board.cellAt(button.getRowIndex(), button.getColIndex()))
								&& Check.aroundWorkerAndTowerCells(
										board.cellAt(cellButton.get(0).rowIndex, cellButton.get(0).colIndex),
										board.cellAt(button.getRowIndex(), button.getColIndex()))) {
							board.cellAt(button.rowIndex, button.colIndex).levelUpTower();
							// int height = board.cellAt(button.rowIndex, button.colIndex).getHeight();
							System.out.println("il livello della torre su cui si vuole costruire è: "
									+ board.cellAt(button.rowIndex, button.colIndex).getHeight());
							movePhase = false;
							buildPhase = false;
							printTowers();
							printWorkers();
						} else {
							cellButton.remove(0);
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
				if (height == 0) {
					continue;
				}

				Image image = null;
				if (height == 1) {

					image = Images.ICON_BLOCK_LAYER1.load();

				} else if (height == 2) {
					image = Images.ICON_BLOCK_LAYER2.load();

				} else if (height == 3) {
					image = Images.ICON_BLOCK_LAYER3.load();

				} else if (height == 4) {
					image = Images.ICON_BLOCK_DOME.load();

				}
				if (objectPanel[r][c] == null) {
					objectPanel[r][c] = new BackgroundPanel(image);
				} else {
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
		panelBoardbottons.setVisible(false);
		panelBoardbottons.setEnabled(false);
	}

	private void showHelpDialog() {
		panelGuide.setVisible(true);
		panelObjects.setVisible(false);
		panelObjects.setEnabled(false);
		panelBoardbottons.setVisible(false);
		panelBoardbottons.setEnabled(false);

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
						player.posWR1Y = 400;
						btnWorkerR1.setBounds(980, player.posWR1Y, dimWorker, dimWorker);

					} else if (btnWorkerR2.equals(e.getSource()) && btnWorkerR2.isEnabled()) {
						obj.add(btnWorkerR2);
						player.posWR2Y = 400;
						btnWorkerR2.setBounds(1020, player.posWR2Y, dimWorker, dimWorker);
					}
				}

				if (player.isFirstTurn) {
					if (btnWorkerB1.equals(e.getSource()) && btnWorkerB1.isEnabled()) {
						obj.add(btnWorkerB1);
						player.posWB1Y = 400;
						btnWorkerB1.setBounds(980, player.posWB1Y, dimWorker, dimWorker);

					} else if (btnWorkerB2.equals(e.getSource()) && btnWorkerB2.isEnabled()) {
						obj.add(btnWorkerB2);
						player.posWB2Y = 400;
						btnWorkerB2.setBounds(1020, player.posWB2Y, dimWorker, dimWorker);
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
