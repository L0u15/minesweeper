package fr.imt.llalleau.minesweeper;

import java.net.NetworkInterface;
import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.model.Board;
import fr.imt.llalleau.minesweeper.model.square.Square;
import fr.imt.llalleau.minesweeper.model.square.State;
import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Number;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

	public static int SQUARE_HEIGHT = 32;
	public static int SQUARE_WIDTH = 32;
	public static int SQUARE_SPACING = 0;

	public static int BOARD_HEIGHT = 5;
	public static int BOARD_WIDTH = 10;
	public static int MINES = 10;

	static Board board;
	static Square[][] tab;

	public static void main(String[] args) {
		try {
			board = new Board(BOARD_HEIGHT, BOARD_WIDTH, MINES);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tab = board.getTab();
		System.out.println(board);
		launch();
	}

	public void start(Stage stage) {

		final Image hidden = new Image("hidden.png");
		final Image mine = new Image("mine.png");
		final Image flag = new Image("flag.png");
		final Image[] numbers = new Image[9];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Image(i + ".png");
		}

		final List<Node> children = new LinkedList<>();

		for (int h = 0; h < BOARD_HEIGHT; h++) {
			for (int w = 0; w < BOARD_WIDTH; w++) {

				final ImageView iv = new ImageView(hidden);
				iv.setX(w * iv.getImage().getWidth());
				iv.setY(h * iv.getImage().getHeight());
				
				
				

				iv.setOnMouseEntered(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						int w, h;
						w = (int) iv.getX() / (SQUARE_WIDTH + SQUARE_SPACING);
						h = (int) iv.getY() / (SQUARE_HEIGHT + SQUARE_SPACING);
						if (tab[h][w].getState() == State.HIDDEN || tab[h][w].getState() == State.FLAG) {
							iv.setOpacity(0.6f);
						}
					}
				});
				iv.setOnMouseExited(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						int w, h;
						w = (int) iv.getX() / (SQUARE_WIDTH + SQUARE_SPACING);
						h = (int) iv.getY() / (SQUARE_HEIGHT + SQUARE_SPACING);		
							iv.setOpacity(1.f);
					}
				});

				iv.setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						
						int w, h;
						w = (int) iv.getX() / (SQUARE_WIDTH + SQUARE_SPACING);
						h = (int) iv.getY() / (SQUARE_HEIGHT + SQUARE_SPACING);
						
						if (event.getButton() == MouseButton.PRIMARY) {
							if (tab[h][w].getState() == State.HIDDEN) {
								tab[h][w].setState(State.REVEALED);
								if (tab[h][w] instanceof Number) {
									int n = ((Number) tab[h][w]).getValue();
									iv.setImage(numbers[n]);
									if (((Number) tab[h][w]).getValue() == 0) {
										// TODO Reveal surroundings
									}
								} else if (tab[h][w] instanceof Mine) {
									iv.setImage(mine);
								}
							}
						} else if (event.getButton() == MouseButton.SECONDARY) {
							if (tab[h][w].getState() == State.HIDDEN) {
								tab[h][w].setState(State.FLAG);
								iv.setImage(flag);
							} else if (tab[h][w].getState() == State.FLAG) {
								tab[h][w].setState(State.HIDDEN);
								iv.setImage(hidden);
							}
						}
					}
				});

				children.add(iv);
			}
		}
		Group root = new Group(children);
		Scene scene = new Scene(root, 410, 410);

		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}

	private void loadImages() {

	}
}
