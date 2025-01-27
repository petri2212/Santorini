package src.main.java.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

import src.main.java.gameComponents.Cell;

public class CellObjectButton extends JButton {

	private static final long serialVersionUID = -725489561743165796L;
	private Image background;
	private Cell object;
	private int x_pos;
	private int y_pos;

	public CellObjectButton(Cell object, int x, int y, int level) {
		// setBackground(object.getImage());
		this.object = object;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(background.getWidth(this), background.getHeight(this));
	}

	public void setObject(Cell object) {
		this.object = object;
	}

	public Cell getObject() {
		return object;
	}

	public int getX_pos() {
		return x_pos;
	}

	public void setX_pos(int x_pos) {
		this.x_pos = x_pos;
	}

	public int getY_pos() {
		return y_pos;
	}

	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}

}
