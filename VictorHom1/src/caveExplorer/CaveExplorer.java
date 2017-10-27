package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;//every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on how the user navigates
	public static Inventory inventory;//where all objects found in the cave are kept
	public static boolean playing = true;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
		
		inventory = new Inventory();
		startExploring();	
	}


	private static void startExploring() {
		while(playing) {
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}

	public static void print(String s) {
		//NOTE later replace line with more sophisticated "multiLinePrint" from Chatbot
		System.out.println(s);
	}
}
