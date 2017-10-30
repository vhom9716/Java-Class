package caveExplorer;

public class TwoDArrayPractice {

	
	
	
	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[0].length; col++) {
				pic[row][col] = " ";
			}
		}
		//drawHorizontalLine(pic, 1);
		//drawVerticalLine(pic, 2);
		drawBox(pic, 4, 2);
		print(pic);
	}
	
	/**
	 * Box looks like this:
	 * ___
	 * |*|
	 * |_|
	 * The * marks the coordinates of the box 
	 * CATCH: No ArrayIndexOutOfBoundsExceptions
	 * Draw any portion of the box that fits around the asterisk
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawBox(String[][] pic, int i, int j) {
		drawSlot(pic, i, j);
		drawSlot(pic, i + 1, j);
		drawIfInBounds("_", pic, i + 1,j);
		for(int col = j - 1; col <= j + 1; col++) {
			drawIfInBounds("_", pic, i - 1, j);
		}
	}

	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		//Always check row before column
		if(i >= 0 && i < pic.length && j >= 0 && j < pic.length) {
			pic[i][j] = string;
		}
		
	}

	/**
	 * A slot looks like this:
	 * | |
	 * It is two vertical lines with a space between it
	 * The coordinates i,j are coordinates of the space
	 * In other words, a slot is a vertical line in front of i, j and after i, j
	 * CATCH: No ArrayIndexOutOfBoundsExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		if(i >= 0 && i < pic.length) {
			if(j > 0) {
				pic[i][j - 1] = "|";
			}
			if(j < pic[i].length - 1) {
				pic[i][j + 1] = "|";
			}
		}
	}
	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
		
	}
	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int col = 0; col < pic[row].length; col++) {
			pic[row][col] = "-";
		}
	}
	/**
	 * prints contents of pic, row by row
	 * NO BRACKETS OR COMMAS
	 * @param pic
	 */
	private static void print(String[][] pic) {
		String line = "";
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[0].length; col++) {
				line += pic[row][col];
			}
			line += "\n";
		}
		System.out.println(line);
	}

}
