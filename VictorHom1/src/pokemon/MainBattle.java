package pokemon;

public class MainBattle{
	
	public static void main(String[] args) {
		Pokemon squirtle = new Pokemon("Squirtle",26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		squirtle.iChooseYou();	
		bulbasaur.iChooseYou();
		squirtle.setHP(100);
		bulbasaur.setHP(100);
		System.out.println("Squirtle is preparing to attack with water blast");
		squirtle.attack(bulbasaur, new Attack() {

			public void attack(Pokemon target) {
				int hp = target.getHP();
				target.setHP(hp/2);
			}
		});
		System.out.println("Bulbasaur is preparing to attack with poison.");
		bulbasaur.attack(squirtle, new Attack() {

			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}
		});
		squirtle.lapse();
		bulbasaur.lapse();
		printScore(squirtle, bulbasaur);
		System.out.println("Squirtle is attacking again");
		//With the anonymous inner type, you have to define the method in the interface so it can be passed in.
		squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int oldHP = target.getHP();
				target.setHP(oldHP - 1);	
			}
		});
		printScore(squirtle, bulbasaur);
		
		bulbasaur.evelove
	}

	private static void printScore(Pokemon squirtle, Pokemon bulbasaur) {
		System.out.println(squirtle.getName() + ", HP = " + squirtle.getHP());
		System.out.println(bulbasaur.getName() + ", HP = " + bulbasaur.getHP());
		
	}
}