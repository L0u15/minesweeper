package fr.imt.llalleau.minesweeper.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class CurrentActionTest {
	@Test
	public void isNullTest() {
		CurrentAction currentAction = new CurrentAction();
		assertTrue(currentAction.isNull());
	}

	@Test
	public void isFirstTest() {
		CurrentAction currentAction = new CurrentAction();
		currentAction.add(new Point(1, 1));
		assertTrue(currentAction.isLast());
	}

	@Test
	public void isLastTest() {
		CurrentAction currentAction = new CurrentAction();
		currentAction.add(new Point(1, 1));
		assertTrue(currentAction.isLast());
	}

	@Test
	public void getPointTest() {
		CurrentAction currentAction = new CurrentAction();
		Point point = new Point(1, 1);
		currentAction.add(point);
		assertEquals(point, currentAction.getPoint());
	}
	
	@Test
	public void undoTest() {
		CurrentAction currentAction = new CurrentAction();
		Point point = new Point(1, 1);
		currentAction.add(point);
		currentAction.add(new Point(2,2));
		currentAction.undo();
		assertEquals(point, currentAction.getPoint());
	}
	
	@Test
	public void redoTest() {
		CurrentAction currentAction = new CurrentAction();
		Point point = new Point(1, 1);
		Point point2 = new Point(2,2);

		currentAction.add(point);
		currentAction.add(point2);
		currentAction.undo();
		currentAction.redo();
		assertEquals(point2, currentAction.getPoint());
	}

}
