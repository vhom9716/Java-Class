package arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//ObjectArrays oA = new ObjectArrays();
		Person s = new Person("Ben", "Nockles", Borough.NY_BOROUGHS[0]);
		int x = 10;
		int[] a = {5, 6, 7};
		test(s, x, a);
		System.out.println(s + ", " + x + ", " + Arrays.toString(a));
	}

	
	//PASS BY VALUE EXAMPLES
	//String methods do not change the string objects as they act on a local variable 
	//that has the value of the object.
	public static void test(Person s, int x, int[] arr) {
		/**
		 * This does not change the value of firstName.
		String name = s.getFirstName();
		name = "Ilona";
		**/
		
		s.setFirstName("Ilona"); // This changes the name. It accesses the field which is a reference.
		//Objects have references in the form of fields
		
		
		/**
		 * 
		 * Int cant change permanently through a void method since primitives don't
		 * reference to access data
		 * (You can change if you set a return time)
		 */
		x = 5;
		
		
		/**
		 * as long as you don't make a new array, the references themselves
		 * will change since the indicies are the actual references
		arr = new int [3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		**/
		
		//This changes the array
		//Arrays have references in the forms of indicies
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
	}
}
