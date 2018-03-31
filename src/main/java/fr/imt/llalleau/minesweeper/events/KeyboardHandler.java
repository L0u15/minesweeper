package fr.imt.llalleau.minesweeper.events;

import java.awt.Point;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Data;
import fr.imt.llalleau.minesweeper.model.CurrentAction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.LEFT) {
			// TODO : undo
			System.out.println("UNDO");
			Data.STOP_GAME = false;
			Point point = CurrentAction.getPoint();
			App.board.hideRecursif(point);
			App.gBoard.updateImages();
			CurrentAction.undo();
			keyEvent.consume();
		} else if (keyEvent.getCode() == KeyCode.RIGHT) {
			// TODO : redo
			System.out.println("REDO");
			// Ne pas oublier de checkEndGame a chaque redo
			// App.board.checkEndGame(lastClick);
			keyEvent.consume();
		}

	}

}
