package caveExplorer;

public class NPC {

	private CaveRoom[][] floor; //where the NPC roams
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	
	
	//default constructor
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person waiting to talk to you";
		this.inactiveDescription = "The person you spoke to earlier is standing here";
		//to indicate the NPC dpesn't have a position yet, use coords -1,-1
		this.currentCol = -1;
		this.currentRow = -1;
		this.currentRoom = null;
		this.active = true;
	}
	/**
	 * You can make custom constructors later that use different parameters
	 * @return
	 */
	
	public boolean isActive() {
		return active;
	}
	
	public void setPosition(int row, int col){
		if(row >= 0 && row < floor.length && col >= 0 && col < floor[row].length && floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC;
			}
			currentRow = row; 
			currentCol= col;
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);		
		}
	}
	public void interact() {
		CaveExplorer.print(" Hi! I'm and NPC.";
		String s = CaveExplorer atkj
	}

	public String getInactiveDescription() {
		
		return inactiveDescription;
	}

	public String getActiveDescription() {
		
		return null; activeDescription
	}

}
