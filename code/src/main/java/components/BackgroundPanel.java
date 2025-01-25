package src.main.java.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JPanel;
/*+
 * This class extends JPanel and it is used for the graphic. 
 */

public class BackgroundPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image background;

	public BackgroundPanel() {
		setLayout(new BorderLayout());
	}

	public BackgroundPanel(Image background) {
		this.background = background;
		setLayout(new BorderLayout());
	}

	public BackgroundPanel(Image background, LayoutManager layout) {
		this.background = background;
		setLayout(layout);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null); // image full size
		// g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}

	public void setBackground(Image background) {
		this.background = background;
		this.revalidate();
		this.repaint();
	}
}
