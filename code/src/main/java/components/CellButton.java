package src.main.java.components;

import javax.swing.JButton;

/*+
 * This class extends JButton and it is used for the graphic. 
 */
public class CellButton extends JButton {

	private static final long serialVersionUID = 7761064743097750289L;

	private int colIndex;
	private int rowIndex;

	public CellButton(int colIndex, int rowIndex) {
		this.colIndex = colIndex;
		this.rowIndex = rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}

	public int getRowIndex() {
		return rowIndex;
	}
}
