package fr.imt.llalleau.minesweeper.model.square;

public class Number extends Square {
	private int value;

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
