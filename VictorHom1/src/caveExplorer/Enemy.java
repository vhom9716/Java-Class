package caveExplorer;

public class Enemy extends NPC{

	private int HP;
	private int attack;
	private String attackDescription;
	private String deadDescription;
	private boolean alive;
	private boolean isMobile;
	
	public Enemy(int startHP, String attackDesc, String deadDesc, boolean mobile, int attack) {
		HP = startHP;
		attackDescription = attackDesc;
		deadDescription = deadDesc;
		isMobile = mobile;
		this.attack = attack;
	}
	
	//attacks player if they are in the same room
	public void interact() {
		if(alive) {
			CaveExplorer.print(attackDescription);
			battle();
		}else {
			CaveExplorer.print(deadDescription);
		}
	}
	
	public void battle() {
		int damage = attack;
		int playerAttack = Inventory.getAttack();
		Inventory.changeHP()
	}
}
