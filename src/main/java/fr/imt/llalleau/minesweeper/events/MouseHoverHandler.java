package fr.imt.llalleau.minesweeper.events;

import fr.imt.llalleau.minesweeper.Constants;
import fr.imt.llalleau.minesweeper.model.square.State;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MouseHoverHandler extends MouseHandler {

	public MouseHoverHandler(ImageView iv_) {
		super(iv_);
	}

	@Override
	public void handle(MouseEvent event) {
		if (event.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
			int w, h;
			w = (int) iv.getX() / (Constants.SQUARE_WIDTH + Constants.SQUARE_SPACING);
			h = (int) iv.getY() / (Constants.SQUARE_HEIGHT + Constants.SQUARE_SPACING);
			if (tab[h][w].getState() == State.HIDDEN || tab[h][w].getState() == State.FLAG) {
				iv.setOpacity(0.6f);
			}
		}else if (event.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
			int w, h;
			w = (int) iv.getX() / (Constants.SQUARE_WIDTH + Constants.SQUARE_SPACING);
			h = (int) iv.getY() / (Constants.SQUARE_HEIGHT + Constants.SQUARE_SPACING);
			iv.setOpacity(1.f);
		}
	}
}
