package fr.imt.llalleau.minesweeper.events;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent keyEvent) {
		if (keyEvent.getCode() == KeyCode.LEFT) {
			//TODO : undo
			System.out.println("UNDO");
            keyEvent.consume();
        }else if(keyEvent.getCode() == KeyCode.RIGHT){
        	//TODO : redo
			System.out.println("REDO");
            keyEvent.consume();
        }

	}

}
