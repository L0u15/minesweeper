package fr.imt.llalleau.minesweeper;

import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.model.Board;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	
	public static int SQUARE_HEIGHT = 40;
	public static int SQUARE_WIDTH = 40;
	public static int SQUARE_SPACING = 1;

	public static int BOARD_HEIGHT = 5;
	public static int BOARD_WIDTH = 10;
	public static int MINES = 10;

	static Board board;

	public static void main(String[] args) {
		try {
			board = new Board(BOARD_HEIGHT, BOARD_WIDTH, MINES);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(board);
		launch();
	}

	public void start(Stage stage) {
		List<Node> children = new LinkedList<>();

		for (int h = 0; h < BOARD_HEIGHT; h++) {
			for (int w = 0; w < BOARD_WIDTH; w++) {
				final Rectangle r = new Rectangle(SQUARE_WIDTH, SQUARE_HEIGHT);
				r.setX(w * (r.getWidth() + SQUARE_SPACING));
				r.setY(h * (r.getHeight() + SQUARE_SPACING));
				r.setOnMouseEntered(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						r.setFill(Color.GRAY);
					}
				});
				r.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						r.setFill(Color.LIGHTGRAY);
					}
				});
				r.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						r.setFill(Color.RED);
						int w, h;
						w = (int) r.getX() / (SQUARE_WIDTH + SQUARE_SPACING);
						h = (int) r.getY() / (SQUARE_HEIGHT + SQUARE_SPACING);
						System.out.println(w + "   " + h);
						
					}
				});

				if (board.isMine(h, w)) {
					r.setFill(Color.RED);
				} else {
					r.setFill(Color.LIGHTGRAY);
				}

				children.add(r);
			}
		}
		Group root = new Group(children);
		Scene scene = new Scene(root, 410, 410);

		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}
}
