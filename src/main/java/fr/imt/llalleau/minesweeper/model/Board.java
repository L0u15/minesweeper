package fr.imt.llalleau.minesweeper.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fr.imt.llalleau.minesweeper.App;
import fr.imt.llalleau.minesweeper.Data;
import fr.imt.llalleau.minesweeper.model.square.Mine;
import fr.imt.llalleau.minesweeper.model.square.Number;
import fr.imt.llalleau.minesweeper.model.square.Square;
import fr.imt.llalleau.minesweeper.model.square.State;

public class Board {

	private final int height;
	private final int width;

	private Square[][] tab;
	private List<Point> minePosition;
	private int nbSquareLeft;

	private final Point[] deltaPoint = { new Point(1, 1), new Point(0, 1), new Point(-1, 1), new Point(-1, 0),
			new Point(+1, 0), new Point(-1, -1), new Point(0, -1), new Point(1, -1) };

	public Board(int h, int w, int nb_mine) throws Exception {

		if (h <= 0 || w <= 0) {
			throw new Exception("Invalid board dimention");
		}

		if (nb_mine >= h * w || nb_mine <= 0) {
			throw new Exception("Invalid mine number");
		}

		this.height = h;
		this.width = w;

		this.tab = new Square[this.height][this.width];
		this.minePosition = new ArrayList<Point>();

		this.nbSquareLeft = h * w;

		this.placeMine(nb_mine);
		this.placeNumberRecursive(new Point(this.width / 2, this.height / 2));

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
		List<Square> SquareAround = this.getSquaresFromPoint(this.getPointAround(point));
		if (this.getSquare(point) == null) {
			int nbMineAround = this.countMine(SquareAround);
			this.setSquare(point, new Number(nbMineAround));
		}
		for (Point newtPoint : this.getPointAround(point)) {
			if (!this.pointIsOutOfBounds(newtPoint) && this.getSquare(newtPoint) == null) {
				this.placeNumberRecursive(newtPoint);
			}
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

	private List<Square> getSquaresFromPoint(List<Point> pointList) {
		List<Square> squareList = new ArrayList<>();
		for (Point point : pointList) {
			if (!this.pointIsOutOfBounds(point)) {
				squareList.add(this.getSquare(point));
			}
		}
		return squareList;
	}

	/**
	 * Return a list of checked point around the given point
	 * 
	 * @param point
	 * @return
	 */
	private List<Point> getPointAround(Point point) {
		List<Point> pointAround = new ArrayList<>();
		Point p;
		for (Point delta : this.deltaPoint) {
			p = new Point(point.x + delta.x, point.y + delta.y);
			if (!this.pointIsOutOfBounds(point)) {
				pointAround.add(p);
			}
		}

		return pointAround;
	}

	public void revealRecursif(Point point) {
		if (this.pointIsOutOfBounds(point)) {
			return;
		}

		// if the square is already revealed, we do nothing
		if (this.getSquare(point).getState().equals(State.REVEALED) || this.getSquare(point).getState().equals(State.FLAG)) {
			return;
		}

		if (this.getSquare(point) instanceof Number) {
			this.getSquare(point).setState(State.REVEALED);
			nbSquareLeft--;
			if (((Number) this.getSquare(point)).getValue() == 0) {
				for (Point p : this.getPointAround(point)) {
					revealRecursif(p);
				}
			}
		}

		if (this.getSquare(point) instanceof Mine) {
			this.getSquare(point).setState(State.REVEALED);
		}
	}

	public void hideRecursif(Point point) {
		if (this.pointIsOutOfBounds(point)) {
			return;
		}
		// if the square is already hide, we do nothing
		if (this.getSquare(point).getState().equals(State.HIDDEN)) {
			return;
		}
		if (this.getSquare(point) instanceof Number) {
			this.getSquare(point).setState(State.HIDDEN);
			nbSquareLeft++;
			if (((Number) this.getSquare(point)).getValue() == 0) {
				for (Point p : this.getPointAround(point)) {
					hideRecursif(p);
				}
			}
		}
		if (this.getSquare(point) instanceof Mine) {
			this.getSquare(point).setState(State.HIDDEN);
		}
	}

	public void checkEndGame(Point lastClick) {
		if (isMine(lastClick)) {
			App.lose();
		} else if(nbSquareLeft == Data.MINES){
			App.win();
		}
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
	public boolean isMine(int h, int w) {
		return tab[h][w] instanceof Mine;
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
