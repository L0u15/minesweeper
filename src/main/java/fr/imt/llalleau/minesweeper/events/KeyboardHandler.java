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
			System.out.println("UNDO");
			Data.STOP_GAME = false;
			if (CurrentAction.asPrevious()) {
				Point point = CurrentAction.getPoint();
				App.board.hideRecursif(point);
				App.gBoard.updateImages();
				CurrentAction.undo();
			}
		} else if (keyEvent.getCode() == KeyCode.RIGHT) {
			System.out.println("REDO");
			if (CurrentAction.asNext()) {
				CurrentAction.redo();
				Point point = CurrentAction.getPoint();
				App.board.revealRecursif(point);
				App.gBoard.updateImages();
				App.board.checkEndGame(point);
			}
		}
		keyEvent.consume();

	}

}
