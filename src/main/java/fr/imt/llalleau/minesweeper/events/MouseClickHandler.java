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
			App.board.revealRecursif(new Point(w, h));
			App.gBoard.updateImages();
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
