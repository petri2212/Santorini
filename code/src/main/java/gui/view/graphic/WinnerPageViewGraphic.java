package src.main.java.gui.view.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import resources.Icons;
import resources.Images;
import src.main.java.components.BackgroundPanel;
import src.main.java.components.RoundedBorder;
import src.main.java.gui.view.WinnerPageView;

/**
 * This is the view graphic for the Winner page and it extends the abstract
 * view.
 */

public class WinnerPageViewGraphic extends WinnerPageView {
	
	private JFrame mainFrame;
	private JTextField txtPlayerName;
	private JPanel panelWarning;
	private JLabel lblWarning;
	private JLabel lblPlayer;
	
	public WinnerPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void show() {
		Image image = Images.END_PAGE_BACKGROUND.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);

		panelWarning = new JPanel();
		panelWarning.setVisible(false);
		panelWarning.setBounds(288, 285, 537, 246);
		contentPane.add(panelWarning);
		panelWarning.setLayout(null);

		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(10, 53, 515, 128);
		panelWarning.add(lblWarning);

		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setOpaque(false);
		panelPlayer1.setBounds(350, 200, 440, 171);
		contentPane.add(panelPlayer1);
		panelPlayer1.setLayout(new BorderLayout(0, 0));

		JLabel lblPlayer1Header = new JLabel("WINNER");
		lblPlayer1Header.setHorizontalAlignment(SwingConstants.CENTER);
		panelPlayer1.add(lblPlayer1Header, BorderLayout.CENTER);
		lblPlayer1Header.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1Header.setForeground(new Color(255, 255, 255));
		lblPlayer1Header.setIconTextGap(20);
		lblPlayer1Header.setIcon(Icons.FIRST_PLAYER_ICON.load());

		lblPlayer = new JLabel(winner);
		JLabel lblPlayer1 = lblPlayer;
		panelPlayer1.add(lblPlayer1, BorderLayout.SOUTH);
		lblPlayer1.setFont(new Font("Purisa", Font.BOLD, 18));
		lblPlayer1.setForeground(new Color(255, 255, 255));
		lblPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer1.setHorizontalTextPosition(SwingConstants.CENTER);
		

		JButton btnInitGame = new JButton("Main Page");
		
		btnInitGame.setOpaque(true);
		btnInitGame.setFocusPainted(false);

		btnInitGame.setFont(new Font("Purisa", Font.BOLD, 18));
		btnInitGame.setBounds(480, 500, 185, 62);
		btnInitGame.setBorder(new RoundedBorder(10)); // 10 is the radius
		// btnNewGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
		// null, null));
		btnInitGame.setMaximumSize(new Dimension(174, 62));
		btnInitGame.setMinimumSize(new Dimension(174, 62));
		btnInitGame.setPreferredSize(new Dimension(174, 62));
		btnInitGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInitGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnInitGame.setMargin(new Insets(0, 0, 0, 50));
		btnInitGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInitGame.setForeground(Color.WHITE);
		btnInitGame.setBackground(new Color(70, 130, 180));
		btnInitGame.addActionListener(actionReturnMainPage);
		contentPane.add(btnInitGame);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
