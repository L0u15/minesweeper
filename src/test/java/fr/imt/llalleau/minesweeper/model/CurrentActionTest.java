package fr.imt.llalleau.minesweeper.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import javafx.scene.input.MouseButton;

public class CurrentActionTest {

	@Before
	public void clear() {
		CurrentAction.clear();
	}

	@Test
	public void isNullTest() {
		assertTrue(CurrentAction.isNull());
	}

	@Test
	public void asPreviousTest() {
		CurrentAction.add(new Action(new Point(1, 1), MouseButton.PRIMARY));
		assertTrue(CurrentAction.asPrevious());
	}

	@Test
	public void asNextTest() {
		CurrentAction.add(new Action(new Point(1, 1), MouseButton.PRIMARY));
		assertFalse(CurrentAction.asNext());
	}

	@Test
	public void getPointTest() {
		Point point = new Point(1, 1);
		CurrentAction.add(new Action(point, MouseButton.PRIMARY));
		assertEquals(point, CurrentAction.getPoint());
	}

	@Test
	public void undoTest() {
		Point point = new Point(1, 1);
		Point point2 = new Point(2, 2);
		CurrentAction.add(new Action(point, MouseButton.PRIMARY));
		CurrentAction.add(new Action(point2, MouseButton.PRIMARY));
		CurrentAction.undo();
		assertEquals(point, CurrentAction.getPoint());
	}

	@Test
	public void redoTest() {
		Point point = new Point(1, 1);
		Point point2 = new Point(2, 2);

		CurrentAction.add(new Action(point, MouseButton.PRIMARY));
		CurrentAction.add(new Action(point2, MouseButton.PRIMARY));
		CurrentAction.undo();
		CurrentAction.redo();
		assertEquals(point2, CurrentAction.getPoint());
	}

}
