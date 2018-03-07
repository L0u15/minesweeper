package fr.imt.llalleau.minesweeper;

import fr.imt.llalleau.minesweeper.model.Board;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Board board = new Board(10, 10, 10);
		System.out.println(board);
	}
}
