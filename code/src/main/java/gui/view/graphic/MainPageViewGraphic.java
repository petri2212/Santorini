package src.main.java.gui.view.graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import resources.Images;
import resources.Icons;
import src.main.java.components.BackgroundPanel;
import src.main.java.gui.view.MainPageView;
import src.main.java.components.*;

/**
 * This is the view graphic for the home page and it extends the abstract view.
 */

public class MainPageViewGraphic extends MainPageView {

	private JFrame mainFrame;

	public MainPageViewGraphic(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * This is the override of the show method. This method show the home page with
	 * two buttons: the new game button and the exit button.
	 * 
	 * @throws LineUnavailableException
	 */
	public void show() {

		Image image = Images.MAIN_PAGE_BACKGROUND.load();
		BackgroundPanel contentPane = new BackgroundPanel(image);
		contentPane.setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setOpaque(true);
		btnNewGame.setFocusPainted(false);

		btnNewGame.setFont(new Font("Purisa", Font.BOLD, 18));
		btnNewGame.setBounds(480, 232, 185, 62);
		btnNewGame.setBorder(new RoundedBorder(10)); // 10 is the radius
		// btnNewGame.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
		// null, null));
		btnNewGame.setMaximumSize(new Dimension(174, 62));
		btnNewGame.setMinimumSize(new Dimension(174, 62));
		btnNewGame.setPreferredSize(new Dimension(174, 62));
		btnNewGame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.setMargin(new Insets(0, 0, 0, 50));
		btnNewGame.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.addActionListener(actionNewGame);
		btnNewGame.setBackground(new Color(70, 130, 180));
		contentPane.add(btnNewGame);

		JButton btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(174, 62));
		btnExit.setOpaque(true);
		btnExit.setMinimumSize(new Dimension(174, 62));
		btnExit.setMaximumSize(new Dimension(174, 62));
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Purisa", Font.BOLD, 18));
		btnExit.setFocusPainted(false);
		btnExit.setBorder(new RoundedBorder(10)); // 10 is the radius
		// btnExit.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null,
		// null));
		btnExit.setBackground(new Color(70, 130, 180));
		btnExit.setAlignmentX(0.5f);
		btnExit.setBounds(480, 365, 185, 62);
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addActionListener(actionExit);
		contentPane.add(btnExit);

		JLabel lblVersionHeader = new JLabel("Version");
		lblVersionHeader.setForeground(Color.WHITE);
		lblVersionHeader.setFont(new Font("Purisa", Font.BOLD, 14));
		lblVersionHeader.setBounds(37, 696, 70, 15);
		contentPane.add(lblVersionHeader);

		JLabel lblVersion = new JLabel("1.0.0");
		lblVersion.setForeground(Color.WHITE);
		lblVersion.setFont(new Font("Purisa", Font.BOLD, 14));
		lblVersion.setBounds(114, 696, 70, 15);
		contentPane.add(lblVersion);

		JLabel lblSantorini = new JLabel("");
		lblSantorini.setForeground(new Color(70, 130, 180));
		lblSantorini.setFont(new Font("Purisa", Font.BOLD, 14));
		lblSantorini.setBounds(380, 50, 400, 147);
		lblSantorini.setIcon(Icons.SANTORINI_LOGO.load());
		contentPane.add(lblSantorini);

		mainFrame.setContentPane(contentPane);
		mainFrame.pack();
		mainFrame.revalidate();
		mainFrame.repaint();
	}

}
