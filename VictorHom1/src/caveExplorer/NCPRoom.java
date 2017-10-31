package caveExplorer;

public class NCPRoom extends CaveRoom {

	private NPC presentNPC;
	
	public NCPRoom(String description) {
		super(description);
		presentNPC = null;
	}
	
	public boolean canEnter() {
		//can change rules later
		//can't enter if an NPC is already inside
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	
	public void exitNPC() {
		presentNPC = null;
	}

	/**
	 * canEnter() is already like this, but it is helpful to have another way of referring to it. 
	 * Additionally, the rules of canEnter() may change to no longer be useful for this
	 * @return
	 */
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	//The above methods are NEW features to a CaveRoom
	
	//The methods below REPLACE CaveRoom methods. (override)
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w', 'a', 's', or 'd' to move or, you can enter 'e' to interact.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "M";
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && presentNPC.isActive()) {
			return super.getDescription() + "\n" + presentNPC.getInactiveDescription();	
		}else {
			return super.getDescription();
		}
	}
	
	
}
