package src.main.java.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

import src.main.java.gamecomponents.Cell;

public class CellObjectButton extends JButton {

	private static final long serialVersionUID = -725489561743165796L;
	private Image backgroundIm;
	private Cell object;
	private int xPos;
	private int yPos;

	public CellObjectButton(Cell object, int x, int y, int level) {
		this.object = object;
	}

	public void setBackground(Image background1) {
		this.backgroundIm = background1;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundIm, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(backgroundIm.getWidth(this), backgroundIm.getHeight(this));
	}

	public void setObject(Cell object) {
		this.object = object;
	}

	public Cell getObject() {
		return object;
	}

	public int getX_pos() {
		return xPos;
	}

	public void setX_pos(int xPos) {
		this.xPos = xPos;
	}

	public int getY_pos() {
		return yPos;
	}

	public void setY_pos(int yPos) {
		this.yPos = yPos;
	}

}
