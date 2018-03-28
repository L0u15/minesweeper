package fr.imt.llalleau.minesweeper.graphics;

import java.util.LinkedList;
import java.util.List;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Constants;
import fr.imt.llalleau.minesweeper.ImagesLoader;
import fr.imt.llalleau.minesweeper.events.KeyboardHandler;
import fr.imt.llalleau.minesweeper.events.MouseClickHandler;
import fr.imt.llalleau.minesweeper.events.MouseHoverHandler;
import fr.imt.llalleau.minesweeper.model.Board;
import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Number;
import fr.imt.llalleau.minesweeper.model.square.Square;
import fr.imt.llalleau.minesweeper.model.square.State;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class GraphicalBoard {

	Board board;
	Square[][] tab;
	ImageView[][] imageViewTab;

	public GraphicalBoard() {
		board = App.board;
		tab = App.board.getTab();
		imageViewTab = new ImageView[Constants.BOARD_HEIGHT][Constants.BOARD_WIDTH];
	}

	public List<Node> createBoard() {
		List<Node> cases = new LinkedList<>();

		for (int h = 0; h < Constants.BOARD_HEIGHT; h++) {
			for (int w = 0; w < Constants.BOARD_WIDTH; w++) {
				final ImageView iv = new ImageView(ImagesLoader.hidden);
				iv.setX(w * iv.getImage().getWidth());
				iv.setY(h * iv.getImage().getHeight());

				iv.setOnMouseEntered(new MouseHoverHandler(iv));
				iv.setOnMouseExited(new MouseHoverHandler(iv));
				iv.setOnMouseClicked(new MouseClickHandler(iv));
				iv.setOnKeyPressed(new KeyboardHandler());

				cases.add(iv);
				imageViewTab[h][w] = iv;
			}
		}
		return cases;
	}

	public void updateImages() {
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[x].length; y++) {
				ImageView v = getImageView(x, y);
				if (tab[x][y].getState() == State.HIDDEN) {
					if (tab[x][y] instanceof Number) {
						int n = ((Number) tab[x][y]).getValue();
						v.setImage(ImagesLoader.numbers[n]);
						if (((Number) tab[x][y]).getValue() == 0) {

						}
					} else if (tab[x][y] instanceof Mine) {
						System.out.println("BINGO");
						v.setImage(ImagesLoader.mine);
					}
				}
			}

		}
	}

	private ImageView getImageView(int x, int y) {
		return imageViewTab[x][y];
	}

}
