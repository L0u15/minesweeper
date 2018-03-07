package fr.imt.llalleau.minesweeper.model.square;

public abstract class Square {
	private State state;

	public Square() {
		this.state = State.HIDDEN;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
