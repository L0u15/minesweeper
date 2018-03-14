package fr.imt.llalleau.minesweeper.events;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Constants;
import fr.imt.llalleau.minesweeper.model.square.Square;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class MouseHandler implements EventHandler<MouseEvent>{
	protected ImageView iv;
	protected Square[][] tab;
	int w, h;

	public MouseHandler(ImageView iv_) {
		iv = iv_;
		tab = App.board.getTab();
		w = (int) getCoord().getX();
		h = (int) getCoord().getY();
	}
	
	protected Point2D getCoord() {
		return new Point2D(iv.getX() / Constants.SQUARE_DEFAULT_WIDTH, iv.getY() / Constants.SQUARE_DEFAULT_HEIGHT);
	}
}
