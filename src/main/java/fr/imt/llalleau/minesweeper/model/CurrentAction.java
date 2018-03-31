package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;

public class CurrentAction {
	private static Action action;

	private CurrentAction() {
	}

	public static void add(Action newAction) {
		if (!isNull()) {
			action.setNext(newAction);
			newAction.setPrevious(action);
		}
		action = newAction;

	}

	public static Point getPoint() {
		return action.getPoint();
	}

	public static boolean asPrevious() {
		return action != null;
	}

	public static boolean asNext() {
		if (action == null)
			return false;
		return !action.isLast();
	}

	public static boolean isNull() {
		return action == null;
	}

	public static void undo() {
		if (!isNull())
			action = action.getPrevious();
	}

	public static void redo() {
		if (!isNull())
			action = action.getNext();
	}

	public static void clear() {
		action = null;

	}

}
