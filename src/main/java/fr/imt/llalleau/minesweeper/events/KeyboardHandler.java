package fr.imt.llalleau.minesweeper.events;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import javafx.event.EventHandler;

public class KeyboardHandler implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.LEFT) {
			//TODO : undo
            keyEvent.consume();
        }else if(keyEvent.getCode() == KeyCode.RIGHT){
        	//TODO : redo
            keyEvent.consume();
        }

	}

}
