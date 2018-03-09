package fr.imt.llalleau.minesweeper.model.square;

public class Number extends Square {
	private int value;

	public Number() {
		super();
		this.value = 0;
	}

	public Number(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Increment value
	 */
	public void incValue() {
		this.value++;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
