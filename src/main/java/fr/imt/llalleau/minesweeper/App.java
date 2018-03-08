package fr.imt.llalleau.minesweeper;

import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.model.Board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	static Board board;

	public static void main(String[] args) {
		board = new Board(10, 10, 10);
		System.out.println(board);
		launch();
	}

	public void start(Stage stage) {
		List<Node> children = new LinkedList<>();
		for (int i = 0; i < board.getHeight(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				Rectangle r = new Rectangle(40, 40);
				r.setX(i * (r.getHeight() + 1));
				r.setY(j * (r.getWidth() + 1));
				children.add(r);
				System.out.println("new rectangle at " + (i * (r.getHeight() + 1)) + " - " + (j * (r.getWidth() + 1)));
			}
		}
		Group root = new Group(children);
		Scene scene = new Scene(root, 600, 600);

		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}
}
