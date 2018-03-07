package fr.imt.llalleau.minesweeper.model;

import org.junit.Test;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

	@Test
	public void constructorTest() {
		Board board = new Board(10, 10, 10);
		System.out.println(board);
	}

}
