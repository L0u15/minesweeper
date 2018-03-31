package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;
import javafx.scene.input.MouseButton;

public class Action {
	// Double linked list for undo & redo
	private Point point;
	private MouseButton mouseButton;
	private Action next;
	private Action previous;

	public Action(Point point, MouseButton mouseButton) {
		this.point = point;
		this.mouseButton = mouseButton;
	}

	public Action(Point point, MouseButton mouseButton, Action previous) {
		this(point, mouseButton);
		this.previous = previous;
		if (this.previous != null)
			this.previous.setNext(this);
	}

	public Point getPoint() {
		return point;
	}

	public MouseButton getMouseButton() {
		return mouseButton;
	}

	public Action getNext() {
		return next;
	}

	public void setNext(Action next) {
		this.next = next;
	}

	public void setPrevious(Action previous) {
		this.previous = previous;
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

	@Override
	public String toString() {
		return "[x=" + this.point.x + ",y=" + this.point.y + "," + mouseButton + "]-->"
				+ (this.isFirst() ? "NULL" : this.previous.toString());
	}
}
