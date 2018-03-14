package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
		this.placeNumberRecursive(new Point(this.width, this.height));

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

	private void placeNumberRecursive(Point point) {
		if (this.pointIsOutOfBounds(point)) {
			return;
		}
		List<Point> pointAround = this.getPointAround(point);
		List<Square> SquareAround = this.getSquaresFromPoint(pointAround);
		if (this.getSquare(point) == null) {
			int nbMineAround = this.countMine(SquareAround);
			this.setSquare(point, new Number(nbMineAround));
		}
		for (Point newtPoint : pointAround) {
			placeNumberRecursive(newtPoint);
		}

	}

	private int countMine(List<Square> squareAround) {
		int count = 0;
		for (Square square : squareAround) {
			if (square instanceof Mine)
				count++;
		}
		return count;
	}

	private boolean pointIsOutOfBounds(Point point) {
		return point.getY() < 0 || point.getY() >= this.height || point.getX() < 0 || point.getX() >= this.width;
	}

	private int countMineAround(Point point) {
		int count = 0;
		List<Square> squareAround = this.getSquareAround(point);
		for (Square square : squareAround) {
			if (square instanceof Mine)
				count++;
		}
		return count;
	}

	private List<Square> getSquareAround(Point centralPoint) {

		List<Square> squareAround = new ArrayList<>();

		List<Point> pointAround = this.getPointAround(centralPoint);

		for (Point point : pointAround) {
			// Check boundaries
			if (!this.pointIsOutOfBounds(point)) {
				squareAround.add(this.getSquare(point));
			}
		}
		return squareAround;
	}

	private List<Point> getPointAround(Point point) {
		List<Point> pointAround = new ArrayList<>();
		pointAround.add(new Point(point.x + 1, point.y + 1));
		pointAround.add(new Point(point.x - 1, point.y + 1));
		pointAround.add(new Point(point.x, point.y + 1));
		pointAround.add(new Point(point.x + 1, point.y));
		pointAround.add(new Point(point.x - 1, point.y));
		pointAround.add(new Point(point.x + 1, point.y - 1));
		pointAround.add(new Point(point.x - 1, point.y - 1));
		pointAround.add(new Point(point.x, point.y - 1));
		return pointAround;
	}

	/**
	 * Doesn't check boundaries
	 * 
	 * @param point
	 * @return
	 */
	public Square getSquare(Point point) {
		return this.tab[point.y][point.x];
	}

	/**
	 * Doesn't check boundaries
	 * 
	 * @param point
	 * @param square
	 */
	public void setSquare(Point point, Square square) {
		this.tab[point.y][point.x] = square;
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

	public boolean isMine(Point point) {
		return this.getSquare(point) instanceof Mine;
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
