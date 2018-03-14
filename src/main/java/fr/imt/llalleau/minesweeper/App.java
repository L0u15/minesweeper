package fr.imt.llalleau.minesweeper;

import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.events.MouseClickHandler;
import fr.imt.llalleau.minesweeper.events.MouseHoverHandler;
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
	
	private static Square[][] tab;

	public static void main(String[] args) {
		try {
			ImagesLoader.loadImages();
			board = new Board(Constants.BOARD_HEIGHT, Constants.BOARD_WIDTH, Constants.MINES);
			tab = board.getTab();
			System.out.println(board);
			launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start(Stage stage) {
		final List<Node> nodes = new LinkedList<>();
		for (int h = 0; h < Constants.BOARD_HEIGHT; h++) {
			for (int w = 0; w < Constants.BOARD_WIDTH; w++) {
				final ImageView iv = new ImageView(ImagesLoader.hidden);
				iv.setX(w * iv.getImage().getWidth());
				iv.setY(h * iv.getImage().getHeight());

				iv.setOnMouseEntered(new MouseHoverHandler(iv));
				iv.setOnMouseExited(new MouseHoverHandler(iv));
				iv.setOnMouseClicked(new MouseClickHandler(iv));

				nodes.add(iv);
			}
		}
		Group root = new Group(nodes);
		Scene scene = new Scene(root, 410, 410);

		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}
}
