package fr.imt.llalleau.minesweeper.events;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.model.square.Square;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class MouseHandler implements EventHandler<MouseEvent>{
	protected ImageView iv;
	protected Square[][] tab;
	
	public MouseHandler(ImageView iv_) {
		iv = iv_;
		tab = App.board.getTab();
	}
}
