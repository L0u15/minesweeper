package fr.imt.llalleau.minesweeper;

import javafx.scene.image.Image;

public class ImagesLoader {

	public static Image hidden;
	public static Image mine;
	public static Image flag;
	public static Image[] numbers;

	public static void loadImages() {
		hidden = new Image("hidden.png", Data.SQUARE_SIZE, Data.SQUARE_SIZE, true, true);
		mine = new Image("mine.png", Data.SQUARE_SIZE, Data.SQUARE_SIZE, true, true);
		flag = new Image("flag.png", Data.SQUARE_SIZE, Data.SQUARE_SIZE, true, true);
		numbers = new Image[9];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Image(i + ".png", Data.SQUARE_SIZE, Data.SQUARE_SIZE, true, true);
		}
	}
}
