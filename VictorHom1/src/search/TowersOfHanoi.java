package search;

public class TowersOfHanoi {

	public static void main(String[] args) {
		towersOfHanoi(5, "start", "helper", "end");
	}
	
	public static void towersOfHanoi(int disks, String start, String helper, String end) {
		if(disks == 1) {
			System.out.println(start + disks + " to " + end);
		}else {
			//first the function executes itself for disks - 1, and swaps the helper and end location 
			//which swaps every time the prior function executes another level at disks - 1 until 
			//it reaches the base case.
			//Then after that , it moves the next largest disk on the start pile
			//Then it initiates another iteration of towersOfHanoi like previously forming a copy of the previous iteration
			//except every start in the previous iteration is replaced with helper, helper with end, and end with start. 
			//Then it expands back out to the higher levels of functions where it moves the next largest disk and then continues
			towersOfHanoi(disks - 1, start, end, helper);
			System.out.println(start + disks + " to " + end);
			towersOfHanoi(disks - 1, helper, start, end);
		}
	}
}
