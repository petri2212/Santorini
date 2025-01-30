package src.main.java.gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import src.main.java.components.BackgroundPanel;
import src.main.java.gui.view.InsertPlayersView;
import src.main.java.gameComponents.Player;
import resources.Images;
import resources.Icons;

/**
 * This is the view graphic for the insert players page and it extends the
 * abstract view.
 */
public class InsertPlayersViewGraphic extends InsertPlayersView {

	private static final int PLAYER1_INDEX = 0;
	private static final int PLAYER2_INDEX = 1;

	private JFrame mainFrame;
	private JTextField txtPlayerName;
	private JPanel panelWarning;
	private JLabel lblWarning;
	private JLabel[] lblPlayers = new JLabel[2];

	public InsertPlayersViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * This is the override of the show method. This method let the user to insert
	 * the names of the players and to start a new game.
	 */
	public void show() {
		Image image = Images.IN_PLAYERS_BLURRED_BACK.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);

		panelWarning = new JPanel();
		panelWarning.setVisible(false);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		JLabel lblWarningHeader = new JLabel("Warning");
		lblWarningHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarningHeader.setBounds(0, 0, 537, 41);
		panelWarning.add(lblWarningHeader);

		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JButton btnAcknowledge = new JButton("Ok");
		btnAcknowledge.setBounds(208, 193, 117, 25);
		btnAcknowledge.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelWarning.setVisible(false);
			}
		});
		panelWarning.add(btnAcknowledge);

		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setOpaque(false);
		panelPlayer1.setBounds(86, 12, 440, 171);
		contentPane.add(panelPlayer1);
		panelPlayer1.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer1Header = new JLabel("Player 1");
		lblPlayer1Header.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayer1.add(lblPlayer1Header, BorderLayout.CENTER);
		lblPlayer1Header.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1Header.setForeground(new Color(252, 61, 3));
		lblPlayer1Header.setIconTextGap(20);
		lblPlayer1Header.setIcon(Icons.FIRST_PLAYER_ICON.load());

		lblPlayers[PLAYER1_INDEX] = new JLabel("___________________");
		JLabel lblPlayer1 = lblPlayers[PLAYER1_INDEX];
		panelPlayer1.add(lblPlayer1, BorderLayout.SOUTH);
		lblPlayer1.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1.setForeground(new Color(252, 61, 3));
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setHorizontalTextPosition(SwingConstants.CENTER);

		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setOpaque(false);
		panelPlayer2.setBounds(594, 12, 440, 171);
		contentPane.add(panelPlayer2);
		panelPlayer2.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer2Header = new JLabel("Player 2");
		lblPlayer2Header.setIcon(Icons.SECOND_PLAYER_ICON.load());
		lblPlayer2Header.setIconTextGap(20);
		lblPlayer2Header.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2Header.setForeground(new Color(70, 130, 180));
		lblPlayer2Header.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer2.add(lblPlayer2Header, BorderLayout.CENTER);

		lblPlayers[PLAYER2_INDEX] = new JLabel("___________________");
		JLabel lblPlayer2 = lblPlayers[PLAYER2_INDEX];
		lblPlayer2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer2.setForeground(new Color(70, 130, 180));
		lblPlayer2.setFont(new Font("Purisa", Font.BOLD, 18));
		panelPlayer2.add(lblPlayer2, BorderLayout.SOUTH);

		JPanel panelPlayer3 = new JPanel();
		panelPlayer3.setOpaque(false);
		panelPlayer3.setBounds(86, 247, 440, 171);
		contentPane.add(panelPlayer3);
		panelPlayer3.setLayout(new BorderLayout(0, 0));

		JLabel lblInsertNewPlayer = new JLabel("Insert New Player");
		lblInsertNewPlayer.setFont(new Font("Purisa", Font.BOLD, 18));
		lblInsertNewPlayer.setForeground(new Color(255, 255, 255));
		lblInsertNewPlayer.setBounds(469, 460, 209, 30);
		contentPane.add(lblInsertNewPlayer);

		JPanel panelInsertPlayer = new JPanel();
		panelInsertPlayer.setOpaque(false);
		panelInsertPlayer.setBorder(new LineBorder(new Color(246, 245, 244), 3, true));
		panelInsertPlayer.setBounds(333, 506, 465, 69);
		contentPane.add(panelInsertPlayer);
		panelInsertPlayer.setLayout(null);

		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setBounds(12, 25, 121, 23);
		lblPlayerName.setFont(new Font("Purisa", Font.BOLD, 16));
		lblPlayerName.setForeground(new Color(255, 255, 255));
		panelInsertPlayer.add(lblPlayerName);

		txtPlayerName = new JTextField();
		txtPlayerName.setCaretColor(new Color(255, 255, 255));
		txtPlayerName.setFont(new Font("Purisa", Font.PLAIN, 14));
		txtPlayerName.setBounds(151, 26, 182, 19);
		txtPlayerName.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (Character.isAlphabetic(e.getKeyCode())) {
					setInput(txtPlayerName.getText());
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		panelInsertPlayer.add(txtPlayerName);
		txtPlayerName.setColumns(10);

		JButton btnAddPlayer = new JButton("Add");
		btnAddPlayer.setOpaque(false);
		btnAddPlayer.setBackground(new Color(255, 255, 255));
		btnAddPlayer.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAddPlayer.setForeground(new Color(255, 255, 255));
		btnAddPlayer.setFont(new Font("Purisa", Font.BOLD, 16));
		btnAddPlayer.setBounds(363, 18, 79, 36);
		panelInsertPlayer.add(btnAddPlayer);
		btnAddPlayer.setIconTextGap(0);
		btnAddPlayer.setFocusPainted(false);
		btnAddPlayer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddPlayer.addActionListener(actionInsertPlayer);
		btnAddPlayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearInputField();
			}
		});

		JButton btnHome = new JButton("<--");
		btnHome.setBackground(new Color(255, 255, 255));
		btnHome.setOpaque(false);
		btnHome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHome.setFont(new Font("Purisa", Font.BOLD, 16));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setFocusPainted(false);
		btnHome.setHideActionText(true);
		btnHome.setBounds(38, 633, 84, 48);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.addActionListener(actionReturnMainPage);
		contentPane.add(btnHome);

		JButton btnInitGame = new JButton("Start Game");
		btnInitGame.setOpaque(false);
		btnInitGame.setBackground(new Color(255, 255, 255));
		btnInitGame.setFocusPainted(false);
		btnInitGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInitGame.setFont(new Font("Purisa", Font.BOLD, 16));
		btnInitGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnInitGame.setForeground(new Color(255, 255, 255));
		btnInitGame.setIconTextGap(-100);
		btnInitGame.setBounds(510, 625, 144, 64);
		btnInitGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInitGame.addActionListener(actionInitGame);
		contentPane.add(btnInitGame);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

	@Override
	public void showTooFewPlayersWarning() {
		panelWarning.setVisible(true);
		lblWarning.setText("You must insert at least two players.");
	}

	@Override
	public void showTooManyPlayersWarning() {
		panelWarning.setVisible(true);
		lblWarning.setText("You reached the maximum number of player.");
	}

	@Override
	public void showDoublePlayersWarning() {
		panelWarning.setVisible(true);
		lblWarning.setText("This player name has already been taken, please choose another name.");
	}

	@Override
	public void showInvalidInputWarning() {
		panelWarning.setVisible(true);
		lblWarning.setText("Invalid player name, please type a name long at least one character.");
	}

	@Override
	public void showInseredPlayer() {
		ArrayList<Player> players = getInseredPlayers();

		for (int i = 0; i < players.size(); i++) {
			String playerName = players.get(i).getName();
			lblPlayers[i].setText(playerName);
		}

	}

	private void clearInputField() {
		txtPlayerName.setText("");
	}

}
