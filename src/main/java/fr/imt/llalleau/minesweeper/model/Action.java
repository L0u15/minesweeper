package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;

public class Action {
	
	private Point point;
	private Action previous;

	public Action(Point point) {
		this.point = point;
	}

	public Action(Point point, Action previous) {
		this(point);
		this.previous = previous;
	}

	public Point getPoint() {
		return point;
	}

	public Action getPrevious() {
		return previous;
	}

	public boolean isFirst() {
		return this.previous == null;
	}
}
