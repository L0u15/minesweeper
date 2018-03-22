package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;

public class Action {
	// Double linked list
	// For undo & redo
	private Point point;
	private Action next;
	private Action previous;

	public Action(Point point) {
		this.point = point;
	}

	public Action(Point point, Action previous) {
		this(point);
		this.previous = previous;
		this.previous.setNext(this);
	}

	public Point getPoint() {
		return point;
	}

	public Action getNext() {
		return next;
	}

	public void setNext(Action next) {
		this.next = next;
	}

	public Action getPrevious() {
		return previous;
	}

	public boolean isFirst() {
		return this.previous == null;
	}

	public boolean isLast() {
		return this.next == null;
	}

}
