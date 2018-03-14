package fr.imt.llalleau.minesweeper;

import javafx.scene.image.Image;

public class ImagesLoader {

	
	public static Image hidden;
	public static Image mine;
	public static Image flag;
	public static Image[] numbers;
	
	public static void loadImages() {
		hidden = new Image("hidden.png");
		mine = new Image("mine.png");
		flag = new Image("flag.png");
		numbers = new Image[9];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new Image(i + ".png");
		}
	}
}
