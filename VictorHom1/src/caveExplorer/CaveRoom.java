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
	
	public String getDescription() {
		return description;
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
	
	
	
	
	
}
