package search;

public class LionPuzzle {

	public static void main(String[] args) {
		int lions = 101;
		System.out.println(lions + " lions decide to eat the sheep? " + eatSheepOrNot(lions));
	}

	private static boolean eatSheepOrNot(int lions) {
		if(lions == 1) {
			//no lions to eat you if you eat a sheep
			return true;
		}else {
			//You would eat the sheep knowing the other lions don't eat the sheep
			//figure out what the rest of the lions would do, not including you.
			return !eatSheepOrNot(lions - 1);
			
		}
		
	}
}
