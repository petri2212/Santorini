package src.main.java;

import java.awt.Dimension;

import javax.swing.JFrame;

import src.main.java.gameComponents.GameManager;
import src.main.java.gui.controller.MainPageController;
import src.main.java.gui.view.graphic.*;
import resources.Images;

public class GraphicUI implements UI {

	private JFrame mainFrame;

	/**
	 * Methods to handle the graphic.
	 */
	public GraphicUI() {
		mainFrame = new JFrame();
		mainFrame.setMaximumSize(new Dimension(1140, 760));
		mainFrame.setMinimumSize(new Dimension(1140, 760));
		mainFrame.setPreferredSize(new Dimension(1140, 760));
		mainFrame.setSize(new Dimension(1140, 760));
		mainFrame.setIconImage(Images.ICON_SANTORINI.load());
		mainFrame.setTitle("Santorini");
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the controller and the view
	 * in the main page for the graphic.
	 */
	public void showMainPage(GameManager model) {
		MainPageViewGraphic view = new MainPageViewGraphic(mainFrame);
		MainPageController controller = new MainPageController(model, view);
		controller.start();
	}

	/**
	 * Initialize the controller and the view
	 * in the insert players page for the graphic.
	 */
	public void showInsertPlayersPage(GameManager model) {
		/*InsertPlayersViewGraphic view = new InsertPlayersViewGraphic(mainFrame);
		InsertPlayersController controller = new InsertPlayersController(model, view);
		controller.start();
*/
	}

	/**
	 * Initialize the controller and the view
	 * in the game stage page for the graphic.
	 */
	public void showGameStagePage(GameManager model) {
		/*GameStageViewGraphic view = new GameStageViewGraphic(mainFrame);
		GameStageController controller = new GameStageController(model, view);
		controller.start();*/
	}

	/**
	 * Initialize the controller and the view
	 * in the points page for the graphic.
	 */
	public void showWinnerPage(GameManager model) {
		/*PointsPageViewGraphic view = new PointsPageViewGraphic(mainFrame);
		PointsPageController controller = new PointsPageController(model, view);
		controller.start();
		*/
	}

}