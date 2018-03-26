package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;

public class CurrentAction {
	private Action action;

	public CurrentAction() {
		this.action = null;
	}

	public void add(Point point) {
		Action newAction = new Action(point, this.action);
		this.action = newAction;
	}

	public Point getPoint() {
		return this.action.getPoint();
	}

	public boolean isFirst() {
		return this.action.isFirst();
	}

	public boolean isLast() {
		return this.action.isLast();
	}

	public boolean isNull() {
		return this.action == null;
	}

	public void undo() {
		this.action = this.action.getPrevious();
	}

	public void redo() {
		this.action = this.action.getNext();
	}

	public String toString() {
		return this.action.toString();
	}

}
