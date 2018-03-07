package fr.imt.llalleau.minesweeper.model;

import java.util.Random;

import fr.imt.llalleau.minesweeper.model.square.Blank;
import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Square;

public class Board {

	private final int height;
	private final int width;

	private Square[][] board;

	public Board(int height, int width, int nb_mine) {

		this.height = height;
		this.width = width;

		this.board = new Square[this.height][this.width];

		this.placeMine(nb_mine);
		this.placeNumber();
		this.placeBlank();
	}

	public void placeMine(int nb_mine) {
		Random rand = new Random();
		do {
			int rand_h = rand.nextInt(this.height);
			int rand_w = rand.nextInt(this.width);

			Square randSquare = this.board[rand_h][rand_w];

			if (!(randSquare instanceof Mine)) {
				this.board[rand_h][rand_w] = new Mine();
				nb_mine--;
			}
		} while (nb_mine > 0);
	}

	private void placeNumber() {
		// TODO Auto-generated method stub

	}

	public void placeBlank() {
		for (int h = 0; h < this.height; h++) {
			for (int w = 0; w < this.width; w++) {
				Square square = this.board[h][w];
				if (square == null) {
					this.board[h][w] = new Blank();
				}
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int h = 0; h < this.height; h++) {
			for (int w = 0; w < this.width; w++) {
				s += this.board[h][w].toString();
			}
			s += "\n";
		}
		return s;
	}

}
