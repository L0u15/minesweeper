package fr.imt.llalleau.minesweeper;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Data {
	// Internal Data
	public static int SQUARE_SIZE = 32;
	public static final int SQUARE_MINUMUM_SIZE = 16;

	public static double SCREEN_HEIGHT = 500;
	public static double SCREEN_WIDTH = 500;

	public static boolean STOP_GAME = false;

	// Configurable Data
	public static int BOARD_HEIGHT = 10;
	public static int BOARD_WIDTH = 10;
	public static int MINES = 5;

	public static void loadProperties() {
		Data.SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		Data.SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = Data.class.getClassLoader().getResourceAsStream("config.properties");
			if (input == null) {
				System.out.println("Sorry, unable to find config file");
				return;
			}
			prop.load(input);
			BOARD_HEIGHT = Integer.parseInt(prop.getProperty("BOARD_HEIGHT"));
			BOARD_WIDTH = Integer.parseInt(prop.getProperty("BOARD_WIDTH"));
			MINES = Integer.parseInt(prop.getProperty("MINES"));

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
