package fr.imt.llalleau.minesweeper.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;
import javafx.scene.input.MouseButton;

public class ActionTest {

	@Test
	public void isFirstTest() {
		Action action = new Action(new Point(1, 1), MouseButton.PRIMARY);
		assertTrue(action.isFirst());
		assertTrue(action.isLast());

	}

	@Test
	public void getPreviousTest() {
		int x = 4;
		int y = 5;
		Point point = new Point(x, y);
		Action action = new Action(point, MouseButton.PRIMARY);
		int x2 = 4;
		int y2 = 5;
		Action action2 = new Action(new Point(x2, y2), MouseButton.PRIMARY, action);
		assertEquals(action, action2.getPrevious());
		assertEquals(null, action.getPrevious());
	}

	@Test
	public void getNextTest() {
		int x = 4;
		int y = 5;
		Point point = new Point(x, y);
		Action action = new Action(point, MouseButton.PRIMARY);
		int x2 = 4;
		int y2 = 5;
		Action action2 = new Action(new Point(x2, y2), MouseButton.PRIMARY, action);
		assertEquals(action2, action.getNext());
		assertEquals(null, action2.getNext());
	}

}
