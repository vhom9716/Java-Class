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
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
		
	}

	private static void npcActions() {
		// TODO Auto-generated method stub
		
	}


	public static void print(String s) {
		for(MOC n: npc) {
			n.act();
			inventory.udpateMap;
		}
	}
	
	public void act() {
		if(avtive) {
			int[] movr = calculateMovement();
			int newRom = currentRow + move[0];
			int newCol = currentCol +1;
			setPostition(newRo, new col)
							
		}
	}


	private int[] calculateMovement() {
		int[] moves = new int[2];
		int[][] possibleMoves = {{-1,0}, {0,-1};
		int rand = (int)(Math.random()*4);
		}
	}
}
