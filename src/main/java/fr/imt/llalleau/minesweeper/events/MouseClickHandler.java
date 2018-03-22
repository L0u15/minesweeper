package fr.imt.llalleau.minesweeper.events;

import java.awt.Point;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Constants;
import fr.imt.llalleau.minesweeper.ImagesLoader;
import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Number;
import fr.imt.llalleau.minesweeper.model.square.State;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseClickHandler extends MouseHandler  {

	

	public MouseClickHandler(ImageView iv_) {
		super(iv_);
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getButton() == MouseButton.PRIMARY) {
			if (tab[h][w].getState() == State.HIDDEN) {
				tab[h][w].setState(State.REVEALED);
				if (tab[h][w] instanceof Number) {
					int n = ((Number) tab[h][w]).getValue();
					iv.setImage(ImagesLoader.numbers[n]);
					if (((Number) tab[h][w]).getValue() == 0) {
						App.board.revealRecursif(new Point(h, w));
					}
				} else if (tab[h][w] instanceof Mine) {
					iv.setImage(ImagesLoader.mine);
				}
			}
		} else if (event.getButton() == MouseButton.SECONDARY) {
			if (tab[h][w].getState() == State.HIDDEN) {
				tab[h][w].setState(State.FLAG);
				iv.setImage(ImagesLoader.flag);
			} else if (tab[h][w].getState() == State.FLAG) {
				tab[h][w].setState(State.HIDDEN);
				iv.setImage(ImagesLoader.hidden);
			}
		}
	}
}
