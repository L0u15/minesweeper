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
		
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				final Rectangle r = new Rectangle(40, 40);
				r.setX(x * (r.getWidth() + 1));
				r.setY(y * (r.getHeight() + 1));
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
					}
				});
				
				if (board.isMine(y, x)) {
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
