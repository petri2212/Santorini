package src.main.java.components;

import javax.swing.JButton;

/*+
 * This class extends JButton and it is used for the graphic. 
 */
public class CellButton extends JButton {

	private static final long serialVersionUID = 7761064743097750289L;

	public int colIndex;
	public int rowIndex;
	public int posX;
	public int posY;

	public CellButton( int rowIndex,int colIndex, int posX, int posY) {
		this.colIndex = colIndex;
		this.rowIndex = rowIndex;
		this.posX = posX;
		this.posY = posY;
		
	}

	public int getColIndex() {
		return colIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}
}
