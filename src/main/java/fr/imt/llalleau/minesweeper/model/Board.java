package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Number;
import fr.imt.llalleau.minesweeper.model.square.Square;

public class Board {

	private final int height;
	private final int width;

	private Square[][] tab;
	private List<Point> minePosition;

	public Board(int x, int y, int nb_mine) throws Exception {

		if (x <= 0 || y <= 0) {
			throw new Exception("Invalid board dimention");
		}

		if (nb_mine >= x * y || nb_mine <= 0) {
			throw new Exception("Invalid mine number");
		}

		this.height = y;
		this.width = x;

		this.tab = new Square[this.height][this.width];
		this.minePosition = new ArrayList<Point>();

		this.placeMine(nb_mine);
		this.placeZero();
		this.placeNumber();

	}

	public void placeMine(int nb_mine) {
		Random rand = new Random();
		do {
			int rand_h = rand.nextInt(this.height);
			int rand_w = rand.nextInt(this.width);

			Square randSquare = this.tab[rand_h][rand_w];

			if (!(randSquare instanceof Mine)) {
				this.tab[rand_h][rand_w] = new Mine();
				this.minePosition.add(new Point(rand_w, rand_h));
				nb_mine--;
			}
		} while (nb_mine > 0);
	}

	private void placeNumber() {
		// TODO Auto-generated method stub

	}

	public void placeZero() {
		for (int h = 0; h < this.height; h++) {
			for (int w = 0; w < this.width; w++) {
				Square square = this.tab[h][w];
				if (square == null) {
					this.tab[h][w] = new Number();
				}
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int h = 0; h < this.height; h++) {
			for (int w = 0; w < this.width; w++) {
				s += this.tab[h][w].toString();
			}
			s += "\n";
		}
		return s;
	}

	/**
	 * 
	 * @param x
	 *            : width index
	 * @param y
	 *            : height index
	 */
	public boolean isMine(int x, int y) {
		return tab[y][x] instanceof Mine;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Square[][] getTab() {
		return this.tab;
	}

	public List<Point> getMinePosition() {
		return this.minePosition;
	}
}
