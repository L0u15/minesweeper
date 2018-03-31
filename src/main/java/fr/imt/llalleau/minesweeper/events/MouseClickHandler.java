package fr.imt.llalleau.minesweeper.events;

import java.awt.Point;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Data;
import fr.imt.llalleau.minesweeper.ImagesLoader;
import fr.imt.llalleau.minesweeper.model.Action;
import fr.imt.llalleau.minesweeper.model.CurrentAction;
import fr.imt.llalleau.minesweeper.model.square.State;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseClickHandler extends MouseHandler {

	public MouseClickHandler(ImageView iv_) {
		super(iv_);
	}

	@Override
	public void handle(MouseEvent event) {
		if (!Data.STOP_GAME) {
			Point point = new Point(w, h);
			Action action = new Action(point, event.getButton());
			if (event.getButton() == MouseButton.PRIMARY) {
				CurrentAction.add(action);
				App.board.revealRecursif(new Point(w, h));
				App.gBoard.updateImages();
				App.board.checkEndGame(new Point(w, h));
				System.out.println(action);
			} else if (event.getButton() == MouseButton.SECONDARY) {
				CurrentAction.add(action);
				if (tab[h][w].getState() == State.HIDDEN) {
					tab[h][w].setState(State.FLAG);
					iv.setImage(ImagesLoader.flag);
				} else if (tab[h][w].getState() == State.FLAG) {
					tab[h][w].setState(State.HIDDEN);
					iv.setImage(ImagesLoader.hidden);
				}
				System.out.println(action);
			}
		}
	}
}
