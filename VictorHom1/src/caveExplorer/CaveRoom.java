package caveExplorer;

public class CaveRoom {

	private String description;//tells what the room looks like
	private String directions;//tells what you can do 
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an x when you are inside the room
		//when you leave, it goes back to default contents
		
		//by default object arrays populate with null, meaning there are no extras
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every door in doors[] appends a string to "directions" describing the access.
	 * for example:
	 * "There is a door to the north"
	 * "There is a door to the south"
	 * 
	 * If there are no doors at all, directions should say: "(Whatever you want)"
	 */
	public void setDirections() {
		directions = "";
		boolean areDoors = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				directions += "/n   There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
				areDoors = true;
			}
		}
		if(!areDoors) {
			directions += "There is no way out. You are trapped";
		}
	}

	/**
	 * converts an int into a direction
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] directions = {"the North", "the East", "the South", "the West"};
		return directions[dir];
	}

	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = "defaultContents";
	}
	
	/**
	 * gives this room access to anotherRoom and vice versa
	 * and sets a door between them, updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public static int oppositeDirection(int direction) {
		return (direction + 2) % 4;
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printAllowedEntry();
			input = CaveExplorer.in.nextLine();
		}
		String directions = validKeys();
		respondToKey(directions.indexOf(input));
	}
	
	/**
	 * override to add more keys, but always include 'wdsa'
	 * @return
	 */
	public String validKeys() {
		return "wdsa";
	}
	
	/**
	 * override to print a custom string describing what keys do. 
	 * 
	 */
	public void printAllowedEntry() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
	}

	private boolean isValid(String input) {
		String validEntries = validKeys();
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}

	private void respondToKey(int direction) {
		//first, protect against null pointer exception
		//(user cannot go through non existent door
		if(direction < 4) {
			if(borderingRooms[direction] != null && doors[direction] != null) {
				CaveExplorer.currentRoom.leave();
				CaveExplorer.currentRoom = borderingRooms[direction];
				CaveExplorer.currentRoom.enter();
				CaveExplorer.inventory.updateMap();
			}
		}else {
			performAction(direction);
		}
		
	}
	/**
	 * override to give response to keys other than wsad
	 * @param direction
	 */
	public void performAction(int direction) {
		System.out.println("That key does nothing.");
	}

	/**
	 * this will be where your group sets up all of the caves and all of the connections
	 */
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		//1. Decide how big your caves will be.
		CaveExplorer.caves = new CaveRoom[10][10];
		//2. Populate with caves and a default description: hint when starting, use coordinates
		for(int row = 0; row < CaveExplorer.caves.length; row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE: 
			for(int col = 0; col < CaveExplorer.caves[0].length; col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has coords ("+row+", " +col+")"); 
			}
		}
		//3. Replace default rooms with custom rooms
		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
	}

	public String getDescription() {
		return description + "\n" + directions;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Door getDoor(int direction) {
		return doors[direction];
	}
	
	
	
	
	
}
