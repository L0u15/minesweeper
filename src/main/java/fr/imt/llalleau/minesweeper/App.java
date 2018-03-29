package fr.imt.llalleau.minesweeper;

import java.awt.Toolkit;
import java.util.List;

import fr.imt.llalleau.minesweeper.events.KeyboardHandler;
import fr.imt.llalleau.minesweeper.graphics.GraphicalBoard;
import fr.imt.llalleau.minesweeper.model.Board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	public static Board board;
	public static GraphicalBoard gBoard;

	public static void main(String[] args) {
		Data.SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		Data.SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		try {
			calculateSizes();
			ImagesLoader.loadImages();
			board = new Board(Data.BOARD_HEIGHT, Data.BOARD_WIDTH, Data.MINES);
			gBoard = new GraphicalBoard();
			System.out.println(board);
			launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start(Stage stage) {

		List<Node> cases = gBoard.createBoard();

		Group root = new Group(cases);
		Scene scene = new Scene(root, Data.SQUARE_SIZE * Data.BOARD_WIDTH, Data.SQUARE_SIZE * Data.BOARD_HEIGHT);
		scene.setOnKeyPressed(new KeyboardHandler());
		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}

	private static void calculateSizes() {
		while(Data.BOARD_HEIGHT * Data.SQUARE_SIZE > Data.SCREEN_HEIGHT || Data.BOARD_WIDTH * Data.SQUARE_SIZE > Data.SCREEN_WIDTH) {
			Data.SQUARE_SIZE -= 4;
			if(Data.SQUARE_SIZE <Data.SQUARE_MINUMUM_SIZE) {
				System.out.println("That's way too much cells for you small screen !");
				System.exit(1);
			}
		}
	}
}
