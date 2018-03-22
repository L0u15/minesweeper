package fr.imt.llalleau.minesweeper;

import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.events.MouseClickHandler;
import fr.imt.llalleau.minesweeper.events.MouseHoverHandler;
import fr.imt.llalleau.minesweeper.graphics.GraphicalBoard;
import fr.imt.llalleau.minesweeper.model.Board;
import fr.imt.llalleau.minesweeper.model.square.Square;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	public static Board board;
	public static GraphicalBoard gBoard;


	public static void main(String[] args) {
		try {
			ImagesLoader.loadImages();
			board = new Board(Constants.BOARD_HEIGHT, Constants.BOARD_WIDTH, Constants.MINES);
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
		Scene scene = new Scene(root, 410, 410);

		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}
}
